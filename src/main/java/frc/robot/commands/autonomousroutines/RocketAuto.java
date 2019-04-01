package frc.robot.commands.autonomousroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class RocketAuto extends CommandGroup {
    
    CameraSubsystem c_camera = Robot.m_camera;
    DriveSubsystem c_drive = Robot.getDriveSubsystem();
    
    public enum RocketAutos{
        TWO_LOWER_HATCH, TWO_OPPOSITE_SIDE;
    }

    public RocketAuto(RocketAutos rocketAuto){
        switch(rocketAuto){
            case TWO_LOWER_HATCH:
                twoLowerHatch();
                break;
            case TWO_OPPOSITE_SIDE:
                twoOppositeSide();
                break;
        }
    }

    private void twoLowerHatch(){
        addParallel(new SetIntakeRotateCommand(-130, 1));
        addSequential(new DriveDistanceCommand(-0.5, -220, 0, false));
        addSequential(new DriveDistanceCommand(0.5, -20, 30, false));
        addSequential(new RotateToHeadingCommand(c_drive.getPigeonHeading() - c_camera.getDegreesOff()));
    }

    private void twoOppositeSide(){

    }
}