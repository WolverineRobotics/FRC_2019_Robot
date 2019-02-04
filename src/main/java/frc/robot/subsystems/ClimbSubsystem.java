package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultClimbCommand;
import frc.robot.constants.RobotMap;

public class ClimbSubsystem extends Subsystem {
    private TalonSRX climbMotor = new TalonSRX(RobotMap.CLIMB_MOTOR_LIFT_ADDRESS);
    private TalonSRX wheelMotor = new TalonSRX(RobotMap.CLIMB_MOTOR_WHEEL_ADDRESS);

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new defaultClimbCommand());
    }    
    //********************************************************************************** 
    // Motor Functions
    //**********************************************************************************
    public void setClimbSpeed(double speed) {
        climbMotor.set(ControlMode.PercentOutput, speed);
    }

    public void setWheelSpeed(double speed) {
        wheelMotor.set(ControlMode.PercentOutput, speed);
    }

    //********************************************************************************** 
    // Encoder functions
    //**********************************************************************************

    // TODO TEST ME
    public double getEncoderRawPosition(){
        climbMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30);
        return climbMotor.getSelectedSensorPosition();
    }
    
    // public double getEncoderRawVelocity(){
    //     return climbMotor.getSelectedSensorVelocity();
    // }
}