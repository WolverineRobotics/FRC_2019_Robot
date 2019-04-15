package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;

public class SimpleBackawayCommand extends Command {

    private DriveSubsystem c_drive;

    private double distance;
    private double speed;

    private boolean isDone;

    public SimpleBackawayCommand(double distance, double speed){
        c_drive = Robot.getDriveSubsystem();
        requires(c_drive);
        this.distance = -distance;
        this.speed = speed;
        this.isDone = false;
    }

    @Override
    protected void initialize() {
        c_drive.resetEncoders();
        c_drive.setRawSpeeds(speed, -speed);
    }

    @Override
    protected void execute() {
        if(c_drive.getDistance() <   distance) {
            isDone = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }
    
}