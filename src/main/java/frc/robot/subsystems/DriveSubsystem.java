package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultDriveCommand;
import frc.robot.constants.RobotMap;
import frc.robot.constants.RobotPIDValues;
import frc.robot.pid.GyroPID;
import frc.util.PID;

public class DriveSubsystem extends Subsystem {

    private CANSparkMax leftDrive01, leftDrive02, rightDrive01, rightDrive02;
    private Encoder leftEncoder, rightEncoder;
    private AHRS navX;
    public PigeonIMU pigeon;

    public GyroPID gyroPID;

    /**
     * Drive train subsystem
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

        navX.reset();
        pigeon.setFusedHeadingToCompass();
    
        gyroPID = new GyroPID(RobotPIDValues.GYRO_KP, RobotPIDValues.GYRO_KI, RobotPIDValues.GYRO_KD);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultDriveCommand());
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

        leftDrive01.set(speed);
        leftDrive02.set(speed);
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

        rightDrive01.set(speed);
        rightDrive02.set(speed);
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

    public double getDistanceLeftEncoder(){
        return leftEncoder.getDistance();
    }

    public double getDistanceRightEncoder(){
        return rightEncoder.getDistance();
    }

    public double getDistance(){
        return (getDistanceLeftEncoder() + getDistanceRightEncoder())/2;
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
        return (double) navX.getYaw();
    }

    /**
     * returns the gyro heading
     * @return double value in degrees
     */
    public double getPigeonHeading() {
        return pigeon.getFusedHeading();
    }
    
    /**
     * resets the gyro heading
     */
    public void resetHeading() {
        navX.reset();
    }

    /**
     * Set the Encoder counts Per Inch
     */
    public void setEncoderCountsPerInch(double encoderCountsPerInch) {
        leftEncoder.setDistancePerPulse(encoderCountsPerInch);
        rightEncoder.setDistancePerPulse(encoderCountsPerInch);
    }

    public double getLeftRawSpeed() {
        return (leftDrive01.get() + leftDrive02.get()) /2;
    }

    public double getRightRawSpeed() {
        return (rightDrive01.get() + rightDrive02.get()) / 2;
    }
    
    //********************************************************************************** 
    // PID functions
    //**********************************************************************************

}