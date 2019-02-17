package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.constants.RobotPIDValues;
import frc.robot.subsystems.DriveSubsystem;
import frc.util.PID;

public class DriveDistanceCommand extends DriveDirectionCommand{

    private DriveSubsystem c_drive = Robot.getDriveSubsystem();

    private double distance;
    private boolean isDone;

    private PID distancePID = new PID(RobotPIDValues.DISTANCE_KP, RobotPIDValues.DISTANCE_KI, RobotPIDValues.DISTANCE_KD, 0);

    public DriveDistanceCommand(double heading, double speed, double distance, double timeout) {
        super(heading, speed, timeout);
        this.distance = distance;
        this.isDone = false;
        distancePID.setDesiredValue(distance);
        c_drive.resetEncoders();
    }

    @Override
    public void execute() {
        double currentDistance = (c_drive.getRawLeftEncoder() + c_drive.getRawRightEncoder()) / 2;

        distancePID.calcPID(currentDistance);
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

}