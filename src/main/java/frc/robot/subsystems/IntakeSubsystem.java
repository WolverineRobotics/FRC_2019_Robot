package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultIntakeCommand;

public class IntakeSubsystem extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new defaultIntakeCommand());
    }
    
}