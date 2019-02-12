package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeElbowCommand;
import frc.robot.constants.RobotMap;

public class IntakeElbowSubsystem extends Subsystem {

    private TalonSRX tilt = new TalonSRX(RobotMap.INTAKE_MOTOR_TILT_ADDRESS);

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
    // Fixed functions
    //**********************************************************************************
}