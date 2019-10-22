
package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.commands.autonomouscommands.WaitCommand;
import frc.robot.constants.GamePiece;
import frc.robot.subsystems.IntakeSubsystem;

/*
1. Rotate intake 10 deg
2. Toggle shovel inwards
3. Toggle claw (active)
4. Rotate intake 80 deg (flush with cargoship)
5. Set elevator to height 1
6. Move forward 134 inches
7. Let go of shovel and hook
8. Move backwards 1 inch

*/

// Uses game piece constants


public class TestAndResetCommandGroup extends CommandGroup{

    private final double INTAKE_POWER = 0.45;
    
    //TODO: Set Encoder Pos
    private int intakeEncoderPos1 = -30;


    private final boolean REVERSE_SHOVEL = false; //Might need to be reveresed
    private final boolean REVERSE_CLAW = false;   //Might need to be reveresed

    private final double DRIVE_POWER = 0.25;
    private final double DRIVE_DISTANCE = 130; //Distance, in inches, 134

    private final double ELEVATOR_SPEED = 0.4;

    private final IntakeSubsystem c_intake = Robot.getIntakeSubsystem();


    /* 
    addParallel

    The child will run until either it finishes, a new child with conflicting requirements is started, 
    or the main sequence runs a Command with conflicting requirements. In the latter two cases, the 
    child will be canceled even if it says it can't be interrupted.

    The pheumatic commands and set intake rotate both require the intake subsystem. 
    They have conflicting requirements.
    Any attempt to put them in parallel will fail.
    
    */


    public TestAndResetCommandGroup(){
        autoDropHatchFromCenter();
        autoReturnToHome();
        }


    // Code assumes hatch is in the robot. Places hatch on center cargo ship and lets go.
    private void autoDropHatchFromCenter(){
        addSequential(new SetIntakeRotateCommand(this.intakeEncoderPos1, this.INTAKE_POWER));
        addSequential(new OpenShovelCommand(this.REVERSE_SHOVEL)); //2
        addSequential(new OpenClawCommand(this.REVERSE_CLAW)); //3
       
        
        addSequential(new DriveDistanceCommand(0.12,this.DRIVE_DISTANCE/2, 0,true)); //6
        addParallel(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1)); //4 & 5

        addSequential(new DriveDistanceCommand(this.DRIVE_POWER,this.DRIVE_DISTANCE/2, 0,true)); //6
        addSequential(new WaitCommand(1));
        addSequential(new OpenShovelCommand(!this.REVERSE_SHOVEL)); //7
        addSequential(new OpenClawCommand(!this.REVERSE_CLAW)); //7
        addSequential(new WaitCommand(1));
    }

    // Returns to starting position after autoDropHatchFromCenter.
    private void autoReturnToHome(){
            addSequential(new DriveDistanceCommand(- this.DRIVE_POWER,( -this.DRIVE_DISTANCE ), 0, true)); //Negative distance with negative power?

    }

}
