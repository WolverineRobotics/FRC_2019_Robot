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
   
    public void setStaticColour(Colour colour) {
        blinkin.set(colour.getValue());
        currentLED = colour;
        isBlinkin = false;
    }

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

    public boolean isBlinkin() {
        return isBlinkin;
    }

    public Colour getCurrentLED() {
        return this.currentLED;
    }
    
}