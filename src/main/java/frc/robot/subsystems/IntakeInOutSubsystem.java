package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeInOutCommand;
import frc.robot.constants.GamePiece;
import frc.robot.constants.RobotMap;
import frc.robot.oi.OI;

public class IntakeInOutSubsystem extends Subsystem {

    private TalonSRX cargoIntake = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);
    //private Sensor hatchSensor
    //private Sensor cargoSensor

    private DoubleSolenoid hatchClaw = new DoubleSolenoid(RobotMap.INTAKE_PISTON_CLAW_FORWARD_ADDRESS, RobotMap.INTAKE_PISTON_CLAW_REVERSE_ADDRESS);
    private DoubleSolenoid hatchKachunker = new DoubleSolenoid(RobotMap.INTAKE_PISTON_KACHUNKER_FORWARD_ADDRESS, RobotMap.INTAKE_PISTON_KACHUNKER_REVERSE_ADDRESS);

    private boolean activated = false;
    private GamePiece currentGamePiece;

    public IntakeInOutSubsystem() {
        cargoIntake.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        hatchClaw.set(Value.kOff);
        hatchKachunker.set(Value.kOff);
        currentGamePiece = GamePiece.NONE;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeInOutCommand());
    }

    /**
     * Will turn intake inward motors
     */
    public void cargoIntakeIn(boolean activate) { //TODO untested
        this.activated = activate;
        while(activated) {
            this.setCargoIntakeRawSpeed(0.5);
            OI.driverRumble(true);
        }
        OI.driverRumble(false);
    }

    /**
     * Will turn intake motors
     */
    public void cargoIntakeOut(boolean activate) { //TODO don't think this will work
        this.activated = activate;
        while(activated) {
            this.setCargoIntakeRawSpeed(-0.5);
            OI.driverRumble(true);
        }
        OI.driverRumble(false);
    }

    /**
     * Will return the encoder position (0 on a primary closed loop pid index)
     * @return
     * Encoder Position - 
     */
    public int getCargoIntakeEncoderPosition() {
        return cargoIntake.getSelectedSensorPosition(0);
    }

    /**
     * Set the encoder position
     * @param position Encoder position
     */
    public void setCargoIntakeEncoderPosition(int position) {
        cargoIntake.setSelectedSensorPosition(position);
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
        cargoIntake.set(ControlMode.PercentOutput, percent);
    }

    /**
     * Closes the hatch intake claw
     */
    public void clawClose() {
        hatchClaw.set(Value.kForward);
    }

    /**
     * Opens the hatch intake claw
     */
    public void clawOpen() {
        hatchClaw.set(Value.kReverse);
    }

    /**
     * Push solenoid out
     */
    public void kachunk() {
        hatchKachunker.set(Value.kForward);
    }

    /**
     * Push solenoid in
     */
    public void kachink() {
        hatchKachunker.set(Value.kReverse);
    }

    /**
     * Returns the current game piece through sensors
     * @return currentGamePiece
     */
    public GamePiece getCurrentGamePiece() {
        //TODO enter sensor functions here
        /**
         * Pseudo code:
         * if(HATCH sensor detects something) {
         *  currentGamePiece = GamePiece.HATCH;
         * } else if(CARGO sensor detects something) {
         *  currentGamePiece = GamePiece.CARGO;
         * } else {
         *  currentGamePiece = GamePiece.NONE;
         * }
         */
        return currentGamePiece;
    }
}