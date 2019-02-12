package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultBlinkinCommand;
import frc.robot.constants.Colour;
import frc.robot.constants.RobotMap;

public class BlinkinSubsystem extends Subsystem {   

    private Spark blinkin = new Spark(RobotMap.BLINKIN_PWM_PORT);

    private Colour currentLED = Colour.RED;
    private boolean isBlinkin = false;

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new DefaultBlinkinCommand());
    }

    //********************************************************************************** 
    // Blinkin functions
    //********************************************************************************** 
   
    /**
     * 
     * Invoking this method will cancel any blinking tasks,
     * through the boolean variable, "isBlinkin".
     * 
     * @param colour
     * Colour to be static
     */
    public void setStaticColour(Colour colour) {
        blinkin.set(colour.getValue());
        currentLED = colour;
        isBlinkin = false;
    }

    /**
     * LEDs will alternate between colour1 and colour2.
     * 
     * @param colour1
     * First colour to blink
     * @param colour2
     * Second colour to blink
     */
    public void blink(Colour colour1, Colour colour2) {
        isBlinkin = true;
        while(isBlinkin) {
            if(currentLED == colour1) {
                blinkin.set(colour2.getValue());
            } else {
                blinkin.set(colour1.getValue());
            }
        }
    }

    /**
     * Will return true if the LEDs are in a blinking state
     * See blink()
     */
    public boolean isBlinkin() {
        return isBlinkin;
    }

    /**
     * Will return Colour enum of the current colour.
     * Not recommended to be used if LEDs are blinking. See isBlinkin()
     */
    public Colour getCurrentLED() {
        return this.currentLED;
    }
    
}