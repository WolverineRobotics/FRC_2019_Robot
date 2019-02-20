package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotConst;
import frc.robot.constants.RobotMap;

public class DriveSubsystem extends Subsystem {
    
    private CANSparkMax leftDrive01, leftDrive02, rightDrive01, rightDrive02;
    private Encoder leftEncoder, rightEncoder;
    private AHRS navX;
    private PigeonIMU pigeon;
    /**
     * Drive train subsystem
     * 
     * include drive motors, gyro, and encoders
     */
    public DriveSubsystem() {
        leftDrive01 = new CANSparkMax(RobotMap.DRIVE_LEFT_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
        leftDrive02 = new CANSparkMax(RobotMap.DRIVE_LEFT_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);
        rightDrive01 = new CANSparkMax(RobotMap.DRIVE_RIGHT_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
        rightDrive02 = new CANSparkMax(RobotMap.DRIVE_RIGHT_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);

        leftEncoder = new Encoder(RobotMap.DRIVE_LEFT_ENCODER_A, RobotMap.DRIVE_LEFT_ENCODER_B);
        rightEncoder = new Encoder(RobotMap.DRIVE_RIGHT_ENCODER_A, RobotMap.DRIVE_RIGHT_ENCODER_B);

        navX = new AHRS(Port.kMXP);
        pigeon = new PigeonIMU(RobotMap.DRIVE_PIGEON_IMU_ADDRESS);
    }
    
    @Override
    protected void initDefaultCommand() {

    }

    /**
     * Sets the raw speeds of the motor
     * @param left double value between -1 and 1
     * @param right double value between -1 and 1
     */
    public void setRawSpeeds(double left, double right) {
        setRawLeftSpeed(left);
        setRawRightSpeed(right);
    }

    /**
     * Sets the raw speed of the left side drive
     * @param speed double value between -1 and 1
     */
    public void setRawLeftSpeed(double speed) {
        if (speed < -1) {
            speed = -1;
        } else if (speed > 1) {
            speed = 1;
        }

        leftDrive01.set(speed * RobotConst.DRIVE_SPEED_REDUCTION_RATIO);
        leftDrive02.set(speed * RobotConst.DRIVE_SPEED_REDUCTION_RATIO);
    }

    /**
     * Sets the raw speed of the right side drive
     * @param speed double value between -1 and 1
     */
    public void setRawRightSpeed(double speed) {
        if (speed < -1) {
            speed = -1;
        } else if (speed > 1) {
            speed = 1;
        }

        rightDrive01.set(speed * RobotConst.DRIVE_SPEED_REDUCTION_RATIO);
        rightDrive02.set(speed * RobotConst.DRIVE_SPEED_REDUCTION_RATIO);
    }

    /**
     * returns the absolute raw encoder counts of the left encoder
     * @return int number of counts to deliver
     */
    public int getRawLeftEncoder() {
        return leftEncoder.get();
    }

    /**
     * returns the absolute encoder counts of the right encoder
     * @return int number of counts to deliver
     */
    public int getRawRightEncoder() {
        return rightEncoder.get();
    }


    /**
     * resets encoder values
    */
    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    /**
     * returns the gyro heading
     * @return double value in degrees
     */
    public double getHeading() {
        return (double) navX.getPitch();
    }
    
    public void resetHeading() {
        navX.reset();
    }

    public double getLeftRawSpeed() {
        return (leftDrive01.get() + leftDrive02.get()) / 2;
    }

    public double getRightRawSpeed() {
        return (rightDrive01.get() + rightDrive02.get()) / 2;
    }
}