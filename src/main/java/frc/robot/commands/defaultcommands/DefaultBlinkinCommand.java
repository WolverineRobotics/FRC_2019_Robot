package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.blinkin.Colour;
import frc.robot.subsystems.BlinkinSubsystem;

public class DefaultBlinkinCommand extends Command {

    private BlinkinSubsystem c_blinkin;

    public DefaultBlinkinCommand() {
        c_blinkin = Robot.getBlinkinSubsystem();
        requires(c_blinkin);
    }

    @Override
    protected void execute() {
        if(Robot.getClimbSubsystem().getLock()) {
            c_blinkin.setColour(Colour.GREEN);
        } else {
            c_blinkin.setColour(Colour.RED);
        }
    }

    /**
     * Default commands never finish
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

}