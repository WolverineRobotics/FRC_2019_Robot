package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultIntakeCommand;
import frc.robot.constants.RobotMap;

public class IntakeSubsystem extends Subsystem {
    private TalonSRX intakeMotor = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);
    private TalonSRX tiltMotor = new TalonSRX(RobotMap.INTAKE_MOTOR_TILT_ADDRESS);

    private DoubleSolenoid kachunker = new DoubleSolenoid(
        RobotMap.INTAKE_PISTON_KACHUNKER_FORWARD_ADDRESS,
        RobotMap.INTAKE_PISTON_KACHUNKER_REVERSE_ADDRESS);

    private DoubleSolenoid claw = new DoubleSolenoid(
        RobotMap.INTAKE_PISTON_CLAW_FORWARD_ADDRESS,
        RobotMap.INTAKE_PISTON_CLAW_REVERSE_ADDRESS);

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new defaultIntakeCommand());
    }
    

}