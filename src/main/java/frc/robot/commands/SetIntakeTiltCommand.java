package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotPIDValues;
import frc.robot.subsystems.IntakeElbowSubsystem;
import frc.util.PID;

public class SetIntakeTiltCommand extends Command{
    

    private IntakeElbowSubsystem c_intakeElbow = Robot.getIntakeElbowSubsystem();

    private boolean isDone;
    private int encoderPos;
    private PID pid;

    public SetIntakeTiltCommand(int encoderPos){

        requires(c_intakeElbow);
        this.encoderPos = encoderPos;
        this.pid = new PID(RobotPIDValues.INTAKE_TILT_POSITION_KP, RobotPIDValues.INTAKE_TILT_POSITION_KI, RobotPIDValues.INTAKE_TILT_POSITION_KD, 0);

    }

    @Override
    public boolean isFinished(){
        return isDone;
    }

    @Override
    public void execute(){
        c_intakeElbow.setEncoderPosition(encoderPos);
        if(c_intakeElbow.getEncoderPosition() == encoderPos){ //USE PID HERe
            
        }
    }
}