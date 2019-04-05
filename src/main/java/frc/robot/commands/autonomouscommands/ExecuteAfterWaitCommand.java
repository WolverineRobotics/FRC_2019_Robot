package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ExecuteAfterWaitCommand extends CommandGroup {
    double timeSeconds;
    Command commandToRun;

    public ExecuteAfterWaitCommand(double timeSeconds, Command commandToRun) {
        this.timeSeconds = timeSeconds;
        this.commandToRun = commandToRun;
    }

    @Override
    protected void initialize() {
        addSequential(new WaitCommand(timeSeconds));
        addSequential(commandToRun);
    }
    
}