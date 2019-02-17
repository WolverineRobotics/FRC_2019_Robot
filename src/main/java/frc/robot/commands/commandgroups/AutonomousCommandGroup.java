package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommandGroup extends CommandGroup {

    private boolean isDone;

    public AutonomousCommandGroup() {
        isDone = false;

    }

    @Override
    public boolean isFinished() {
        return isDone;
    }

    @Override
    public void execute() {
        //addSequential(new DriveDistanceCommand()));
        
    }
}