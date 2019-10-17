
package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.constants.GamePiece;

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

    private final double INTAKE_POWER = 0.25;
    
    //TODO: Set Encoder Pos
    private int intakeEncoderPos1 = 10;


    private final boolean REVERSE_SHOVEL = false; //Might need to be reveresed
    private final boolean REVERSE_CLAW = false;   //Might need to be reveresed

    private final double DRIVE_POWER = 0.25;
    private final double DRIVE_DISTANCE = 134; //Distance, in inches

    private final double ELEVATOR_SPEED = 0.25;

    public TestAndResetCommandGroup(){
        addSequential(new SetIntakeRotateCommand(this.intakeEncoderPos1, this.INTAKE_POWER )); //1
        addSequential(new OpenShovelCommand(this.REVERSE_SHOVEL)); //2
        addSequential(new OpenClawCommand(this.REVERSE_CLAW)); //3
        // addSequential(new SetIntakeRotateCommand(this.intakeEncoderPos2, this.INTAKE_POWER));
        addSequential(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1)); //4 & 5
        addSequential(new DriveDistanceCommand(this.DRIVE_POWER,this.DRIVE_DISTANCE, 0,true)); //6
        addParallel(new OpenShovelCommand(!this.REVERSE_SHOVEL)); //7
        addSequential(new OpenClawCommand(!this.REVERSE_CLAW)); //7
        addSequential(new DriveDistanceCommand(-this.DRIVE_POWER, -1, 0, true)); //Negative distance with negative power?

        // Resets itself
        addParallel(new DriveDistanceCommand(- this.DRIVE_POWER,( -this.DRIVE_DISTANCE - 1), 0, true)); //Negative distance with negative power?
        addParallel(new OpenClawCommand(!this.REVERSE_CLAW));
        addParallel(new OpenShovelCommand(!this.REVERSE_SHOVEL)); 
        addSequential(new SetIntakeRotateCommand(0, this.INTAKE_POWER));
        addSequential(new SetElevatorCommand(0, 0.25));

    }

    
}
