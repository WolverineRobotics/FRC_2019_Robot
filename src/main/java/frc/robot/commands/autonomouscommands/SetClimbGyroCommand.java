package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbSubsystem;
import frc.util.Util;
import frc.robot.oi.OI;

public class SetClimbGyroCommand extends Command{

    private ClimbSubsystem c_climb;
    private boolean isDone;

    //If -1, then disabled
    private int desiredEncoderPos;

    private boolean goingUp;
    private int currentEncoderPos;

    private double maxSpeed;
    private double targetGyroValue;
    private double currentGyroValue;
    private double maxAllowedError;
    private double motorPower;

    private boolean allowManualOverride;

    private boolean secondStage;


    public SetClimbGyroCommand(double maxSpeed, double targetGyroValue, boolean allowManualOverride){
        c_climb = Robot.getClimbSubsystem();
        requires(c_climb);
        this.desiredEncoderPos = -1;
        this.maxSpeed = maxSpeed;
        this.targetGyroValue = targetGyroValue;

        currentEncoderPos = c_climb.getLiftEncoderPosition();


/*         if(currentEncoderPos < desiredEncoderPos) { //
            goingUp = false;
            c_climb.setLiftRawSpeed(-this.rawSpeed); 
        } else if(currentEncoderPos > desiredEncoderPos){
            goingUp = true;
            c_climb.setLiftRawSpeed(this.rawSpeed);
        } else {
            isDone = true;
        } */

        this.allowManualOverride = allowManualOverride;

        //If true, allows driver to press A button to set targetGyro to 0
        this.secondStage = true;
    }


    public SetClimbGyroCommand(double maxSpeed, double targetGyroValue, boolean allowManualOverride, int desiredEncoderPos){
        this(maxSpeed, targetGyroValue, allowManualOverride);
        this.desiredEncoderPos = desiredEncoderPos;
    }


    @Override
    protected boolean isFinished() {
        return isDone;
    }

    @Override
    protected void initialize() {

/*         if(goingUp){
            if(currentEncoderPos < desiredEncoderPos){
                isDone = true;
            }
        } else {
            if(currentEncoderPos > desiredEncoderPos){
                isDone = true;
            }
        } */
    }

    @Override
    protected void execute() {
        int actual = c_climb.getLiftEncoderPosition();

        if(desiredEncoderPos != -1){
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



        //TODO: Check if positive gyro tilt means the robot is tilting forward
        //This code is written assuming that it is
        //https://www.desmos.com/calculator/r9nw1x6she
        if(currentGyroValue < targetGyroValue){ 
            //Robot is not tilted enough, decrease climb power (right side of desmos graph)
            if(Math.abs(currentGyroValue-targetGyroValue) < maxAllowedError){
                motorPower = (((-maxSpeed/2)/Math.pow(maxAllowedError,2))*Math.pow((currentGyroValue-targetGyroValue),2)+ (maxSpeed/2));
            }else{
                motorPower = 0;
            }
        }else{
            //Robot is tilted too much, increase climb power (left side of desmos graph)
            if(Math.abs(currentGyroValue-targetGyroValue) < maxAllowedError){
                motorPower = (((maxSpeed/2)/Math.pow(maxAllowedError,2))*Math.pow((currentGyroValue-targetGyroValue),2) + (maxSpeed/2));
            }else{
                motorPower = maxSpeed;
            }
        }


        if(allowManualOverride){
            double speedUp = OI.getDriverClimbSpeedUp();
            double speedDown = OI.getDriverClimbSpeedDown();
            double speed = speedUp - speedDown;

            //Allows for manual override if there is controller input.
            if(speed != 0){
                motorPower = speed;
            }
        }

        //TODO: Check if negative power means going down
        c_climb.setLiftRawSpeed(-motorPower);


        double throttle = OI.getDriverThrottle();
        c_climb.setWheelRawSpeed(-throttle * 0.6);  //TODO: Set intake wheel speed


        //Allows the driver to cancel this commands
        if(OI.getCancelDriverCommand()){
            isDone = true;
        }

        //When button pressed, set, add self to scheduler with angle 0 and isDone = true
        //A Button
        if(secondStage){
             if(OI.getDriverRequestCargoLED()){
                 Util.addCommand(new SetClimbGyroCommand(this.maxSpeed, 0, this.allowManualOverride));
                 this.isDone = true;
            }  
        }
    }

    @Override
    protected void end() {
        //Stops climb motor once command is done
        c_climb.setLiftRawSpeed(0);
    }
    
    
}