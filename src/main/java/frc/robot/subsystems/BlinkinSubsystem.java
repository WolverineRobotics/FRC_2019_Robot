package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultBlinkinCommand;
import frc.robot.constants.RobotMap;
import frc.robot.constants.blinkin.Colour;
import frc.robot.constants.blinkin.LEDCombo;

public class BlinkinSubsystem extends Subsystem {

    private LEDCombo currentLEDCombo;
    private Colour currentColour;

    private Spark blinkin;

    public BlinkinSubsystem() {
        blinkin = new Spark(RobotMap.BLINKIN_PWM_PORT);
        setColour(Colour.RED);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultBlinkinCommand());
    }

    public void setColour(Colour colour) {
        blinkin.set(colour.getValue());
        this.currentColour = colour;
    }

    public Colour getColour() {
        return currentColour;
    }

    public LEDCombo getCurrentLEDCombo() {
        return currentLEDCombo;
    }

    public void setCurrentLEDCombo(LEDCombo currentLedCombo){
        this.currentLEDCombo = currentLedCombo;
    }

}