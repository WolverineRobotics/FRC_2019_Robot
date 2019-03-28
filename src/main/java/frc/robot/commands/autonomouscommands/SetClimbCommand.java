package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.oi.OI;

public class SetClimbCommand extends Command{

    private ClimbSubsystem c_climb;
    private boolean isDone;
    private int desiredEncoderPos;
    private boolean goingUp;
    private int currentEncoderPos;
    private double rawSpeed;

    private boolean allowManualOverride;


    public SetClimbCommand(final int desiredEncoderPos, double rawSpeed){
        c_climb = Robot.getClimbSubsystem();
        requires(c_climb);
        this.desiredEncoderPos = desiredEncoderPos;
        this.rawSpeed = rawSpeed;

        currentEncoderPos = c_climb.getLiftEncoderPosition();


        if(currentEncoderPos < desiredEncoderPos) { //
            goingUp = false;
            c_climb.setLiftRawSpeed(-this.rawSpeed); 
        } else if(currentEncoderPos > desiredEncoderPos){
            goingUp = true;
            c_climb.setLiftRawSpeed(this.rawSpeed);
        } else {
            isDone = true;
        }

        this.allowManualOverride = false;
    }

    //Second constructor to allow manual override of climb motor. Calls the first constructor, then sets the corret allowManualOverride value.
    public SetClimbCommand(final int desiredEncoderPos, double rawSpeed, boolean allowManualOverride ){
        this(desiredEncoderPos, rawSpeed);
        this.allowManualOverride = allowManualOverride;
    }

    //TODO: Add way to cancel command

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

        double speedUp = OI.getDriverClimbSpeedUp();
        double speedDown = OI.getDriverClimbSpeedDown();
        double speed = speedUp - speedDown;

        //Allows for manual override if there is controller input.
        if(speed != 0){
            c_climb.setLiftRawSpeed(speed);
        }

        double throttle = OI.getDriverThrottle();
        c_climb.setWheelRawSpeed(-throttle * 0.9);  //TODO: Set intake wheel speed

    }

    @Override
    protected void end() {
        //Stops climb motor once command is done
        c_climb.setLiftRawSpeed(0);
    }
    
    
}