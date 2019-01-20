package frc.robot.commands.technical;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.TechnicalSubsystem;

public class clearStickyCommand extends Command{
    private TechnicalSubsystem c_technical = Robot.getTechnicalSubsystem();
    private boolean finished = false;

    public clearStickyCommand(){
        requires(c_technical);
    }

    @Override
    protected void initialize() {
        c_technical.clearStickys();
        finished = true;
    }

    @Override
    protected boolean isFinished() {
        return finished;
    }
    
}