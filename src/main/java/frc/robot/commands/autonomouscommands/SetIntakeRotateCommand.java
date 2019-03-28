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

    private boolean allowManualOverride;

    public SetIntakeRotateCommand(int desiredEncoderPos, double rawSpeed) {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
        this.desiredEncoderPos = desiredEncoderPos;
        this.rawSpeed = rawSpeed;
        this.allowManualOverride = false;
    }

    //Second constructor to allow manual override of intake rotate. Calls the first constructor, then sets the corret allowManualOverride value.
    public SetIntakeRotateCommand(int desiredEncoderPos, double rawSpeed, boolean allowManualOverride) {
        this(desiredEncoderPos, rawSpeed);
        this.allowManualOverride = allowManualOverride;
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

        //If manual override enabled, checks if there is any input
        if(allowManualOverride){
            
            double rotateSpeed = OI.getOperatorIntakeTilt();

            //If there is input, use inputed value instead of default
            if(rotateSpeed != 0){
                c_intake.setRotateRawSpeed(rotateSpeed*0.6);
            }

        }

        //Allows for the operator to cancel the intake rotate 
        if(OI.getCancelOperatorCommand()){
            isDone = true;
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