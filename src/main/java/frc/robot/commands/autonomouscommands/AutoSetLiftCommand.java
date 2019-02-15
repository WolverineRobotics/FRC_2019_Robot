package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;

public class AutoSetLiftCommand extends Command {
    
    private boolean isDone;

    public AutoSetLiftCommand() {

    }

    @Override
    public boolean isFinished() {
        return isDone;
    }
 
}