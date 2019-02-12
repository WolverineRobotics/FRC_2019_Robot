package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeInOutCommand;
import frc.robot.constants.RobotMap;

public class IntakeInOutSubsystem extends Subsystem {

    private TalonSRX intake = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);
    private boolean activated = false;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeInOutCommand());
    }

    public void activate(boolean activate) {
        this.activated = activate;
        while(activated) {
            intake.setSelectedSensorPosition(intake.getSelectedSensorPosition(0) + 1);
        }
    }

    public boolean getActivated() {
        return this.activated;
    }

    public int getEncoderPosition() {
        return intake.getSelectedSensorPosition(0);
    }
    public void setEncoderPosition(int position) {
        intake.setSelectedSensorPosition(position);
    }
}