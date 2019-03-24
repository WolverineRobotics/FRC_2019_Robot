package frc.robot.subsystems;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANDigitalInput.LimitSwitch;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultElevatorCommand;
import frc.robot.constants.RobotMap;

public class ElevatorSubsystem extends Subsystem {
    private CANSparkMax elevatorMotor1;
    private CANSparkMax elevatorMotor2;

    // private DigitalInput upperLimitSwitch;
    // private DigitalInput lowerLimitSwitch;

    private CANDigitalInput upperLimitSwitch;

    private Encoder mainElevatorEncoder;

    //private PID positionPID;

    //private double desiredEncoderCounts;

    public ElevatorSubsystem() {
        elevatorMotor1 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
        elevatorMotor2 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);

        upperLimitSwitch = new CANDigitalInput(elevatorMotor2, LimitSwitch.kReverse, LimitSwitchPolarity.kNormallyOpen);
        
        // lowerLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_LOWER_LIMIT_SWITCH);
        // upperLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_UPPER_LIMIT_SWITCH);

        mainElevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_A, RobotMap.ELEVATOR_ENCODER_B);

        //positionPID = new PID(RobotPIDValues.ELEVATOR_POSITION_KP, RobotPIDValues.ELEVATOR_POSITION_KI,
                //RobotPIDValues.ELEVATOR_POSITION_KD, 0);

        //positionPID.setDesiredValue(getEncoderRawCounts());
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

    // public void setDesiredPosition(int position) {
    //     desiredEncoderCounts = position;
    //     positionPID.setDesiredValue(position);
    // }

    // public double getDesiredPosition() {
    //     return desiredEncoderCounts;
    // }
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

    public void resetEncoder() {
        mainElevatorEncoder.reset();
    }

    //********************************************************************************** 
    // Sensor functions 
    //**********************************************************************************
    public boolean getUpperLimitSwitch() {
        return upperLimitSwitch.get();
    }
}