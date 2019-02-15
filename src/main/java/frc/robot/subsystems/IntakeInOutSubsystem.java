package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeInOutCommand;
import frc.robot.constants.GamePiece;
import frc.robot.constants.RobotMap;
import frc.robot.oi.OI;

public class IntakeInOutSubsystem extends Subsystem {

    private TalonSRX intake = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);
    private boolean activated = false;
    private GamePiece currentGamePiece;

    public IntakeInOutSubsystem() {
        intake.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        currentGamePiece = GamePiece.NONE;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeInOutCommand());
    }

    /**
     * Will turn intake inward motors
     */
    public void in(boolean activate) { //TODO untested
        this.activated = activate;
        while(activated) {
            this.setVelocity(0.5);
            OI.driverRumble(true);
        }
        OI.driverRumble(false);
    }

    /**
     * Will turn intake motors
     */
    public void out(boolean activate) { //TODO don't think this will work
        this.activated = activate;
        while(activated) {
            this.setVelocity(-0.5);
            OI.driverRumble(true);
        }
        OI.driverRumble(false);
    }

    /**
     * Will return the encoder position (0 on a primary closed loop pid index)
     * @return
     * Encoder Position - 
     */
    public int getEncoderPosition() {
        return intake.getSelectedSensorPosition(0);
    }

    public void setEncoderPosition(int position) {
        intake.setSelectedSensorPosition(position);
    }

    public void setVelocity(double velocity) {
        intake.set(ControlMode.Velocity, velocity);
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