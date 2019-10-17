package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.defaultcommands.DefaultClimbCommand;
import frc.robot.constants.RobotConst;
import frc.robot.constants.RobotMap;

public class ClimbSubsystem extends Subsystem {

    private TalonSRX wheel;
    private TalonSRX lift;
    private PigeonIMU pigeon;


    private DoubleSolenoid lock;

    private Encoder liftEncoder;

    // private boolean climbingMode;

    private double[] gyroValues;

    public ClimbSubsystem() {
        wheel = new TalonSRX(RobotMap.CLIMB_MOTOR_WHEEL_ADDRESS);
        lift = new TalonSRX(RobotMap.CLIMB_MOTOR_LIFT_ADDRESS);
        liftEncoder = new Encoder(RobotMap.CLIMB_LIFT_ENCODER_A, RobotMap.CLIMB_LIFT_ENCODER_B);
        lock = new DoubleSolenoid(RobotMap.CLIMB_LOCK_PCM_ADDRESS, RobotMap.CLIMB_LOCK_FORWARD_ADDRESS,
                RobotMap.CLIMB_LOCK_REVERSE_ADDRESS);
        pigeon = new PigeonIMU(RobotMap.DRIVE_PIGEON_IMU_ADDRESS);
                
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
        //Assumes positive encoder distance
        int currentEncoderPos = getLiftEncoderPosition();
        int softMax = RobotConst.CLIMB_SOFT_MAX_ENCODER_DISTANCE;
        int softMin = RobotConst.CLIMB_SOFT_MIN_ENCODER_DISTANCE;
        int hardMax = RobotConst.CLIMB_HARD_MAX_ENCODER_DISTANCE;
        int hardMin = RobotConst.CLIMB_HARD_MIN_ENCODER_DISTANCE;

        double softLimitMultiple = RobotConst.CLIMB_SOFT_LIMIT_MULTIPLE;
        double speedf = speed;
  
        if(currentEncoderPos > hardMin && speed > 0){
            speedf = 0;
        }else if( currentEncoderPos > softMax && speed > 0 ){
            speedf = speed * softLimitMultiple;
        }/*else if(currentEncoderPos < softMin && speed < 0){
            speedf = speed * softLimitMultiple;
        }
 */
        lift.set(ControlMode.PercentOutput, speedf);


    }

    public double getLiftRawSpeed() {
        return lift.getMotorOutputPercent();
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

    public boolean getLock(){
        if(lock.get() == Value.kForward){
            return false;
        } else {
            return true;
        }
    }


    //****************************************************************
    // Gyro methods
    //****************************************************************

    public double getGyroTilt(){
        pigeon.getYawPitchRoll(gyroValues);
        //Roll is actually pitch with the way the pigeon is mounted
        SmartDashboard.putNumber("GYRO TILT", gyroValues[2]);
        return gyroValues[2];
    }

}