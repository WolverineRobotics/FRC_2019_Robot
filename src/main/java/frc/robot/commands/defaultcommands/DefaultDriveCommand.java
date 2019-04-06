package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.constants.JoystickMap;
import frc.robot.constants.RobotConst;
import frc.robot.oi.OI;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends Command {
    
    private DriveSubsystem c_drive;

    public DefaultDriveCommand() {
        c_drive = Robot.getDriveSubsystem();
        requires(c_drive);
    }

    @Override
    protected void execute() {
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
            c_drive.setRawSpeeds(leftSpeed*0.7, -rightSpeed*0.7);
        }
    
        c_drive.setRawSpeeds(leftSpeed*RobotConst.DRIVE_SPEED_REDUCTION_RATIO, -rightSpeed*RobotConst.DRIVE_SPEED_REDUCTION_RATIO);

        if(OI.getDriver().getPOV() != -1){
            System.out.println("Starting rotate command");
            Scheduler.getInstance().add(new RotateToHeadingCommand(-OI.getDriver().getPOV()));
        }

        if(OI.getDriverAutoAlign()){
            Scheduler.getInstance().add(new RotateToHeadingCommand(c_drive.getPigeonHeading() - Robot.m_camera.getDegreesOff()));
        }

        if(OI.getDriver().getRawButton(JoystickMap.BUTTON_LEFT_BUMPER)) {
            c_drive.resetEncoders();
            c_drive.pigeon.setYaw(0);
        }
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }
}