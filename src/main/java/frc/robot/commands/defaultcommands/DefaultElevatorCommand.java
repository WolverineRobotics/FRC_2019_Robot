package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.commandgroups.ElevatorLevelCommandGroup;
import frc.robot.commands.commandgroups.PlayerStationCommandGroup;
import frc.robot.constants.GamePiece;
import frc.robot.constants.JoystickMap;
import frc.robot.constants.RobotConst;
import frc.robot.oi.OI;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class DefaultElevatorCommand extends Command {

    private ElevatorSubsystem c_elevator;
    private IntakeSubsystem c_intake;
    
    public DefaultElevatorCommand() {
        c_elevator = Robot.getElevatorSubsystem();
        requires(c_elevator);
        c_intake = Robot.getIntakeSubsystem();
    }
     
    @Override
    protected void execute() {
        // Manual control
        double elevatorSpeed = OI.getOperatorElevatorSpeed();
        if (Math.abs(elevatorSpeed) > RobotConst.ELEVATOR_LEFT_STICK_Y_TRIGGER_VALUE) {
            c_elevator.setElevatorRawSpeed(elevatorSpeed * 0.7);
        } else {
            c_elevator.setElevatorRawSpeed(0);
        }

        //Operator A, B and Y Button controls
        GamePiece gamePiece = c_intake.getGamePiece();
        if(OI.getOperatorElevatorLevel1()) {
            Scheduler.getInstance().add(new ElevatorLevelCommandGroup(gamePiece, 1));
        } else if (OI.getOperatorElevatorLevel2()) {
            Scheduler.getInstance().add(new ElevatorLevelCommandGroup(gamePiece, 2));
        } else if (OI.getOperatorElevatorLevel3()) {
            Scheduler.getInstance().add(new ElevatorLevelCommandGroup(gamePiece, 3));
        } else if(OI.getOperatorPlayerStationBall()) {
            Scheduler.getInstance().add(new PlayerStationCommandGroup(GamePiece.CARGO));
        }

        // Reset Encoder
        if (OI.getDriver().getRawButton(JoystickMap.BUTTON_START)) {
            c_elevator.resetEncoder();
        }
    }
     
    // Default commands don't finish.
    @Override
    protected boolean isFinished() {
        return false;
    }  

}