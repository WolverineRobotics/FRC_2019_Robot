package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.constants.blinkin.Colour;
import frc.robot.oi.OI;
import frc.robot.subsystems.BlinkinSubsystem;

public class DefaultBlinkinCommand extends Command {

    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();

    public DefaultBlinkinCommand() {
        requires(c_blinkin);
    }

    @Override
    protected void execute() {
        if (OI.getDriverCancel()) { //B Button
            if(c_blinkin.get)
            Scheduler.getInstance().add(new StaticCommand());
        } else if (OI.getDriverRequestCargoLED()) { //A Button
            Scheduler.getInstance().add(new BlinkCommand());
        } else if (OI.getDriverRequestionHatchLED()) { //X Button

        } else if (OI.getDriverClimbing()) { //Y Button

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