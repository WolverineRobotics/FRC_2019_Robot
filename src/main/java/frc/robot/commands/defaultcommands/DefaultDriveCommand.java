package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.AutoHatchDeliverCommand;
import frc.robot.commands.autonomouscommands.ExecuteAfterWaitCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.commands.autonomouscommands.RotateToVisionTargetCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.commands.commandgroups.TestAuto;
import frc.robot.constants.JoystickMap;
import frc.robot.constants.RobotConst;
import frc.robot.oi.OI;
import frc.robot.subsystems.DriveSubsystem;
import frc.util.Util;

public class DefaultDriveCommand extends Command {
    
    private DriveSubsystem c_drive;

    public DefaultDriveCommand() {
        c_drive = Robot.getDriveSubsystem();
        requires(c_drive);
    }

    @Override
    protected void execute() {
        // Driver Left Stick Y and Driver Right Stick X
        double throttle = OI.getDriverThrottle();
        double turn = OI.getDriverTurn();

        double leftSpeed = 0;
        double rightSpeed = 0;

        leftSpeed = throttle - turn;
        rightSpeed = throttle + turn;

        if(OI.getFineControl()){
            //If fine control is active.
            c_drive.setRawSpeeds(leftSpeed*0.3, -rightSpeed*0.3);
        } else {
            c_drive.setRawSpeeds(leftSpeed*RobotConst.DRIVE_SPEED_REDUCTION_RATIO, -rightSpeed*RobotConst.DRIVE_SPEED_REDUCTION_RATIO);
        }

        // Driver POV
        if(OI.getDriver().getPOV() != -1){
            System.out.println("Starting rotate command");
            Scheduler.getInstance().add(new RotateToHeadingCommand(-OI.getDriver().getPOV()));
        }

        // Driver Button X
        if(OI.getDriverAutoAlign()){
            Scheduler.getInstance().add(new SetIntakeRotateCommand(-10, 1));
            Scheduler.getInstance().add(new ExecuteAfterWaitCommand(1, new RotateToVisionTargetCommand()));
        }

        // Driver Left Bumper
        if(OI.getTest().getRawButton(JoystickMap.BUTTON_SELECT)) {
            c_drive.resetEncoders();
            c_drive.pigeon.setYaw(0);
        }
    }


    
    @Override
    protected boolean isFinished() {
        return false;
    }
}