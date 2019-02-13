package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.BlinkCommand;
import frc.robot.constants.Colour;
import frc.robot.constants.LEDCombo;
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
        LEDCombo combo = c_blinkin.getCurrentLEDCombo();
        if(OI.getDriverCancel()) {
            c_blinkin.setStaticColour(Colour.RED);
        } else if(OI.getDriverClimbingLED()) {
            new BlinkCommand(LEDCombo.CLIMBING, 500);
        } else if(OI.getDriverRequestCargoLED()) {
            new BlinkCommand(LEDCombo.REQUEST_CARGO, 250);
        } else if(OI.getDriverRequestionHatchLED()) {
            new BlinkCommand(LEDCombo.REQUEST_HATCH, 250);
        }
    }   
}