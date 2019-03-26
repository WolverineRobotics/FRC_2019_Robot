package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.constants.GamePiece;

/**
 * For Operator X Button (Player Station Ball)
 * Will go up to Player Station Ball height
 */

public class PlayerStationCommandGroup extends CommandGroup {

    public PlayerStationCommandGroup(GamePiece gamePiece) {
        addParallel(new SetIntakeRotateCommand(gamePiece.getIntakeRotatePlayerStation(), 1));
        addSequential(new SetElevatorCommand(gamePiece.getElevatorPlayerStation(), 0.8));
    }

}