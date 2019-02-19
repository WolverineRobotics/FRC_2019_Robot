package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;
import frc.robot.oi.OI;
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
    }

    //********************************************************************************** 
    // Motor functions
    //**********************************************************************************

    /**
     * sets raw speeds for each side of the drive train
     * @param left double percent power between -1 and 1
     * @param right double percent power between -1 and 1
     */
    public void setRawSpeeds(double left, double right)  {
    }
    
    public void setRawLeftSpeed(double percent) {
        rightMotor1.set(percent);
    }
}