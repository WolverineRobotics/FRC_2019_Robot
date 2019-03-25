package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbSubsystem;

public class SetClimbCommand extends Command{

    private ClimbSubsystem c_climb;
    private boolean isDone;
    private int desiredEncoderPos;
    private boolean goingUp;
    private int currentEncoderPos;


    public SetClimbCommand(final int desiredEncoderPos){
        c_climb = Robot.getClimbSubsystem();
        requires(c_climb);
        this.desiredEncoderPos = desiredEncoderPos;

        currentEncoderPos = c_climb.getLiftEncoderPosition();


        if(currentEncoderPos < desiredEncoderPos) { //
            goingUp = false;
            c_climb.setLiftRawSpeed(-0.5); //TODO: Set Lift Speed
        } else if(currentEncoderPos > desiredEncoderPos){
            goingUp = true;
            c_climb.setLiftRawSpeed(0.5);
        } else {
            isDone = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

    @Override
    protected void initialize() {

        if(goingUp){
            if(currentEncoderPos < desiredEncoderPos){
                isDone = true;
            }
        } else {
            if(currentEncoderPos > desiredEncoderPos){
                isDone = true;
            }
        }
    }

    @Override
    protected void execute() {
    }
    
}