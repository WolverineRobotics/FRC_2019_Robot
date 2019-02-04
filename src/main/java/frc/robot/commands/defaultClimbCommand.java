package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.ClimbSubsystem;

public class defaultClimbCommand extends Command {
    private ClimbSubsystem c_climb = Robot.getClimbSubsystem();

    public defaultClimbCommand() {
        requires(c_climb);
    }
    
    @Override
    protected void execute() {
        c_climb.setClimbSpeed(OI.getClimbTestSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}