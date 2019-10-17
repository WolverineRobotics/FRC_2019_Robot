package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.RotateToVisionTargetCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.commands.autonomouscommands.WaitCommand;
import frc.robot.constants.GamePiece;

/**
 * FinalsAutoWestern
 */
public class FinalsAutoWestern extends CommandGroup{
    public FinalsAutoWestern(){
        addParallel(new SetIntakeRotateCommand(-20, 1));
        addParallel(new OpenShovelCommand(false));
        addSequential(new WaitCommand(0.5));
        addSequential(new OpenClawCommand(false));
        addSequential(new DriveDistanceCommand(0.2, 105, 0, true));
        // addSequential(new RotateToVisionTargetCommand());
        addSequential(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1));
        addSequential(new DriveDistanceCommand(0.2, 26, 0, true));

        addParallel(new OpenShovelCommand(true));
        addSequential(new WaitCommand(0.5));
        addSequential(new OpenClawCommand(true));
        addSequential(new SetIntakeRotateCommand(-160, 1));
    }
}