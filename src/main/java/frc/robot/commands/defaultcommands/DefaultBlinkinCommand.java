package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.BlinkinSubsystem;

public class DefaultBlinkinCommand extends Command {

    private BlinkinSubsystem c_blinkin;

    public DefaultBlinkinCommand() {
        c_blinkin = Robot.getBlinkinSubsystem();
        requires(c_blinkin);
    }

    @Override
    protected void execute() {
    }

    /**
     * Default commands never finish
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

}