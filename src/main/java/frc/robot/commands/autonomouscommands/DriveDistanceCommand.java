package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotPIDValues;
import frc.robot.subsystems.DriveSubsystem;
import frc.util.PID;

class DriveDistanceCommand extends Command {
    double power, distance, heading;

    boolean brakeWhenFinished;

    PID distancePID;
    PID gyroPID;

    DriveSubsystem c_drive;

    public DriveDistanceCommand(double power, double distance, double heading, boolean brakeWhenFinished){
        this.power = power;
        this.distance = distance;
        this.heading = heading;
        this.brakeWhenFinished = brakeWhenFinished;

        distancePID = new PID(RobotPIDValues.DISTANCE_KP, RobotPIDValues.DISTANCE_KI, RobotPIDValues.DISTANCE_KD, RobotPIDValues.DISTANCE_EPS);
        distancePID.setDesiredValue(distance);

        gyroPID = new PID(RobotPIDValues.GYRO_KP, RobotPIDValues.GYRO_KI, RobotPIDValues.GYRO_KD, RobotPIDValues.GYRO_EPS);
        gyroPID.setDesiredValue(heading);

        c_drive = Robot.getDriveSubsystem();
    }

    @Override
    protected void execute() {
        double leftSpeed, rightSpeed;
        double speed, steering;

        speed = distancePID.calcPID((c_drive.getDistanceLeftEncoder() + c_drive.getDistanceRightEncoder())/2);
        steering = gyroPID.calcPID(c_drive.getPigeonHeading());

        leftSpeed = speed - steering;
        rightSpeed = -(speed + steering);
    
        if(leftSpeed > power){
            leftSpeed = power;
        } else if(leftSpeed < -power){
            leftSpeed = -power;
        }

        if(rightSpeed > power){
            rightSpeed = power;
        } else if(rightSpeed < -power){
            rightSpeed = -power;
        }

        c_drive.setRawSpeeds(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        return distancePID.isDone();
    }

    @Override
    protected void end() {
        if(brakeWhenFinished){
            c_drive.setRawSpeeds(0, 0);
        }
    }
}