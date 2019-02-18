package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.teleopcommands.SetElevatorLevelCommand;
import frc.robot.commands.teleopcommands.SetIntakeElbowCommand;
import frc.robot.constants.GamePiece;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class ElevatorLevelCommandGroup extends CommandGroup {

    private ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();
    private IntakeSubsystem c_intake = Robot.getIntakeSubsystem();

    private int level;

    public ElevatorLevelCommandGroup(int level) {
        this.level = level;
    }

    @Override
    public void execute() {
        GamePiece gamePiece = c_intake.getCurrentGamePiece();
        addSequential(new SetElevatorLevelCommand(gamePiece, level));
        addParallel(new SetIntakeElbowCommand(gamePiece, level));
    }
}