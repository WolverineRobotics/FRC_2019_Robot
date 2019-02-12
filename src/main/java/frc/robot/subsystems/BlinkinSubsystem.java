package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultBlinkinCommand;
import frc.robot.constants.Colour;
import frc.robot.constants.RobotMap;

public class BlinkinSubsystem extends Subsystem {
    
    private Spark blinkin = new Spark(RobotMap.BLINKIN_PWM_PORT);

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new DefaultBlinkinCommand());
    }

    //********************************************************************************** 
    // Blinkin functions
    //********************************************************************************** 
    public void setLedStipColour(Colour colour) {
        blinkin.set(colour.getValue());
    }
}