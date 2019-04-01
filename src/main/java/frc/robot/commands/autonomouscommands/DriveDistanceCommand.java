package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotPIDValues;
import frc.robot.subsystems.DriveSubsystem;
import frc.util.PID;

public class DriveDistanceCommand extends Command {
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

        c_drive = Robot.getDriveSubsystem();

        distancePID = new PID(RobotPIDValues.DISTANCE_KP, RobotPIDValues.DISTANCE_KI, RobotPIDValues.DISTANCE_KD, RobotPIDValues.DISTANCE_EPS);
        distancePID.setDesiredValue(distance);

        gyroPID = c_drive.gyroPID;
        gyroPID.setDesiredValue(heading);
    }

    @Override
    protected void execute() {
        double leftSpeed, rightSpeed;
        double speed, steering;
 
        steering = gyroPID.calcPID(c_drive.getPigeonHeading());

        speed = distancePID.calcPID(c_drive.getDistance());

        if(!brakeWhenFinished){
            speed = power;
        }

        if(speed > Math.abs(power)){
            speed = power;
        }

        leftSpeed = speed - steering;
        rightSpeed = -(speed + steering);
        
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