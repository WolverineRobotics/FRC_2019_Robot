package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotPIDValues;
import frc.robot.subsystems.DriveSubsystem;
import frc.util.PID;

public class DriveDirectionCommand extends Command{
    private DriveSubsystem c_drive = Robot.getDriveSubsystem();
    
    private double targetHeading;
    private double targetSpeed;

    private PID gyroPid = new PID(RobotPIDValues.GYRO_KP, RobotPIDValues.GYRO_KI, RobotPIDValues.GYRO_KD, 0);

    public DriveDirectionCommand(double heading, double speed, double timeout){
        super(timeout);
        requires(c_drive);
        targetHeading = heading;
        targetSpeed = speed;

        gyroPid.setMaxOutput(1);
        gyroPid.setDesiredValue(targetHeading);
    }

    @Override
    protected void execute() {
        double leftSpeed = targetSpeed;
        double rightSpeed = targetSpeed;
        double currentHeading = Robot.getDriveSubsystem().getGyroAngle();

        double steering = gyroPid.calcPID(currentHeading);

        if(steering < 0){
            rightSpeed *= 1 - rightSpeed;
        }
        if(steering > 0){
            leftSpeed *= 1 - leftSpeed;
        }
        Robot.getDriveSubsystem().setRawSpeeds(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}