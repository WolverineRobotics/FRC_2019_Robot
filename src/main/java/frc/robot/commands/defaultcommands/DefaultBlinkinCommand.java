package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.BlinkCommand;
import frc.robot.constants.blinkin.LEDCombo;
import frc.robot.oi.OI;
import frc.robot.subsystems.BlinkinSubsystem;

public class DefaultBlinkinCommand extends Command {
    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();
    private BlinkCommand currentBlink;
    
    public DefaultBlinkinCommand() {
        requires(c_blinkin);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void execute() {
        if(OI.getDriverCancel()) { //if driver presses B, set LEDs to static RED
            c_blinkin.setStaticColour(LEDCombo.STATIC.getColour1());
        }
        if(c_blinkin.getCurrentLEDCombo() == LEDCombo.STATIC) { //if the current combo is static,
            if(OI.getDriverClimbing()) { //if driver presses Y, set LEDs to blink LEDCombo.CLIMBING, half a second delay between each blink
                currentBlink = new BlinkCommand(LEDCombo.CLIMBING, 500);
            } else if(OI.getDriverRequestCargoLED()) { //if driver presses A, set LEDs to blink LEDCombo.REQUEST_CARGO, quarter second delay
                currentBlink = new BlinkCommand(LEDCombo.REQUEST_CARGO, 250);
            } else if(OI.getDriverRequestionHatchLED()) { //if driver presses X, set LEDs to blink LEDCombo.REQUEST_HATCH, quarter second delay
                currentBlink = new BlinkCommand(LEDCombo.REQUEST_HATCH, 250);
            }
        }
    }   
}
