package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultClimbCommand;
import frc.robot.constants.RobotMap;

public class ClimbSubsystem extends Subsystem {

    private TalonSRX wheel;
    private TalonSRX lift;

    private Encoder liftEncoder;

    public ClimbSubsystem() {
        wheel = new TalonSRX(RobotMap.CLIMB_MOTOR_WHEEL_ADDRESS);
        lift = new TalonSRX(RobotMap.CLIMB_MOTOR_LIFT_ADDRESS);

        liftEncoder = new Encoder(RobotMap.CLIMB_LIFT_ENCODER_A, RobotMap.CLIMB_LIFT_ENCODER_B);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DefaultClimbCommand());
    }

    //****************************************************************
    // Speed controller methods
    //****************************************************************
    public void setWheelRawSpeed(double speed) {
        wheel.set(ControlMode.PercentOutput, speed);
    }

    public double getWheelSpeed() {
        return wheel.getSelectedSensorVelocity(0);
    }

    public void setLiftRawSpeed(double speed) {
        lift.set(ControlMode.PercentOutput, speed);
    }

    public double getLiftSpeed() {
        return lift.getSelectedSensorVelocity(0);
    }

    //****************************************************************
    // Encoder methods
    //****************************************************************
    public void setLiftEncoderCountsPerInch(double countersPerInch) {
        liftEncoder.setDistancePerPulse(countersPerInch);
    }

    public double getLiftEncoderDistance() {
        return liftEncoder.getDistance();
    }

    public int getLiftEncoderPosition() {
        return liftEncoder.get();
    }
}