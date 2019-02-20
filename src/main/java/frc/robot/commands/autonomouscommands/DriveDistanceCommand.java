package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotConst;
import frc.robot.constants.RobotPIDValues;
import frc.robot.subsystems.DriveSubsystem;
import frc.util.PID;

public class DriveDistanceCommand extends Command {
    private double speed, leftSpeed, rightSpeed, direction, distance;
    
    private PID gyroPID, distancePID;
            
    private DriveSubsystem c_drive = Robot.getDriveSubsystem();
    	
    public DriveDistanceCommand(double distance, double direction, double speed) {
        requires(c_drive);

        this.speed = speed;
        this.direction = direction;
        this.distance = distance * RobotConst.DRIVE_ENCODER_COUNTS_PER_INCH_LOW;
        leftSpeed = 0;
        rightSpeed = 0;
        
        distancePID = new PID(RobotPIDValues.DISTANCE_KP, RobotPIDValues.DISTANCE_KI,
                RobotPIDValues.DISTANCE_KD, RobotPIDValues.DISTANCE_EPS);
        distancePID.setMaxOutput(1);
        distancePID.setMinOutput(-1);
            
        gyroPID = new PID(RobotPIDValues.GYRO_KP, RobotPIDValues.GYRO_KI, RobotPIDValues.GYRO_KD,
                RobotPIDValues.GYRO_EPS);
        distancePID.setMaxOutput(1);
        distancePID.setMaxOutput(-1);
    }

    @Override
    protected void initialize() {
        gyroPID.setDesiredValue(direction);
        distancePID.setDesiredValue(distance);
    }
    
    @Override
    protected void execute() {
        double currentHeading = c_drive.getHeading();
        double currentDistance = (c_drive.getRawLeftEncoder() + c_drive.getRawRightEncoder()) / 2;

        double steering = gyroPID.calcPID(currentHeading);
        double travel = distancePID.calcPID(currentDistance);

        setSpeed(travel);

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