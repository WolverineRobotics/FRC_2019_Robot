package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.commandgroups.ElevatorCommandGroup;
import frc.robot.constants.JoystickMap;
import frc.robot.oi.OI;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends Command {
    private final ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();

    public DefaultElevatorCommand(){
        requires(c_elevator);
    }

    @Override
    protected void execute() {
        if(OI.getOperatorElevatorSpeed() != 0) {
            c_elevator.setElevatorSpeed(OI.getOperatorElevatorSpeed());

        }
        if(OI.getOperatorElevatorBase()) {
            new ElevatorCommandGroup(JoystickMap.BUTTON_A);
        } else if(OI.getOperatorElevatorLevel2()) {
            new ElevatorCommandGroup(JoystickMap.BUTTON_B);
        } else if(OI.getOperatorElevatorLevel3()) {
            new ElevatorCommandGroup(JoystickMap.BUTTON_Y);
        }
    } 

    @Override
    protected boolean isFinished() {
        return false;
    }

}
