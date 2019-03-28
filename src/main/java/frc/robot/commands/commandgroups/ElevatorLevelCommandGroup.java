package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.constants.GamePiece;

/**
 * For Operator Buttons: A (level 1), B (level 2), Y (level 3)
 * GamePiece enum is determined by ball sensor. See DefaultElevatorCommand.java
 */

public class ElevatorLevelCommandGroup extends CommandGroup {

    public ElevatorLevelCommandGroup(GamePiece gamePiece, int level) {
        addParallel(new SetIntakeRotateCommand(gamePiece.getIntakeRotateEncoderPos(level), 1));
        addSequential(new SetElevatorCommand(gamePiece.getElevatorEncoderPos(level), 0.8));
    }
}