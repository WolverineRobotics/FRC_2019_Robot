package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbSubsystem;

public class DefaultClimbCommand extends Command {

    private ClimbSubsystem c_climb = Robot.getClimbSubsystem();

    public DefaultClimbCommand() {
        requires(c_climb);
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

}