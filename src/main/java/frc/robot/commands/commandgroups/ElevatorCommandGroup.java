import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.constants.GamePiece;
import frc.robot.constants.JoystickMap;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeInOutSubsystem;

public class ElevatorCommandGroup extends CommandGroup {

    private ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();
    private IntakeInOutSubsystem c_intakeInOut = Robot.getIntakeInOutSubsystem();

    public ElevatorCommandGroup() {
        GamePiece gamePiece = c_intakeInOut.getCurrentGamePiece();
        int level;
        if(gamePiece.equals(GamePiece.CARGO)) {
            gamePiece = GamePiece.CARGO;
        } else if(gamePiece.equals(GamePiece.HATCH)) {
            gamePiece = GamePiece.HATCH;
        } else { //no game piece detected
            gamePiece = GamePiece.NONE;
        }

        if(gamePiece != GamePiece.NONE || gamePiece != null) {
            if(button == JoystickMap.BUTTON_A) {
                level = gamePiece.getEncoderPos(0);
            } else if (button == JoystickMap.BUTTON_B) {
                level = gamePiece.getEncoderPos(1);
            } else if (button == JoystickMap.BUTTON_Y) {
                level = gamePiece.getEncoderPos(2);
            }
        }

        addSequential(new SetElevatorLevelCommand(gamePiece, level));
        addParallel(new SetIntakeTiltCommand());
    }
}