package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeSubsystem;

public class SetIntakeRotateCommand extends Command {

    private IntakeSubsystem c_intake;

    private int desiredEncoderPos;
    private double rawSpeed;

    private boolean goingUp;
    private boolean isDone;


    public SetIntakeRotateCommand(int desiredEncoderPos, double rawSpeed) {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
        this.desiredEncoderPos = desiredEncoderPos;
        this.rawSpeed = rawSpeed;
    }


    @Override
    protected void initialize() {
        if(c_intake.getRotateEncoderPosition() < desiredEncoderPos){
            isDone = false;
            goingUp = false;

            c_intake.setRotateRawSpeed(rawSpeed);
        } else
        if(c_intake.getRotateEncoderPosition() > desiredEncoderPos){
            isDone = false;
            goingUp = true;

            c_intake.setRotateRawSpeed(-rawSpeed);
        } else {
            isDone = true;
        }
    }

    @Override
    protected void execute() {
        int actual = c_intake.getRotateEncoderPosition();
        if(goingUp){
            if(actual < desiredEncoderPos){
                isDone = true;
            }
        } else {
            if(actual > desiredEncoderPos){
                isDone = true;
            }
        }
    }

    @Override
    protected void end() {
        c_intake.setRotateRawSpeed(0);
    }

    
    @Override
    protected boolean isFinished() {
        return isDone;
    }
}