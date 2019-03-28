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

    private boolean shovelToggle;
    private boolean clawToggle;

    private Encoder rotateEncoder;

    private DigitalInput ballSensor;


    public IntakeSubsystem() {
        rotate = new TalonSRX(RobotMap.INTAKE_MOTOR_ROTATE_ADDRESS);
        rollers = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);

        shovel = new DoubleSolenoid(RobotMap.INTAKE_PISTON_SHOVEL_PCM_MODULE_ADDRESS,
                RobotMap.INTAKE_PISTON_SHOVEL_FORWARD_ADDRESS, RobotMap.INTAKE_PISTON_SHOVEL_REVERSE_ADDRESS);
        shovelToggle = true;

        claw = new DoubleSolenoid(RobotMap.INTAKE_PISTON_CLAW_PCM_MODULE_ADDRESS, RobotMap.INTAKE_CLAW_FORWARD_ADDRESS,
                RobotMap.INTAKE_CLAW_REVERSE_ADDRESS);
        clawToggle = false;

        rotateEncoder = new Encoder(RobotMap.INTAKE_ROTATE_ENCODER_A, RobotMap.INTAKE_ROTATE_ENCODER_B);

        ballSensor = new DigitalInput(RobotMap.INTAKE_BALL_SENSOR_ADDRESS);


        //rotate.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        //rollers.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
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

    /**
     * @param activated
     */
    public void toggleShovel() {
        if (shovelToggle) {
            shovelToggle = false;
        } else {
            shovelToggle = true;
        }
    }

    /**
     * @return if shovel pneumatic is active
     */
    public boolean getShovelActive() {
        Value value = shovel.get();
        if (value.equals(Value.kForward)) {
            return true;
        } else if (value.equals(Value.kReverse)) {
            return false;
        } else {
            return false;
        }
    }

    public void executeShovel() {
        if (shovelToggle) {
            shovel.set(Value.kReverse);
        } else {
            shovel.set(Value.kForward);
        }
    }

    /**
     * @param activated true - will push forward. false - will pull.
     */
    public void toggleClaw() {
        if (clawToggle) {
            clawToggle = false;
        } else {
            clawToggle = true;
        }
    }

    /**
     * @return if the claw is active
     */
    public boolean getClawActive() {
        Value val = claw.get();
        if (val.equals(Value.kForward)) {
            return true;
        } else if (val.equals(Value.kReverse)) {
            return false;
        } else {
            return false;
        }
    }

    public void executeClaw() {
        if (clawToggle) {
            claw.set(Value.kForward);
        } else {
            claw.set(Value.kReverse);
        }
    }

    public GamePiece getGamePiece() {
        if (ballDetected()) {
            return GamePiece.CARGO;
        } else {
            return GamePiece.HATCH;
        }
    }

    public boolean ballDetected() {
        return !ballSensor.get();
    }


}