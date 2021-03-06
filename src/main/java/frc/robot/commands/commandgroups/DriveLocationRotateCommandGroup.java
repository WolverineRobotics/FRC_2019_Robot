package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.DriveDistanceLocationCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;

public class DriveLocationRotateCommandGroup extends CommandGroup {
        
    public DriveLocationRotateCommandGroup(double power, double distance, double heading){
        this(power, distance, heading, true);
    }

    public DriveLocationRotateCommandGroup(double power, double distance, double heading, Boolean breakWhenFinished){
        // addSequential(new RotateToHeadingCommand(heading));
        addSequential(new DriveDistanceLocationCommand(power, distance, heading, breakWhenFinished));
        addSequential(new DriveDistanceCommand(power, 0.2, heading, breakWhenFinished));
        addSequential(new RotateToHeadingCommand(heading));
    }


}