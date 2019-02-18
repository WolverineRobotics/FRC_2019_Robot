package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeCommand;
import frc.robot.constants.GamePiece;
import frc.robot.constants.RobotMap;

public class IntakeSubsystem extends Subsystem {

    private TalonSRX intake = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);
    private TalonSRX rotate = new TalonSRX(RobotMap.INTAKE_MOTOR_TILT_ADDRESS);

    private DigitalInput cargoLimitSwitch = new DigitalInput(RobotMap.INTAKE_CARGO_LIMIT_SWITCH_ADDRESS);
    private DigitalInput hatchTopLimitSwitch = new DigitalInput(RobotMap.INTAKE_HATCH_TOP_LIMIT_SWITCH_ADDRESS);
    private DigitalInput hatchBottomLimitSwitch = new DigitalInput(RobotMap.INTAKE_HATCH_BOTTOM_LIMIT_SWITCH_ADDRESS);
    private DigitalInput rotateLimitSwitch = new DigitalInput(RobotMap.INTAKE_ROTATE_LIMIT_SWITCH_ADDRESS);

    private DoubleSolenoid hatchClaw = new DoubleSolenoid(RobotMap.INTAKE_PISTON_CLAW_FORWARD_ADDRESS, RobotMap.INTAKE_PISTON_CLAW_REVERSE_ADDRESS);
    private DoubleSolenoid hatchKachunker = new DoubleSolenoid(RobotMap.INTAKE_PISTON_KACHUNKER_FORWARD_ADDRESS, RobotMap.INTAKE_PISTON_KACHUNKER_REVERSE_ADDRESS);

    private double intakeRawSpeed;
    private double rotateRawSpeed;

    public IntakeSubsystem() {
        intake.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        rotate.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        hatchClaw.set(Value.kOff);
        hatchKachunker.set(Value.kOff);

        
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeCommand());
    }
    
    /**
     * Returns the current game piece through sensors
     * @return currentGamePiece
     */
    public GamePiece getCurrentGamePiece() {
        GamePiece gp = GamePiece.NONE;
        if(cargoLimitSwitch.get()) {
            gp = GamePiece.HATCH;
        }
        
        if(hatchTopLimitSwitch.get() && hatchBottomLimitSwitch.get()) {
            gp = GamePiece.CARGO;
        }
        return gp;
    }

    //********************************************
    // Claw solenoid methods
    //********************************************

    //Closes hatch claw
    public void clawClose() {
        hatchClaw.set(Value.kForward);
    }

    
    //Opens the hatch intake claw 
    public void clawOpen() {
        hatchClaw.set(Value.kReverse);
    }

    //********************************************
    // Kachunker solenoid methods
    //********************************************

    //Push solenoid out
    public void kachunk() {
        if(hatchKachunker.get() != Value.kForward) hatchKachunker.set(Value.kForward);
    }

    //Pull solenoid in
    public void kachink() {
        if(hatchKachunker.get() != Value.kReverse) hatchKachunker.set(Value.kReverse);
    }

    public Value getKachunkerValue() {
        return hatchKachunker.get();
    }

    //********************************************
    // Sensor Limit switches
    //********************************************
    public boolean getCargoLimitSwitch() {
        return cargoLimitSwitch.get();
    }

    public boolean getHatchTopLimitSwitch() {
        return hatchTopLimitSwitch.get();
    }

    public boolean getHatchBottomLimitSwitch() {
        return hatchBottomLimitSwitch.get();
    }

    //********************************************
    // Encoder methods
    //********************************************
    public int getRotateRawEncoderPosition() {
        return rotate.getSelectedSensorPosition(0);
    }

    public void setRotateRawEncoderPosition(int position) {
        rotate.setSelectedSensorPosition(position);
    }

    //********************************************************************************** 
    // Speed controller functions
    //**********************************************************************************
    /**
     * Set rotate raw velocity
     * @param percent velocity -1 to 1
     */
    public void setRotateRawSpeed(double percent) {
        if(percent > 1) {
            percent = 1;
        }
        if(percent < -1) {
            percent = -1;
        }
        rotateRawSpeed = percent;
        rotate.set(ControlMode.PercentOutput, rotateRawSpeed);
    }

    public double getRotateRawSpeed() {
        return rotateRawSpeed;
    }

    
    /**
     * Set the ball intake velocity
     * @param velocity velocity -1 to 1.
     */
    public void setCargoIntakeRawSpeed(double percent) {
        if(percent > 1) {
            percent = 1;
        }
        if(percent < -1) {
            percent = -1;
        }
        intakeRawSpeed = percent;
        intake.set(ControlMode.PercentOutput, intakeRawSpeed);
    }

    public double getIntakeRawSpeed() {
        return intakeRawSpeed;
    }

}