package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.Colour;
import frc.robot.oi.OI;
import frc.robot.subsystems.BlinkinSubsystem;

public class DefaultBlinkinCommand extends Command {
    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();
    
    public DefaultBlinkinCommand() {
        requires(c_blinkin);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void execute() {
        if(OI.getDriverClimbingLED()) {
            c_blinkin.setLedStipColour(Colour.AQUA);
        } else if(OI.getDriverRequestCargoLED()) {
            c_blinkin.setLedStipColour(Colour.ORANGE);
        } else if(OI.getDriverRequestionHatchLED()) {
            c_blinkin.setLedStipColour(Colour.YELLOW);
        }
    }   
}