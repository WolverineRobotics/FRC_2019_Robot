package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class defaultTechnicalCommand extends Command {
    public defaultTechnicalCommand(){
        requires(Robot.getTechnicalSubsystem());
    }

    @Override
    protected void initialize() {
        Robot.getTechnicalSubsystem().clearStickys();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}