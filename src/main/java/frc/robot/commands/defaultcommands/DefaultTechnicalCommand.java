package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.TechnicalSubsystem;

public class DefaultTechnicalCommand extends Command {
    
    private TechnicalSubsystem c_technical = Robot.getTechnicalSubsystem();

    public DefaultTechnicalCommand(){
        requires(c_technical);
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