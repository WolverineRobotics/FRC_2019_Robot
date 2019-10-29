package frc.robot.commands.autonomouscommands;

import frc.robot.constants.RobotPIDValues;
import frc.robot.pid.LocationPID;

public class DriveDistanceLocationCommand extends DriveDistanceCommand {

    private double previousEncoderDistance;
    private LocationPID gyroPID;

    private final double DISTANCE_END = 0.2;

    public DriveDistanceLocationCommand(double power, double distance, double heading, boolean brakeWhenFinished){
        super(power, distance, heading, brakeWhenFinished);
        this.power = power;
        this.gyroPID = new LocationPID(RobotPIDValues.GYRO_KP, RobotPIDValues.GYRO_KI, RobotPIDValues.GYRO_KD);

    }


    @Override
    protected void initialize() {
        super.initialize();
        gyroPID.initialize(this.distance, this.heading);
        c_drive.resetEncoders();
        this.previousEncoderDistance = c_drive.getDistance();
    }

    @Override
    protected boolean isFinished() {
        distance = gyroPID.getDistance();
        return (distance < DISTANCE_END);
        // return false;
    }

    @Override
    protected void execute() {
        double leftSpeed, rightSpeed;
        double steering;

        double currentDistance = c_drive.getDistance();
        double distanceChanged = currentDistance - this.previousEncoderDistance;
 
        steering = gyroPID.calculate(c_drive.getPigeonHeading(),distanceChanged);

        // if(speed > Math.abs(power)){
        //     speed = power;
        // }

        speed = this.power;

        leftSpeed = -(speed - steering);
        rightSpeed = speed + steering;
        
        c_drive.setRawSpeeds(leftSpeed, rightSpeed);

        this.previousEncoderDistance = currentDistance;
    }

}

