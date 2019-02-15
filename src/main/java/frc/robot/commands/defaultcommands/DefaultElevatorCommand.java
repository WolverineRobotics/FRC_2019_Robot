package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.commandgroups.ElevatorLevelCommandGroup;
import frc.robot.constants.RobotConst;
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
        if(elevatorSpeed < RobotConst.ELEVATOR_LEFT_STICK_Y_TRIGGER_VALUE) { //if operator does't trigger stick enough,
            elevatorSpeed = 0;
        }
        
        //default (manual) elevator control = OPERATOR LEFT STICK Y
        c_elevator.setElevatorSpeed(elevatorSpeed);
        
        if(OI.getOperatorElevatorBase()) { //if operator presses A, (lowest elevator level)
            new ElevatorLevelCommandGroup();
        } else if(OI.getOperatorElevatorLevel2()) { //if operator presses B, (middle elevator level)
            new ElevatorLevelCommandGroup();
        } else if(OI.getOperatorElevatorLevel3()) { //if operator presses Y, (highest elevator level)
            new ElevatorLevelCommandGroup();
        }
    } 

    @Override
    protected boolean isFinished() {
        return false;
    }

}
