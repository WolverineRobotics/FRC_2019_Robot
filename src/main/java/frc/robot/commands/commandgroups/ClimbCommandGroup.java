package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.commands.autonomouscommands.ClimbLockCommand;
import frc.robot.commands.autonomouscommands.SetClimbCommand;
// import frc.robot.commands.autonomousfunctions.SetElevatorCommand;


//Presses Y, elevator full down, lock, intake full back
//inake goes down (pushup, set encoder position), climb motor (encoder pos)
// 
//addsequentioal

//make note of encoder position


public class ClimbCommandGroup extends CommandGroup{

    private double intakeSpeed;
    private double climbSpeed;

    public ClimbCommandGroup(){

        intakeSpeed = 0.2; //TODO: Change auto intake rotate and climb speed
        climbSpeed = 0.2;

        addSequential(new SetElevatorCommand(0, 0.4));  //TODO: Change speed to actual value
        addSequential(new SetIntakeRotateCommand(0, 0.4)); //TODO: Change speed to actual value
        addSequential(new ClimbLockCommand(true));

        addParallel(new SetIntakeRotateCommand(0, intakeSpeed, true)); // TODO:Change to encoder value
        addSequential(new SetClimbCommand(0, climbSpeed, true)); //TODO:Change to encoder value
        
    }

}