package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeInOutCommand;
import frc.robot.constants.RobotMap;

public class IntakeInOutSubsystem extends Subsystem {

    private TalonSRX intake = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);
    private boolean activated = false;

    public IntakeInOutSubsystem() {
        intake.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeInOutCommand());
    }

    /**
     * Will turn intake motors
     */
    public void activate(boolean activate) { //TODO don't think this will work
        this.activated = activate;
        while(activated) {
            this.setEncoderPosition(this.getEncoderPosition() + 1);
        }
    }

    /**
     * Will return state of motors
     * If motors are on, returns true
     */
    public boolean getActivated() {
        return this.activated;
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
}