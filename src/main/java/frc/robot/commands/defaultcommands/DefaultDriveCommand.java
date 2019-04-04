package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.DriveTowardsVisionTargetCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.constants.JoystickMap;
import frc.robot.constants.RobotConst;
import frc.robot.oi.OI;
import frc.robot.subsystems.CameraSubsystem;
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

        if (Math.abs(throttle) < RobotConst.DRIVE_THORTTLE_TRIGGER_VALUE) {
            throttle = 0;
        }

        if (Math.abs(turn) < RobotConst.DRIVE_TURN_TRIGGER_VALUE) {
            turn = 0;
        }


        leftSpeed = throttle - turn;
        rightSpeed = throttle + turn;
        
        c_drive.setRawSpeeds(leftSpeed*RobotConst.DRIVE_SPEED_REDUCTION_RATIO, -rightSpeed*RobotConst.DRIVE_SPEED_REDUCTION_RATIO);

        if(OI.getDriver().getPOV() != -1){
            System.out.println("Starting rotate command");
            Scheduler.getInstance().add(new RotateToHeadingCommand(OI.getDriver().getPOV()));
        }

        if(OI.getDriverRequestionHatchLED()){
            // Scheduler.getInstance().add(new TestAuto());
            // Scheduler.getInstance().add(new DriveTowardsVisionTargetCommand(5));
            Scheduler.getInstance().add(new RotateToHeadingCommand(c_drive.getPigeonHeading() - Robot.m_camera.getDegreesOff()));
        }
        if(OI.getDriver().getRawButton(JoystickMap.BUTTON_LEFT_BUMPER)) {
            c_drive.resetEncoders();
            // c_drive.resetHeading();
            c_drive.pigeon.setYaw(0);
        }
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }
}