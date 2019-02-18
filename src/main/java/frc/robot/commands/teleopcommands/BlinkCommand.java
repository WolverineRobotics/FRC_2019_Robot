package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.blinkin.Colour;
import frc.robot.constants.blinkin.LEDCombo;
import frc.robot.oi.OI;
import frc.robot.subsystems.BlinkinSubsystem;

public class BlinkCommand extends Command {
    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();
    private Colour colour1;
    private Colour colour2;
    private long delay;
    private boolean isFinished;

    /**
     * Main constructor for BlinkCommand
     * @param ledCombo See LEDCombo in \constants
     * @param delay The delay (in milliseconds) between each colour
     */
    public BlinkCommand(LEDCombo ledCombo, long delay) {
        requires(c_blinkin);
        setInterruptible(true);
        this.colour1 = ledCombo.getColour1();
        this.colour2 = ledCombo.getColour2();
        this.delay = delay;
        c_blinkin.setIsBlinkin(true);
        c_blinkin.setCurrentLEDCombo(ledCombo);
    }

    /**
     * Returns if the BlinkCommand is done
     */
    @Override
    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public void execute() {
        while(!isFinished) {
            c_blinkin.blink(colour1, colour2, delay);
            if(OI.getDriverCancel()) {
                isFinished = true;
                break;
            }
        }
    }
}