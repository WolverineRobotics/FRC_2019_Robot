package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.AutoHatchDeliverCommand;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.commands.autonomouscommands.SimpleBackawayCommand;

public class SecondHatch extends CommandGroup {

    public SecondHatch() {
        System.out.println("Grabbing hatch");
        addSequential(new OpenClawCommand(false)); //closes claw (grabs hatch)
        addParallel(new SimpleBackawayCommand(5, 0.25)); //backs away
        addSequential(new OpenShovelCommand(false)); //closes shovel
        addSequential(new RotateToHeadingCommand(0)); //look front
        addSequential(new DriveDistanceCommand(0.25, 105 /* TBD */, 0, true));
        addSequential(new RotateToHeadingCommand(90));
        addSequential(new AutoHatchDeliverCommand());
    }

}