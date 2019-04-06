package frc.robot.subsystems;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANDigitalInput.LimitSwitch;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultElevatorCommand;
import frc.robot.constants.RobotConst;
import frc.robot.constants.RobotMap;

public class ElevatorSubsystem extends Subsystem {
    private CANSparkMax elevatorMotor1;
    private CANSparkMax elevatorMotor2;

    private CANDigitalInput upperLimitSwitch;

    private Encoder elevatorEncoder;

    public ElevatorSubsystem() {
        elevatorMotor1 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
        elevatorMotor2 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);

        upperLimitSwitch = new CANDigitalInput(elevatorMotor2, LimitSwitch.kReverse, LimitSwitchPolarity.kNormallyOpen);

        elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_A, RobotMap.ELEVATOR_ENCODER_B);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultElevatorCommand());
    }
    
    //********************************************************************************** 
    // Motor functions
    //********************************************************************************** 
    public void setElevatorRawSpeed(double speed) {

        int currentEncoderPos = getEncoderPosition();
        int softMax = RobotConst.ELEVATOR_SOFT_MAX_ENCODER_DISTANCE;
        int softMin = RobotConst.ELEVATOR_SOFT_MIN_ENCODER_DISTANCE;
        double softLimitMultiple = RobotConst.ELEVATOR_SOFT_LIMIT_MULTIPLE;

        if( currentEncoderPos > softMax && speed > 0 ){
            speed = speed * softLimitMultiple;
        }else if(currentEncoderPos < softMin && speed < 0){
            speed = speed * softLimitMultiple;
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
    public int getEncoderPosition() {
        return elevatorEncoder.get();
    }

    public double getEncoderDistance() {
        return elevatorEncoder.getDistance();
    }

    public void setEncoderCountsPerInch(double countsPerInch) {
        elevatorEncoder.setDistancePerPulse(countsPerInch);
    }

    public void resetEncoder() {
        elevatorEncoder.reset();
    }

    //********************************************************************************** 
    // Sensor functions 
    //**********************************************************************************
    public boolean getUpperLimitSwitch() {
        return upperLimitSwitch.get();
    }
}