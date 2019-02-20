package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeCommand;
import frc.robot.constants.RobotMap;

public class IntakeSubsystem extends Subsystem {

    private TalonSRX rotate;
    private TalonSRX rollers;

    private DoubleSolenoid kachunker;
    private DoubleSolenoid booper;

    private Encoder rotateEncoder;

    public IntakeSubsystem() {

        rotate = new TalonSRX(RobotMap.INTAKE_MOTOR_ROTATE_ADDRESS);
        rollers = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);

        kachunker = new DoubleSolenoid(RobotMap.INTAKE_PISTON_KACHUNKER_PCM_MODULE_ADDRESS,
                RobotMap.INTAKE_PISTON_KACHUNKER_FORWARD_ADDRESS, RobotMap.INTAKE_PISTON_KACHUNKER_REVERSE_ADDRESS);

        booper = new DoubleSolenoid(RobotMap.INTAKE_PISTON_BOOPER_PCM_MODULE_ADDRESS,
                RobotMap.INTAKE_PISTON_BOOPER_FORWARD_ADDRESS, RobotMap.INTAKE_PISTON_BOOPER_REVERSE_ADDRESS);

        rotateEncoder = new Encoder(RobotMap.INTAKE_ROTATE_ENCODER_A, RobotMap.INTAKE_ROTATE_ENCODER_B);

        kachunker.set(Value.kOff);
        booper.set(Value.kOff);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeCommand());
    }

    // *********************************************
    // Speed controller methods
    // *********************************************
    public void setRotateRawSpeed(double speed) {
        if (speed > 1) {
            speed = 1;
        } else if (speed < -1) {
            speed = -1;
        }
        rotate.set(ControlMode.PercentOutput, speed);
    }

    public double getRotateRawSpeed() {
        return rotate.getSelectedSensorPosition(0);
    }

    public void setRollersRawSpeed(double speed) {
        if (speed > 1) {
            speed = 1;
        } else if (speed < -1) {
            speed = -1;
        }
        rotate.set(ControlMode.PercentOutput, speed);
    }

    public double getRollersRawSpeed() {
        return rollers.getSelectedSensorVelocity(0);
    }

    // *********************************************
    // Encoder methods
    // *********************************************
    public void setRotateEncoderCountersPerInch(double countsPerInch) {
        rotateEncoder.setDistancePerPulse(countsPerInch);
    }

    public int getRotateEncoderPosition() {
        return rotateEncoder.get();
    }

    public double getRotateEncoderDistance() {
        return rotateEncoder.getDistance();
    }

    // *********************************************
    // Solenoid methods
    // *********************************************
    public void setKachunker(Value value) {
        kachunker.set(value);
    }

    public void setBooper(Value value) {
        booper.set(value);
    }
}