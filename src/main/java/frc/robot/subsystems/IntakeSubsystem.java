package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultIntakeCommand;
import frc.robot.constants.RobotMap;

public class IntakeSubsystem extends Subsystem {
    private CANSparkMax intakeMotor = new CANSparkMax(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS, MotorType.kBrushless);
    private CANSparkMax tiltMotor = new CANSparkMax(RobotMap.INTAKE_MOTOR_TILT_ADDRESS, MotorType.kBrushless);

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new defaultIntakeCommand());
    }
    
}