package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.commands.autonomouscommands.ClimbLockCommand;
// import frc.robot.commands.autonomousfunctions.SetElevatorCommand;


//Presses Y, elevator full down, lock, intake full back
//inake goes down (pushup, set encoder position), climb motor (encoder pos)
// 
//addsequentioal

//make note of encoder position


public class ClimbCommandGroup extends CommandGroup{

    public ClimbCommandGroup(){
        addSequential(new SetElevatorCommand(0, 0.4));  //TODO: Change speed to actual value
        addSequential(new SetIntakeRotateCommand(0, 0.4)); //TODO: Change speed to actual value
        addSequential(new ClimbLockCommand(true));

        // addSequential(new SetIntakeRotateCommand(0)); // TODO:Change to encoder value
        // addSequential(new SetClimbCommand(0)); //TODO:Change to encoder value
        
    }

}