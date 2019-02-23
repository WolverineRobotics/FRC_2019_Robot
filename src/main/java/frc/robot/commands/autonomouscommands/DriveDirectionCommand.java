package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotPIDValues;
import frc.robot.subsystems.DriveSubsystem;
import frc.util.PID;

public class DriveDirectionCommand extends Command{
    
	private double  speed;
    private double leftSpeed;
    private double rightSpeed;
    
    private PID gyroPID;
    private DriveSubsystem c_drive = Robot.getDriveSubsystem();
    	
    public DriveDirectionCommand(double direction, double speed) {
        this.speed = speed;
        this.leftSpeed = 0;
        this.rightSpeed = 0;
        gyroPID = new PID(RobotPIDValues.GYRO_KP, RobotPIDValues.GYRO_KI, RobotPIDValues.GYRO_KD, RobotPIDValues.GYRO_EPS);
        requires(c_drive);
        gyroPID.setDesiredValue(direction);
    }
    
    @Override
    protected void execute() {
        double currentHeading = c_drive.getHeading();

        double steering = gyroPID.calcPID(currentHeading);

        if (steering > 0) {
            leftSpeed = speed - steering;
        } else if (steering < 0) {
            rightSpeed = speed - steering;
        } else {
            leftSpeed = speed;
            rightSpeed = speed;
        }

        c_drive.setRawSpeeds(leftSpeed, rightSpeed);
    }
    
    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}