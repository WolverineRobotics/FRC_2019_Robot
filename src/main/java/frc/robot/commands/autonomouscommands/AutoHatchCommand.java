package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoHatchCommand extends Command {

    private IntakeSubsystem c_intake;
    private boolean isDone;

    public AutoHatchCommand() {
        isDone = false;
    }

    @Override
    protected void initialize() {
        
    }

    @Override
    protected void execute() {
        
    }

    @Override
    protected void end() {
        
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

}