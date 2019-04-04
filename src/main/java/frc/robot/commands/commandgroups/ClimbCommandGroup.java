package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateGyroCommand;
import frc.robot.commands.autonomouscommands.ClimbLockCommand;
import frc.robot.commands.autonomouscommands.SetClimbCommand;
// import frc.robot.commands.autonomousfunctions.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetClimbGyroCommand;


//Presses Y, elevator full down, lock, intake full back
//inake goes down (pushup, set encoder position), climb motor (encoder pos)
// 
//addsequentioal

//make note of encoder position


public class ClimbCommandGroup extends CommandGroup{

    private double intakeMaxSpeed;
    private double climbMaxSpeed;

    private double targetAngle;


    //Current button Y in climbDefaultCommand
    public ClimbCommandGroup(){

        intakeMaxSpeed = 0.5; //TODO: Change auto intake rotate and climb speed
        climbMaxSpeed = 0.36;

        targetAngle = -1.5; //TODO: Tune angle

        addSequential(new SetElevatorCommand(0, 0.4));  //TODO: Change speed to actual value
        addSequential(new SetIntakeRotateCommand(0, 0.4)); //TODO: Change speed to actual value
        addSequential(new ClimbLockCommand(true));

        addParallel(new SetIntakeRotateGyroCommand(intakeMaxSpeed, targetAngle, true)); // TODO:Change to encoder value
        addSequential(new SetClimbGyroCommand(climbMaxSpeed, targetAngle, true)); //TODO:Change to encoder value
        
    }

}