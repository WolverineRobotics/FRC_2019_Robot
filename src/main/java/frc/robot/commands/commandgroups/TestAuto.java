package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.commands.autonomouscommands.SimpleBackawayCommand;
import frc.robot.constants.GamePiece;
import frc.robot.subsystems.DriveSubsystem;

/**
 * TestAuto
 */
public class TestAuto extends CommandGroup{
	
    private DriveSubsystem c_drive;
    // private CameraSubsystem c_camera;
	
    // public TestAuto(){
    // c_camera = Robot.m_camera;
    //     requires(c_drive);

        // addSequential(new DriveDistanceCommand(0.4, 191, 0, true));
        // addSequential(new RotateToHeadingCommand(90));
        // addSequential(new RotateToHeadingCommand(c_drive.getPigeonHeading() - c_camera.getDegreesOff()));
        // addSequential(new DriveDistanceCommand(0.1, 5, c_drive.getPigeonHeading(), true));


    // }
        public TestAuto(int pos){
            c_drive = Robot.getDriveSubsystem();
            if(pos == 0){
                /* 
                 * front hatch
                 */
            } else if(pos == 1 || pos == 2 || pos == 3){
                double dist1;
                double angle2;
                double dist2;
    
                System.out.println("Driving towards cargo ship position " + pos);
                if(pos == 1){
                    dist1 = 135;//approach cargoship distance
                    dist2 = 255;//approach player station distance
                    angle2 = 201.23;//approach player station angle
                } else if(pos == 2){
                    dist1 = 210.55;
                    dist2 = 285;
                    angle2 = 199.67;
                } else{
                    dist1 = 255.10;
                    dist2 = 295; 
                    angle2 = 198.25;
                }
                
                addParallel(new SetIntakeRotateCommand(-20, 1));
                addParallel(new OpenShovelCommand(false));
                addSequential(new WaitCommand(0.5));
                addSequential(new OpenClawCommand(false));
                addSequential(new DriveDistanceCommand(0.4, 24, 0, false));
                addSequential(new DriveDistanceCommand(0.7, 24, 0, false));
                addSequential(new DriveDistanceCommand(0.7, 50, -40, false));
                addSequential(new DriveDistanceCommand(0.7, dist1 - 32, 0, false));
                addSequential(new DriveDistanceCommand(0.4, 32, 0, false));
                
                System.out.println("Rotating to cargoship");
                addSequential(new RotateToHeadingCommand(90));
                // addParallel(new SimpleBackawayCommand(1, 0.20));
                addSequential(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1));
                // addParallel(new OpenShovelCommand(true));
                addSequential(new DriveDistanceCommand(0.1, 40, 90, true));
    
                System.out.println("Delivering hatch");
                // addSequential(new OpenClawCommand(true));
    
                System.out.println("Backing away");
                // addSequential(new SimpleBackawayCommand(3, 0.20));
                // addSequential(new SetIntakeRotateCommand(0, 1));
                // addSequential(new DriveDistanceCommand(0.5, -12, 90, false));
    
                // System.out.println("Returning to alliance station");
                // addSequential(new RotateToHeadingCommand(180));
                // addSequential(new DriveDistanceCommand(05, dist2, angle2, true));
    
                // System.out.println("Finding player station");
                // addSequential(new RotateToVisionTargetCommand());
                // addSequential(new DriveDistanceCommand(5, 0.35, 180, false));
    
            }
        }
    
}