package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeElbowCommand;
import frc.robot.constants.RobotMap;

public class IntakeElbowSubsystem extends Subsystem {

    private TalonSRX tilt = new TalonSRX(RobotMap.INTAKE_MOTOR_TILT_ADDRESS);

    public IntakeElbowSubsystem() {
        tilt.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeElbowCommand());
    }
    
    //********************************************************************************** 
    // Encoder functions
    //**********************************************************************************
    public int getEncoderPosition(){
        return tilt.getSelectedSensorPosition(0);
    }

    public void setEncoderPosition(int position) {
        tilt.setSelectedSensorPosition(position);
    }

    //********************************************************************************** 
    // Speed controller functions
    //**********************************************************************************
    public void setRawSpeed(double percent) {
        if(percent > 1) {
            percent = 1;
        }
        if(percent < -1) {
            percent = -1;
        }
        tilt.set(ControlMode.PercentOutput, percent);
    }
}