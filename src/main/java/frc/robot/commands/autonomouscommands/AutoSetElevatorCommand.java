package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;

public class AutoSetElevatorCommand extends Command {
    
    private boolean isDone;

    public AutoSetElevatorCommand() {
        
    }

    @Override
    public boolean isFinished() {
        return isDone;
    }
 
}