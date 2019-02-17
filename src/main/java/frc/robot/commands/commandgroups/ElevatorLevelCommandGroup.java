package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.SetElevatorLevelCommand;
import frc.robot.commands.SetIntakeElbowCommand;
import frc.robot.constants.GamePiece;

public class ElevatorLevelCommandGroup extends CommandGroup {


    public ElevatorLevelCommandGroup(int level) {
        GamePiece gamePiece = Robot.getIntakeInOutSubsystem().getCurrentGamePiece();
        
        addSequential(new SetElevatorLevelCommand(gamePiece, level));
        addParallel(new SetIntakeElbowCommand(gamePiece, level));
    }
}