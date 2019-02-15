package frc.robot.subsystems;

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
            this.setEncoderPosition(this.getEncoderPosition() + 1);
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
            this.setEncoderPosition(this.getEncoderPosition() - 1);
            OI.driverRumble(true);
        }
        OI.driverRumble(false);
    }

    /**
     * Will return the encoder position (0 on a primary closed loop)
     * @return
     * Encoder Position - 
     */
    public int getEncoderPosition() {
        return intake.getSelectedSensorPosition(0);
    }

    /**
     * Will set the encoder position. Parameter value (# to #)
     * @param position
     * Encoder position value from # - # --> TBD
     */
    public void setEncoderPosition(int position) {
        intake.setSelectedSensorPosition(position);
    }

    /**
     * Returns the current game piece.
     * @return currentGamePiece
     */
    public GamePiece getCurrentGamePiece() {
        return currentGamePiece;
    }
}