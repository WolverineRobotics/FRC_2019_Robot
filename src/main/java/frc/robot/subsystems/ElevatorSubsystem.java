package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultElevatorCommand;
import frc.robot.constants.RobotMap;

public class ElevatorSubsystem extends Subsystem {
    private CANSparkMax elevatorMotor1;
    private CANSparkMax elevatorMotor2;

    private DigitalInput upperLimitSwitch;
    private DigitalInput lowerLimitSwitch;

    private Encoder mainElevatorEncoder;

    public ElevatorSubsystem() {
        elevatorMotor1 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
        elevatorMotor2 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);

        lowerLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_LOWER_LIMIT_SWITCH);
        upperLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_UPPER_LIMIT_SWITCH);

        mainElevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_A, RobotMap.ELEVATOR_ENCODER_B);
    }

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

    public double getElevatorRawSpeed() {
        return (elevatorMotor1.get() + elevatorMotor2.get()) / 2;
    }

    //********************************************************************************** 
    // Sensor functions 
    //**********************************************************************************
    public int getEncoderRawCounts() {
        return mainElevatorEncoder.get();
    }

    public double getEncoderDistance() {
        return mainElevatorEncoder.getDistance();
    }

    public void setEncoderCountsPerInch(double countsPerInch) {
        mainElevatorEncoder.setDistancePerPulse(countsPerInch);
    }

    public boolean getUpperLimitSwitch() {
        return upperLimitSwitch.get();
    }

    public boolean getLowerLimitSwitch() {
        return lowerLimitSwitch.get();
    }
}