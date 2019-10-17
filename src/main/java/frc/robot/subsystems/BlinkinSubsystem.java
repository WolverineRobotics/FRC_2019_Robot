package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultBlinkinCommand;
import frc.robot.constants.RobotMap;
import frc.robot.constants.blinkin.Colour;

public class BlinkinSubsystem extends Subsystem {

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
}