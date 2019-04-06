package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;

public class AutomaticZeroCommandGroup extends CommandGroup {

    public AutomaticZeroCommandGroup() {
        addSequential(new SetElevatorCommand(0, 0.7));
        addSequential(new SetIntakeRotateCommand(0, 1));
    }

}