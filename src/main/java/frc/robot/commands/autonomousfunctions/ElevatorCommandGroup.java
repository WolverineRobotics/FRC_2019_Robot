package frc.robot.commands.autonomousfunctions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.constants.GamePiece;

/**
 * For Operator Buttons: A (level 1), B (level 2), Y (level 3)
 * GamePiece enum is determined by ball sensor. See DefaultElevatorCommand.java
 */

public class ElevatorCommandGroup extends CommandGroup {

    public ElevatorCommandGroup(GamePiece gamePiece, int level) {
        addParallel(new SetIntakeRotateCommand(gamePiece.getElevatorEncoderPos(level)));
        addSequential(new SetElevatorCommand(gamePiece.getIntakeElbowEncoderPos(level)));
    }

}