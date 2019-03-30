package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
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
        
        if(Robot.getClimbSubsystem().getClimbLocked()){
            c_drive.setRawSpeeds(leftSpeed*0.5, -rightSpeed*0.5);
        } else {
            c_drive.setRawSpeeds(leftSpeed*0.7, -rightSpeed*0.7);
        }

        if(OI.getDriver().getPOV() != -1){
            System.out.println("Starting rotate command");
            Scheduler.getInstance().add(new RotateToHeadingCommand(OI.getDriver().getPOV()));
        }

        if(OI.getDriverRequestionHatchLED()){
            CameraSubsystem camera = Robot.m_camera;
            Scheduler.getInstance().add(new RotateToHeadingCommand(c_drive.getPigeonHeading() - camera.getDegreesOff()));
        }
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }
}