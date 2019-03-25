package frc.robot.commands.autonomousfunctions;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ExecuteAfterCommand extends CommandGroup {

    public ExecuteAfterCommand(Command commandBefore, Command commandToRun) {
        if(commandBefore.isCompleted()) {
            addSequential(commandToRun);
        }
    }

}