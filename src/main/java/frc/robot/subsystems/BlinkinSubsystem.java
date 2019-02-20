package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DefaultBlinkinCommand;
import frc.robot.constants.RobotMap;
import frc.robot.constants.blinkin.Colour;
import frc.robot.constants.blinkin.LEDCombo;

public class BlinkinSubsystem extends Subsystem {

    private LEDCombo currentLEDCombo;

    private Spark blinkin;

    public BlinkinSubsystem() {
        blinkin = new Spark(RobotMap.BLINKIN_PWM_PORT);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultBlinkinCommand());
    }

    public void setColour(Colour colour) {
        blinkin.set(colour.getValue());
    }

    public LEDCombo getCurrentLEDCombo() {
        return currentLEDCombo;
    }

}