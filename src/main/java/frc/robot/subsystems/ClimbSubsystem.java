package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;

public class ClimbSubsystem extends Subsystem{
    private CANSparkMax climbMotor = new CANSparkMax(RobotMap.CLIMB_MOTOR_LIFT_ADDRESS, MotorType.kBrushless);
    private CANSparkMax wheelMotor = new CANSparkMax(RobotMap.CLIMB_MOTOR_WHEEL_ADDRESS, MotorType.kBrushless);

    @Override
    protected void initDefaultCommand() {

    }

}