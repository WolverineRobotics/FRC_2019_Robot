package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeCommand;
import frc.robot.constants.RobotMap;

public class IntakeSubsystem extends Subsystem {

    private TalonSRX rotate = new TalonSRX(RobotMap.INTAKE_MOTOR_TILT_ADDRESS);
    private TalonSRX rollers = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);

    private DoubleSolenoid kachunker = new DoubleSolenoid(RobotMap.INTAKE_PISTON_KACHUNKER_PCM_MODULE_ADDRESS, 
        RobotMap.INTAKE_PISTON_KACHUNKER_FORWARD_ADDRESS, 
        RobotMap.INTAKE_PISTON_CLAW_REVERSE_ADDRESS);

    private DoubleSolenoid booper = new DoubleSolenoid(RobotMap.INTAKE_PISTON_BOOPER_PCM_MODULE_ADDRESS,
    RobotMap.INTAKE_PISTON_BOOPER_FORWARD_ADDRESS, 
    RobotMap.INTAKE_PISTON_BOOPER_REVERSE_ADDRESS);

    public IntakeSubsystem() {

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeCommand());
    }

    //*********************************************
    // Speed controller methods
    //*********************************************
    public void setRotateRawSpeed(double speed) {
        if(speed > 1) {
            speed = 1;
        } else if(speed < -1) {
            speed = -1;
        }
        rotate.set(ControlMode.PercentOutput, speed);
    }

    public double getRotateRawSpeed() {
        return rotate.getSelectedSensorPosition(0);
    }

    public void setRollersRawSpeed(double speed) {
        if(speed > 1) {
            speed = 1;
        } else if(speed < -1) {
            speed = -1;
        }
        rotate.set(ControlMode.PercentOutput, speed);
    }

    public double getRollersRawSpeed() {
        return rollers.getSelectedSensorVelocity(0);
    }
    //*********************************************
    // Encoder methods
    //*********************************************
    public void setRotateEncoderPosition(int position) {
        rotate.setSelectedSensorPosition(position, 0, 0);
    } 

    public int getRotateEncoderPosition() {
        return rotate.getSelectedSensorPosition(0);
    }

}