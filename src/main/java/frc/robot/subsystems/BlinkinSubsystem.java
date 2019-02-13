package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultBlinkinCommand;
import frc.robot.constants.Colour;
import frc.robot.constants.LEDCombo;
import frc.robot.constants.RobotMap;

public class BlinkinSubsystem extends Subsystem {

    private Spark blinkin = new Spark(RobotMap.BLINKIN_PWM_PORT);

    private Colour currentLED = Colour.RED;
    private LEDCombo currentLEDCombo;
    private boolean isBlinkin = false;

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new DefaultBlinkinCommand());
    }

    // **********************************************************************************
    // Blinkin functions
    // **********************************************************************************

    /**
     * 
     * Invoking this method will cancel any blinking tasks, through the boolean
     * variable, "isBlinkin".
     * 
     * @param colour Colour to be static
     */
    public void setStaticColour(Colour colour) {
        blinkin.set(colour.getValue());
        currentLED = colour;
        isBlinkin = false;
        currentLEDCombo = LEDCombo.NONE;
    }

    /**
     * Will switch to colour 1 then activate delay, then colour 2
     * @param colour1 First colour to blink
     * @param colour2 Second colour to blink
     * @param delay Delay between colours in seconds
     */
    public void blink(Colour colour1, Colour colour2, long delay) {
        try {
            blinkin.set(colour1.getValue());
            currentLED = colour1;
            Thread.sleep(delay);
            
            blinkin.set(colour2.getValue());
            currentLED = colour2;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Something went wrong with sleeping threads in the Blinking Subsystem");
        }
        
    }

    /**
     * Will return true if the LEDs are in a blinking state See blink()
     */
    public boolean isBlinkin() {
        return isBlinkin;
    }

    public void setBlinkin(boolean blinkin) {
        isBlinkin = blinkin;
    }

    /**
     * Will return Colour enum of the current colour. Not recommended to be used if
     * LEDs are blinking. See isBlinkin()
     */
    public Colour getCurrentLED() {
        return this.currentLED;
    }

    public void setCurrentLEDCombo(LEDCombo ledCombo) {
        this.currentLEDCombo = ledCombo;
    }

    public LEDCombo getCurrentLEDCombo() {
        return this.currentLEDCombo;
    }

}