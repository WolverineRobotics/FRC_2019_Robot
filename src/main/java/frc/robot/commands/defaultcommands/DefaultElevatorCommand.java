package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends Command {
    private final ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();

    public DefaultElevatorCommand(){
        requires(c_elevator);
    }

    @Override
    protected void execute() {
        c_elevator.setElevatorSpeed(OI.getOperatorElevatorSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
