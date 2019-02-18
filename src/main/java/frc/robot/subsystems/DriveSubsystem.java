package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultDriveCommand;
import frc.robot.constants.RobotMap;
import frc.util.ColourSensor;

public class DriveSubsystem extends Subsystem {
    private CANSparkMax leftMotor1 = new CANSparkMax(RobotMap.DRIVE_LEFT_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
    private CANSparkMax leftMotor2 = new CANSparkMax(RobotMap.DRIVE_LEFT_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);
    private CANSparkMax rightMotor1 = new CANSparkMax(RobotMap.DRIVE_RIGHT_MOTOR_MASTER_ADDRESS, MotorType.kBrushless);
    private CANSparkMax rightMotor2 = new CANSparkMax(RobotMap.DRIVE_RIGHT_MOTOR_SLAVE_ADDRESS, MotorType.kBrushless);

    private Encoder leftEncoder = new Encoder(RobotMap.DRIVE_LEFT_ENCODER_A, RobotMap.DRIVE_LEFT_ENCODER_B);
    private Encoder rightEncoder = new Encoder(RobotMap.DRIVE_RIGHT_ENCODER_A, RobotMap.DRIVE_RIGHT_ENCODER_B);

    private AHRS gyro = new AHRS(SPI.Port.kMXP);
    private PigeonIMU pigeon = new PigeonIMU(RobotMap.DRIVE_PIGEON_IMU_ADDRESS);

    private ColourSensor colourSensor = new ColourSensor(I2C.Port.kMXP);

    public DoubleSolenoid shift = new DoubleSolenoid(RobotMap.DRIVE_PISTON_SHIFT_FORWARD_ADDRESS, RobotMap.DRIVE_PISTON_SHIFT_REVERSE_ADDRESS);

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultDriveCommand());
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
    public int getRawLeftEncoder() {
        return leftEncoder.get();
    }

    public int getRawRightEncoder() {
        return rightEncoder.get();
    }

    public void resetLeftEncoder() {
        leftEncoder.reset();
    }

    public void resetRightEncoder() {
        rightEncoder.reset();
        
    }

    public void resetEncoders() {
        resetLeftEncoder();
        resetRightEncoder();
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

    public void resetPigeonAngle() {
        pigeon.setFusedHeading(0);
    }

    //********************************************************************************** 
    // Colour sensor functions
    //********************************************************************************** 
    public void readColourSensor()  {
        colourSensor.read();
    }
    
    public short getRed() {
        return colourSensor.red;
    }
    
    public short getGreen() {
        return colourSensor.green;
    }

    public short getBlue() {
        return colourSensor.blue;
    }
}