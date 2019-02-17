package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.VisionSubsystem;

public class DefaultVisionCommand extends Command {

    private VisionSubsystem c_vision = Robot.getVisionSubsystem();

    public DefaultVisionCommand() {
        requires(c_vision);
    }

    @Override
    public void execute() {
        
    }

    /**
     * Default commands never finish.
     */
    @Override
    public boolean isFinished() {
        return false;
    }

}