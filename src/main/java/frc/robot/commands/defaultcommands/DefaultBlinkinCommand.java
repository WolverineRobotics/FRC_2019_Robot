package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.Colour;
import frc.robot.oi.OI;
import frc.robot.subsystems.BlinkinSubsystem;

public class DefaultBlinkinCommand extends Command {
    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();
    
    public DefaultBlinkinCommand() {
        requires(c_blinkin);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void execute() {
        if(OI.getDriverClimbingLED()) {
            c_blinkin.blink(Colour.AQUA, Colour.WHITE); //signal we're about to CLIMB (blink AQUA and WHITE)
        } else if(OI.getDriverRequestCargoLED()) {
            c_blinkin.blink(Colour.ORANGE, Colour.WHITE); //signal we're requesting a CARGO (blink ORANGE nad WHITE)
        } else if(OI.getDriverRequestionHatchLED()) {
            c_blinkin.blink(Colour.YELLOW, Colour.WHITE); //signal we're requesting a HATCH (blink YELLOW and WHITE)
        } else if(OI.getDriverDefaultLED()) {
            c_blinkin.setStaticColour(Colour.RED); //default the colour to static RED (no blinking)
        }
    }   
}