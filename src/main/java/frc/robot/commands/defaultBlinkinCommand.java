package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.BlinkinSubsystem.Colour;

public class defaultBlinkinCommand extends Command {

    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();

    public defaultBlinkinCommand() {
        requires(Robot.getBlinkinSubsystem());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void execute() {
        boolean isPressed = OI.getButtonX();
        if (isPressed) {
            c_blinkin.setLedStipColour(Colour.AQUA);
        } else {
            c_blinkin.setLedStipColour(Colour.YELLOW);
        }
    }

}