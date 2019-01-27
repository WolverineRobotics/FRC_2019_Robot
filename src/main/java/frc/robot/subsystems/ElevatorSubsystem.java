package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultElevatorCommand;

public class ElevatorSubsystem extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new defaultElevatorCommand());
    }
    
}