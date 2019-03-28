package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeCommand;
import frc.robot.constants.GamePiece;
import frc.robot.constants.RobotMap;

public class IntakeSubsystem extends Subsystem {

    private TalonSRX rotate;
    private TalonSRX rollers;

    private DoubleSolenoid shovel;
    private DoubleSolenoid claw;

    private boolean shovelToggle; //true = forward, false = reverse.
    private boolean clawToggle;

    private Encoder rotateEncoder;

    private DigitalInput ballSensor;


    public IntakeSubsystem() {
        rotate = new TalonSRX(RobotMap.INTAKE_MOTOR_ROTATE_ADDRESS);
        rollers = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);

        shovel = new DoubleSolenoid(RobotMap.INTAKE_PISTON_SHOVEL_PCM_MODULE_ADDRESS,
                RobotMap.INTAKE_PISTON_SHOVEL_FORWARD_ADDRESS, RobotMap.INTAKE_PISTON_SHOVEL_REVERSE_ADDRESS);

        claw = new DoubleSolenoid(RobotMap.INTAKE_PISTON_CLAW_PCM_MODULE_ADDRESS, RobotMap.INTAKE_CLAW_FORWARD_ADDRESS,
                RobotMap.INTAKE_CLAW_REVERSE_ADDRESS);

        shovelToggle = true; // forward on default (shovel closed)
        clawToggle = true; // forward on default (claw open)

        rotateEncoder = new Encoder(RobotMap.INTAKE_ROTATE_ENCODER_A, RobotMap.INTAKE_ROTATE_ENCODER_B);

        ballSensor = new DigitalInput(RobotMap.INTAKE_BALL_SENSOR_ADDRESS);

        shovel.set(Value.kOff);
        claw.set(Value.kOff);
        rotateEncoder.reset();
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
        rollers.set(ControlMode.PercentOutput, speed);
    }

    public double getRollersRawSpeed() {
        return rollers.getMotorOutputPercent();
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

    public void resetEncoders() {
        rotateEncoder.reset();
    }

    public boolean getUpperLimit(){
        return rotate.getSensorCollection().isFwdLimitSwitchClosed();
    }

    // *********************************************
    // Solenoid methods
    // *********************************************
    
    public void toggleShovel() {
        if (shovelToggle) {
            setShovel(false);
        } else {
            setShovel(true);
        }
    }

    public void executeShovel() {
        if (shovelToggle) {
            shovel.set(Value.kReverse);
        } else {
            shovel.set(Value.kForward);
        }
    }

    public boolean getShovelOpen() {
        return !shovelToggle;
    }

    public void setShovel(boolean toOpen) {
        shovelToggle = !toOpen;
    }

    public void toggleClaw() {
        if (clawToggle) {
            setClaw(false);
        } else {
            setClaw(true                                                                                                                                                                                                                                                                                                                        );
        }
    }

    public void executeClaw() {
        if (clawToggle) {
            claw.set(Value.kForward);
        } else {
            claw.set(Value.kReverse);
        }
    }

    public boolean getClawOpen() {
        return clawToggle;
    }

    public void setClaw(boolean toOpen) {
        clawToggle = toOpen;
    }

    // ***********************************************************
    // Sensor methods
    // ***********************************************************
    public GamePiece getGamePiece() {
        if (getBallDetected()) {
            return GamePiece.CARGO;
        } else {
            return GamePiece.HATCH;
        }
    }

    public boolean getBallDetected() {
        return !ballSensor.get();
    }


}