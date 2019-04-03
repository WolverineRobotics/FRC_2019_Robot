package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;

/**
 * TestAuto
 */
public class TestAuto extends CommandGroup{
	
    private DriveSubsystem c_drive;
    private CameraSubsystem c_camera;
	
    public TestAuto(){
        c_camera = Robot.m_camera;
    	c_drive = Robot.getDriveSubsystem();
        requires(c_drive);

        addSequential(new DriveDistanceCommand(0.4, 191, 0, true));
        addSequential(new RotateToHeadingCommand(90));
        
        addSequential(new DriveDistanceCommand(0.1, 5, c_drive.getPigeonHeading(), true));
    }
}