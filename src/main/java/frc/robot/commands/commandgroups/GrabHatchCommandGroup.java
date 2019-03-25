package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;

public class GrabHatchCommandGroup extends CommandGroup {

    public GrabHatchCommandGroup() {
        addParallel(new OpenShovelCommand(false));
        addSequential(new SetIntakeRotateCommand(10, 0.9));
        addSequential(new OpenClawCommand(false));
    }

}