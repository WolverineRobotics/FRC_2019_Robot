package frc.robot.commands.teleopcommands;

import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;

public class DriveDistanceCommand extends DriveDirectionCommand{

    private DriveSubsystem c_drive = Robot.getDriveSubsystem();

    private double distance;
    private boolean isDone;

    public DriveDistanceCommand(double heading, double speed, double distance, double timeout) {
        super(heading, speed, timeout);
        this.distance = distance;
        this.isDone = false;
    }

    @Override
    public void execute() {
        
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

}