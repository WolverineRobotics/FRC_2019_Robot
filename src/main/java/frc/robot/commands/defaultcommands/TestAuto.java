package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.ExecuteAfterWaitCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.commands.autonomouscommands.WaitCommand;

/**
 * TestAuto
 */
public class TestAuto extends CommandGroup{
    public TestAuto(){
        addSequential(new DriveDistanceCommand(0.2, 191, 0, true));
        addSequential(new RotateToHeadingCommand(90));
    }
}