package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeHatchCommandGroup extends CommandGroup {

    //intake kiss floor
    //

    public IntakeHatchCommandGroup() {
        addSequential(new SetIntakeRotateCommand(0/* TBD */));
        
    }

}