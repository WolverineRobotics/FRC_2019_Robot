package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.constants.GamePiece;

public class AutoHatchDeliverCommand extends CommandGroup{
    
    public AutoHatchDeliverCommand(){
        addParallel(new SetIntakeRotateCommand(GamePiece.HATCH.getIntakeRotateEncoderPos(1), 1));
        addParallel(new OpenShovelCommand(true));
        addSequential(new DriveTowardsVisionTargetCommand(3));
        addSequential(new OpenClawCommand(true));
    }
}