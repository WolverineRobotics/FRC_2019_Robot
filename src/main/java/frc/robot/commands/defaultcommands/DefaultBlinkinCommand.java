package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.teleopcommands.BlinkCommand;
import frc.robot.commands.teleopcommands.StaticCommand;
import frc.robot.constants.blinkin.LEDCombo;
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
            if(c_blinkin.getCurrentLEDCombo() == LEDCombo.STATIC){
                Scheduler.getInstance().add(new StaticCommand(LEDCombo.STATIC.getColour1()));
                c_blinkin.setCurrentLEDCombo(LEDCombo.STATIC);
            }
        } else if (OI.getDriverRequestCargoLED()) { //A Button
            if(c_blinkin.getCurrentLEDCombo() == LEDCombo.REQUEST_CARGO){
            Scheduler.getInstance().add(new BlinkCommand(250, LEDCombo.REQUEST_CARGO.getColour1(), LEDCombo.REQUEST_CARGO.getColour2()));
            c_blinkin.setCurrentLEDCombo(LEDCombo.REQUEST_CARGO);
            }
        } else if (OI.getDriverRequestionHatchLED()) { //X Button
            if(c_blinkin.getCurrentLEDCombo() == LEDCombo.REQUEST_HATCH){
                Scheduler.getInstance().add(new BlinkCommand(250, LEDCombo.REQUEST_HATCH.getColour1(), LEDCombo.REQUEST_HATCH.getColour2()));
                c_blinkin.setCurrentLEDCombo(LEDCombo.REQUEST_HATCH);
            }
        } else if (OI.getDriverClimbing()) { //Y Button
            if(c_blinkin.getCurrentLEDCombo() == LEDCombo.CLIMBING){
                Scheduler.getInstance().add(new BlinkCommand(250, LEDCombo.CLIMBING.getColour1(), LEDCombo.CLIMBING.getColour2()));
            c_blinkin.setCurrentLEDCombo(LEDCombo.CLIMBING);
            }
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