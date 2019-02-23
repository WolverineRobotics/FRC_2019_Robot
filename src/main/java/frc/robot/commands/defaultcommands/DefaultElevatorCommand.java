package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotConst;
import frc.robot.oi.OI;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends Command {

    private ElevatorSubsystem c_elevator;
    
    public DefaultElevatorCommand() {
        c_elevator = Robot.getElevatorSubsystem();
        requires(c_elevator);
    }
     
    @Override
    protected void execute() {
        if(OI.getOperatorElevatorLevel1()) {
            //level 1
        } else if(OI.getOperatorElevatorLevel2()) {
            //level 2
        } else if(OI.getOperatorElevatorLevel3()) {
            //level 3
        } else if(Math.abs(OI.getOperatorElevatorSpeed()) > RobotConst.ELEVATOR_LEFT_STICK_Y_TRIGGER_VALUE) {
            double elevatorSpeed = OI.getOperatorElevatorSpeed();
            if(elevatorSpeed > 1) { 
                elevatorSpeed = 1;
            } else if(elevatorSpeed < -1) {
                elevatorSpeed = -1;
            }  
            c_elevator.setElevatorRawSpeed(elevatorSpeed * 0.8);
        }
    }

     
    @Override
    protected boolean isFinished() {
        return false;
    }  

}