package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.ElevatorSubsystem;

public class defaultElevatorCommand extends Command {
    ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();

    public defaultElevatorCommand(){
        requires(c_elevator);
    }

    @Override
    protected void execute() {
        c_elevator.setElevatorSpeed(OI.getElevatorSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
