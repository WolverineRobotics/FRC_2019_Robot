package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.SetElevatorLevelCommand;
import frc.robot.commands.SetIntakeElbowCommand;
import frc.robot.constants.GamePiece;
import frc.robot.oi.OI;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeInOutSubsystem;

public class ElevatorLevelCommandGroup extends CommandGroup {

    private ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();
    private IntakeInOutSubsystem c_intakeInOut = Robot.getIntakeInOutSubsystem();

    public ElevatorLevelCommandGroup() {
        GamePiece gamePiece = c_intakeInOut.getCurrentGamePiece();
        if(gamePiece.equals(GamePiece.CARGO)) {
            gamePiece = GamePiece.CARGO;
        } else if(gamePiece.equals(GamePiece.HATCH)) {
            gamePiece = GamePiece.HATCH;
        } else { //no game piece detected
            gamePiece = GamePiece.NONE;
        }
        int level = 0;
        if(gamePiece != GamePiece.NONE || gamePiece != null) {        
            if(OI.getOperatorElevatorBase()) {
                level = gamePiece.getElevatorEncoderPos(0);
            } else if (OI.getOperatorElevatorLevel2()) {
                level = gamePiece.getElevatorEncoderPos(1);
            } else if (OI.getOperatorElevatorLevel3()) {
                level = gamePiece.getElevatorEncoderPos(2);
            }
        }
        addSequential(new SetElevatorLevelCommand(gamePiece, level));
        addParallel(new SetIntakeElbowCommand(gamePiece, level));
    }
}