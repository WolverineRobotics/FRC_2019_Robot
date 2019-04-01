package frc.robot.commands.autonomouscommands;

import frc.robot.constants.RobotPIDValues;
import frc.util.PID;

public class DriveDistanceCommand extends DriveDirectionCommand {
    double distance;

    PID distancePID;

    public DriveDistanceCommand(double power, double distance, double heading, boolean brakeWhenFinished){
        super(power, heading, brakeWhenFinished);

        this.distance = distance;

        distancePID = new PID(RobotPIDValues.DISTANCE_KP, RobotPIDValues.DISTANCE_KI, RobotPIDValues.DISTANCE_KD, RobotPIDValues.DISTANCE_EPS);
        distancePID.setDesiredValue(distance);
    }

    @Override
    protected void execute() {
        speed = distancePID.calcPID(c_drive.getDistance());
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

    public void setDistance(double distance){
        this.distance = distance;
        distancePID.setDesiredValue(distance);
    }
}