package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.teleopcommands.DriveDistanceCommand;

public class AutonomousCommandGroup extends CommandGroup {

    public AutonomousCommandGroup() {
    }

    @Override
    public void execute() {
        addSequential(new DriveDistanceCommand(0, 0.5, 5, 15));
    }
}