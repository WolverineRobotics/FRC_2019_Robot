package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultClimbCommand;
import frc.robot.constants.RobotMap;

public class ClimbSubsystem extends Subsystem {
    private TalonSRX climb = new TalonSRX(RobotMap.CLIMB_MOTOR_LIFT_ADDRESS);
    private TalonSRX wheel = new TalonSRX(RobotMap.CLIMB_MOTOR_WHEEL_ADDRESS);

    private boolean inClimbMode;

    private double climbRawSpeed;
    private double wheelRawSpeed;

    public ClimbSubsystem() {
        climb.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        wheel.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        inClimbMode = false;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultClimbCommand());
    }

    public boolean getClimbMode() {
        return inClimbMode;
    }

    public void setClimbMode(boolean climbMode) {
        inClimbMode = climbMode;
    }

    //********************************************************************************** 
    // Encoder functions
    //**********************************************************************************
    public void setClimbRawPosition(int position) {
        climb.setSelectedSensorPosition(position); //TODO check
    }

    public int getClimbRawPosition() {
        return climb.getSelectedSensorPosition(0);
    }

    public void setWheelRawPosition(int position) {
        wheel.setSelectedSensorPosition(position); //TODO check
    }

    public int getWheelRawPosition() {
        return wheel.getSelectedSensorPosition(0);
    }

    //********************************************************************************** 
    // Speed controller functions
    //**********************************************************************************
    public void setWheelRawSpeed(double percent) {
        if(percent > 1) {
            percent = 1;
        } else if(percent < -1) {
            percent = -1;
        }
        wheelRawSpeed = percent;
        wheel.set(ControlMode.PercentOutput, wheelRawSpeed);
    }

    public double getWheelRawSpeed() {
        return wheelRawSpeed;
    }

    public void setClimbRawSpeed(double percent) {
        if(percent > 1) {
            percent = 1;
        } else if(percent < -1) {
            percent = -1;
        }
        climbRawSpeed = percent;
        climb.set(ControlMode.PercentOutput, climbRawSpeed); //TODO check
    }

    public double getClimbRawSpeed() {
        return climbRawSpeed;
    }
}