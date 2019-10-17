package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.constants.GamePiece;

public class AutoHatchDeliverCommand extends CommandGroup {

    public AutoHatchDeliverCommand(int level, double inchesToDeliver){
        addSequential(new RotateToVisionTargetCommand());
        addParallel(new SetIntakeRotateCommand(GamePiece.HATCH.getIntakeRotateEncoderPos(level), 0.8));
        addParallel(new SetElevatorCommand(GamePiece.HATCH.getElevatorEncoderPos(level), 0.7));
        addParallel(new OpenShovelCommand(true));
        addSequential(new DriveDistanceCommand(0.3, inchesToDeliver, Robot.getDriveSubsystem().getPigeonHeading(), true));
        addSequential(new OpenClawCommand(true));
        addSequential(new SimpleBackawayCommand(10, 0.5));
    }
}