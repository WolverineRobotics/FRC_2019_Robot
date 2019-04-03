package frc.robot.commands.autonomouscommands;

import frc.robot.constants.RobotPIDValues;
import frc.util.PID;

public class DriveDistanceCommand extends DriveDirectionCommand {
    double distance;

    boolean brakeWhenFinished;

    public DriveDistanceCommand(double power, double distance, double heading, boolean brakeWhenFinished){
        super(power, heading);

        this.distance = distance;
        this.brakeWhenFinished = brakeWhenFinished;
    }

    
    @Override
    protected boolean isFinished() {
        return c_drive.getDistance() > distance;
    }

    @Override
    protected void end() {
        System.out.println("Finished drive distance command");
        if(brakeWhenFinished){
            c_drive.setRawSpeeds(0, 0);
        }
    }

    public void setDistance(double distance){
        this.distance = distance;
    }
}