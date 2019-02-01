package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultDriveCommand;
import frc.robot.constants.RobotMap;

public class DriveSubsystem extends Subsystem {
    private CANSparkMax leftMotor1 = new CANSparkMax(RobotMap.DRIVE_LEFT_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
    private CANSparkMax leftMotor2 = new CANSparkMax(RobotMap.DRIVE_LEFT_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);
    private CANSparkMax rightMotor1 = new CANSparkMax(RobotMap.DRIVE_RIGHT_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
    private CANSparkMax rightMotor2 = new CANSparkMax(RobotMap.DRIVE_RIGHT_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);

    private CANEncoder leftEncoder1 = new CANEncoder(leftMotor1);
    private CANEncoder leftEncoder2 = new CANEncoder(leftMotor2);
    private CANEncoder rightEncoder1 = new CANEncoder(rightMotor1);
    private CANEncoder rightEncoder2 = new CANEncoder(rightMotor2);

    private AHRS gyro = new AHRS(SPI.Port.kMXP);
    private PigeonIMU pigeon = new PigeonIMU(RobotMap.DRIVE_PIGEON_IMU_ADDRESS);

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new defaultDriveCommand());
    }

    //********************************************************************************** 
    // Motor functions
    //********************************************************************************** 
    public void setRawSpeeds(double left, double right){
        setRawLeftSpeed(left);
        setRawRightSpeed(right);
    }

    public void setRawLeftSpeed(double speed) {
        leftMotor1.set(speed);
        leftMotor2.set(speed);
    }

    public void setRawRightSpeed(double speed) {
        rightMotor1.set(speed);
        rightMotor2.set(speed);
    }

    public double getRawLeftSpeed(){
        return leftMotor1.get();
    }

    public double getRawRightSpeed(){
        return rightMotor1.get();
    }
    
    //********************************************************************************** 
    // Encoder functions
    //********************************************************************************** 
    public double getPositionLeftMasterEncoder() {
        return leftEncoder1.getPosition();
    }

    public double getPositionLeftSlaveEncoder() {
        return leftEncoder2.getPosition();
    }

    public double getPositionRightMasterEncoder() {
        return rightEncoder1.getPosition();
    }
    
    public double getPositionRightSlaveEncoder() {
        return rightEncoder2.getPosition();
    }

    public double getPositionLeft() {
        return (getPositionLeftMasterEncoder() + getPositionLeftSlaveEncoder()) / 2;
    }

    public double getPositionRight() {
        return (getPositionRightMasterEncoder() + getPositionRightSlaveEncoder()) / 2;
    }

    public double getVelocityLeftMasterEncoder() {
        return leftEncoder1.getVelocity();
    }

    public double getVelocityLeftSlaveEncoder() {
        return leftEncoder2.getVelocity();
    }

    public double getVelocityRightMasterEncoder() {
        return rightEncoder1.getVelocity();
    }
    
    public double getVelocityRightSlaveEncoder() {
        return rightEncoder2.getVelocity();
    }

    public double getVelocityLeftEncoder() {
        return (getVelocityLeftMasterEncoder() + getVelocityLeftSlaveEncoder()) / 2;
    }

    public double getVelocityRightEncoder() {
        return (getVelocityRightMasterEncoder() + getVelocityRightSlaveEncoder()) / 2;
    }

    //********************************************************************************** 
    // Gyro functions
    //********************************************************************************** 
    public double getGyroAngle() {
        return (double) (gyro.getYaw() % 360);
    }

    public void resetGyro() {
        gyro.reset();
    }

    public double getPigeonAngle(){
        return (double) (pigeon.getFusedHeading() % 360);
    }

    public void resetPigeonAngle(){
        pigeon.setFusedHeading(0);
    }
}