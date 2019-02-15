package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultElevatorCommand;
import frc.robot.constants.RobotConst;
import frc.robot.constants.RobotMap;

public class ElevatorSubsystem extends Subsystem {
    private CANSparkMax elevatorMotor1 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
    private CANSparkMax elevatorMotor2 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);

    private DigitalInput upperLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_UPPER_LIMIT_SWITCH);
    private DigitalInput lowerLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_LOWER_LIMIT_SWITCH);

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultElevatorCommand());
    }
    
    //********************************************************************************** 
    // Motor functions
    //********************************************************************************** 
    public void setElevatorRawSpeed(double speed){
        if(speed > 1) {
            speed = 1;
        }
        if(speed < -1) {
            speed = -1;
        }
        if(getEncoderPosition() < RobotConst.ELEVATOR_MAX_HEIGHT) {
            elevatorMotor1.set(speed);
            elevatorMotor2.set(speed);
        } else {
            elevatorMotor1.set(0);
            elevatorMotor2.set(0);
        }
    }

    //********************************************************************************** 
    // Encoder functions
    //**********************************************************************************
    public double getEncoderPosition(){
        return elevatorMotor1.getEncoder().getPosition();
    }

    public double getEncoderRawVelocity() {
        return elevatorMotor1.getEncoder().getVelocity();
    }

    public boolean getUpperLimitSwitch() {
        return upperLimitSwitch.get();
    }

    public boolean getLowerLimitSwitch() {
        return lowerLimitSwitch.get();
    }
}