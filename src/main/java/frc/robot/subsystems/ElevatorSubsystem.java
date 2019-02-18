package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultElevatorCommand;
import frc.robot.constants.RobotMap;

public class ElevatorSubsystem extends Subsystem {
    private CANSparkMax elevatorMotor1 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
    private CANSparkMax elevatorMotor2 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);

    private DigitalInput upperLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_UPPER_LIMIT_SWITCH);
    private DigitalInput lowerLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_LOWER_LIMIT_SWITCH);

    private Encoder mainElevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_A, RobotMap.ELEVATOR_ENCODER_B);

    private DoubleSolenoid shift = new DoubleSolenoid(RobotMap.ELEVATOR_PCM_MODULE_ADDRESS,
        RobotMap.ELEVATOR_PISTON_SHIFT_FORWARD_ADDRESS,
        RobotMap.ELEVATOR_PISTON_SHIFT_REVERSE_ADDRESS);

    private boolean lowGear = false;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultElevatorCommand());
    }
    
    //********************************************************************************** 
    // Motor functions
    //********************************************************************************** 
    public void setElevatorRawSpeed(double speed) {
        if (speed > 1) {
            speed = 1;
        }

        if (speed < -1) {
            speed = -1;
        }

        elevatorMotor1.set(speed);
        elevatorMotor2.set(speed);
    }
    
    //********************************************************************************** 
    // Shift functions
    //**********************************************************************************    
    public void setLowGear() {
        shift.set(Value.kReverse);
    }

    //********************************************************************************** 
    // Encoder functions
    //**********************************************************************************
    public double getRawEncoderPosition(){
        return elevatorMotor1.getEncoder().getPosition();
    }

    public double getRawEncoderSpeed() {
        return (elevatorMotor1.getEncoder().getVelocity() + elevatorMotor2.getEncoder().getVelocity()) / 2;
    }

    public boolean getUpperLimitSwitch() {
        return upperLimitSwitch.get();
    }

    public boolean getLowerLimitSwitch() {
        return lowerLimitSwitch.get();
    }
}