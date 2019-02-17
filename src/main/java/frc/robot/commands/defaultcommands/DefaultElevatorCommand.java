package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.commandgroups.ElevatorLevelCommandGroup;
import frc.robot.oi.OI;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends Command {
    private final ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();

    public DefaultElevatorCommand(){
        requires(c_elevator);
    }

    @Override
    protected void execute() {
        double elevatorSpeed = OI.getOperatorElevatorSpeed();
        
        //default (manual) elevator control = OPERATOR LEFT STICK Y
        c_elevator.setElevatorRawSpeed(elevatorSpeed);
        
        if(OI.getOperatorElevatorLevel1()) { //if operator presses A, (lowest elevator level)
            Scheduler.getInstance().add(new ElevatorLevelCommandGroup(1));
        } else if(OI.getOperatorElevatorLevel2()) { //if operator presses B, (middle elevator level)
            Scheduler.getInstance().add(new ElevatorLevelCommandGroup(2));
        } else if(OI.getOperatorElevatorLevel3()) { //if operator presses Y, (highest elevator level)
            Scheduler.getInstance().add(new ElevatorLevelCommandGroup(3));
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}