package frc.robot.commands.utilcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ExecuteAfterWaitCommand extends CommandGroup {

    public ExecuteAfterWaitCommand(double timeSeconds, Command commandToRun) {
        addSequential(new WaitCommand(timeSeconds));
        addSequential(commandToRun);
    }
    
}