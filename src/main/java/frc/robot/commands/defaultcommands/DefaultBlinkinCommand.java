package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.BlinkCommand;
import frc.robot.constants.LEDCombo;
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
        if(OI.getDriverCancel()) {
            currentBlink = null;
            c_blinkin.setStaticColour(LEDCombo.STATIC.getColour1());
            c_blinkin.setCurrentLEDCombo(LEDCombo.STATIC);
        } else if(OI.getDriverClimbingLED()) {
            currentBlink = new BlinkCommand(LEDCombo.CLIMBING, 500);
        } else if(OI.getDriverRequestCargoLED()) {
            currentBlink = new BlinkCommand(LEDCombo.REQUEST_CARGO, 250);
        } else if(OI.getDriverRequestionHatchLED()) {
            currentBlink = new BlinkCommand(LEDCombo.REQUEST_HATCH, 250);
        }
    }   
}
