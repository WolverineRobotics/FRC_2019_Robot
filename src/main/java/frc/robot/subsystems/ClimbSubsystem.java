package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultClimbCommand;
import frc.robot.constants.RobotMap;

public class ClimbSubsystem extends Subsystem {

    private TalonSRX wheel;
    private TalonSRX lift;

    private DoubleSolenoid lock;

    private Encoder liftEncoder;

    private boolean climbingMode;

    public ClimbSubsystem() {
        wheel = new TalonSRX(RobotMap.CLIMB_MOTOR_WHEEL_ADDRESS);
        lift = new TalonSRX(RobotMap.CLIMB_MOTOR_LIFT_ADDRESS);
        liftEncoder = new Encoder(RobotMap.CLIMB_LIFT_ENCODER_A, RobotMap.CLIMB_LIFT_ENCODER_B);
        lock = new DoubleSolenoid(RobotMap.CLIMB_LOCK_PCM_ADDRESS, RobotMap.CLIMB_LOCK_FORWARD_ADDRESS,
                RobotMap.CLIMB_LOCK_REVERSE_ADDRESS);
                
        wheel.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        lift.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        liftEncoder.reset();
        lock.set(Value.kOff);
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

    public double getWheelRawSpeed() {
        return wheel.getSelectedSensorVelocity(0);
    }

    public void setLiftRawSpeed(double speed) {
        lift.set(ControlMode.PercentOutput, speed);
    }

    public double getLiftRawSpeed() {
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

    public void resetEncoders() {
        liftEncoder.reset();
    }

    //****************************************************************
    // Solenoid methods
    //****************************************************************
    public void unlockLock(boolean activate) {
        if (activate) {
            lock.set(Value.kForward);
        } else {
            lock.set(Value.kReverse);
        }
    }

    //****************************************************************
    // Climbing Mode methods
    //****************************************************************
    public boolean getClimbingMode() {
        return climbingMode;
    }

    public void setClimbingMode(boolean climbingMode) {
        this.climbingMode = climbingMode;
    }
}