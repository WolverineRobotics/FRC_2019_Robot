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
    public double getClimbPosition() {
        return climb.getSelectedSensorPosition(0);
    }

    public double getClimbVelocity() {
        return climb.getSelectedSensorVelocity(0);
    }

    public void setClimbVelocity(double velocity) {
        climb.set(ControlMode.Velocity, velocity); //TODO check
    }

    public void setClimbPosition(int position) {
        climb.setSelectedSensorPosition(position); //TODO check
    }

    public double getWheelPosition() {
        return wheel.getSelectedSensorPosition(0);
    }

    public double getWheelVelocity() {
        return wheel.getSelectedSensorVelocity(0);
    }

    public void setWheelVelocity(double velocity) {
        wheel.set(ControlMode.Velocity, velocity); //TODO check
    }

    public void setWheelPosition(int position) {
        wheel.setSelectedSensorPosition(position); //TODO check
    }
}