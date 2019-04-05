package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.commandgroups.ElevatorLevelCommandGroup;
import frc.robot.commands.commandgroups.PlayerStationCommandGroup;
import frc.robot.constants.GamePiece;
import frc.robot.constants.JoystickMap;
import frc.robot.oi.OI;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.util.Util;

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
        if(elevatorSpeed == 0){
            c_elevator.setElevatorRawSpeed(-0.07);
        } else {
            c_elevator.setElevatorRawSpeed(elevatorSpeed * 0.7);
        }

        //Operator A, B and Y Button controls
        GamePiece gamePiece = c_intake.getGamePiece();
        if(OI.getOperatorElevatorLevel1()) {
            Util.addCommand(new ElevatorLevelCommandGroup(gamePiece, 1));
        } else if (OI.getOperatorElevatorLevel2()) {
            Util.addCommand(new ElevatorLevelCommandGroup(gamePiece, 2));
        } else if (OI.getOperatorElevatorLevel3()) {
            Util.addCommand(new ElevatorLevelCommandGroup(gamePiece, 3));
        } else if(OI.getOperatorPlayerStationBall()) {
            Util.addCommand(new PlayerStationCommandGroup(GamePiece.CARGO));
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