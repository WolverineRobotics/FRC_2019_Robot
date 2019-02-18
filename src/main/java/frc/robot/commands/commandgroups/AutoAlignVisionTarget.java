package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.AutoFindVisionTarget;

public class AutoAlignVisionTarget extends CommandGroup {
    
    public AutoAlignVisionTarget() {
        addSequential(new AutoFindVisionTarget());
    }
}