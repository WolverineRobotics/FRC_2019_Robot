package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.Colour;
import frc.robot.constants.LEDCombo;
import frc.robot.oi.OI;
import frc.robot.subsystems.BlinkinSubsystem;

public class BlinkCommand extends Command {
    
    //TODO Add cancel button (B) should cancel this command.

    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();
    private Colour colour1;
    private Colour colour2;
    private long delay;

    public BlinkCommand(LEDCombo ledCombo, long delay) {
        requires(c_blinkin);
        this.colour1 = ledCombo.getColour1();
        this.colour2 = ledCombo.getColour2();
        this.delay = delay;
        c_blinkin.setBlinkin(true);
        c_blinkin.setCurrentLEDCombo(ledCombo);
        execute();
    }

    @Override
    public boolean isFinished() {
        return !(c_blinkin.isBlinkin());
    }

    @Override
    public void execute() {
        while(c_blinkin.isBlinkin()) {
            c_blinkin.blink(colour1, colour2, delay);
            if(OI.getDriverCancel()) {
                break;
            }
        }
        c_blinkin.setStaticColour(Colour.RED);
    }
}