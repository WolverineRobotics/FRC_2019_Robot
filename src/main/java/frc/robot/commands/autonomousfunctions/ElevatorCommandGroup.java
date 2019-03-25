package frc.robot.commands.autonomousfunctions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.constants.GamePiece;

public class ElevatorCommandGroup extends CommandGroup {

    private int desiredElevatorEncoderPos;
    private int desiredIntakeRotateEncoderPos;

    public ElevatorCommandGroup(GamePiece gamePiece, int level) {
        desiredElevatorEncoderPos = gamePiece.getElevatorEncoderPos(level);
        desiredIntakeRotateEncoderPos = gamePiece.getIntakeElbowEncoderPos(level);
        addParallel(new SetIntakeRotateCommand(desiredIntakeRotateEncoderPos));
        addSequential(new SetElevatorCommand(desiredElevatorEncoderPos));
    }

}