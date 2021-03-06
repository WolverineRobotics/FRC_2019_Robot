package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeSubsystem;
import frc.util.Util;

public class SetIntakeRotateGyroCommand extends Command {

    private IntakeSubsystem c_intake;

    //Set desiredEncoderPos to 1 to disable
    private int desiredEncoderPos;
    private double maxSpeed;
    private double targetGyroValue;
    private double currentGyroValue;
    private double maxAllowedError;
    private double motorPower;

    private boolean goingUp; //Currently not implemented, likely not needed
    private boolean isDone;
    private boolean allowManualOverride;
    private boolean secondStage;


    public SetIntakeRotateGyroCommand(double maxSpeed, double targetGyroValue, boolean allowManualOverride) {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
        this.maxAllowedError = 4; //May need tweaking, see desmos graph

        this.maxSpeed = maxSpeed;
        this.targetGyroValue = targetGyroValue;
        this.allowManualOverride = allowManualOverride;
        this.desiredEncoderPos = 1;
        this.goingUp = true;

        
        //If true, allows driver to press A button to set targetGyro to 0        
        this.secondStage = true;
        
    }

/*     public SetIntakeRotateGyroCommand(double maxSpeed, double targetGyroValue, boolean allowManualOverride, int desiredEncoderPos){
        this(maxSpeed, targetGyroValue, allowManualOverride);
        this.desiredEncoderPos = desiredEncoderPos;
    } */


    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        // int actual = c_intake.getRotateEncoderPosition();
        currentGyroValue = c_intake.getGyroTilt();

/*         if(desiredEncoderPos != 1){
            if(goingUp){
                if(actual < desiredEncoderPos){
                    isDone = true;
                }
            } else {
                if(actual > desiredEncoderPos){
                    isDone = true;
                }
            }
        }  */

        //TODO: Check if positive gyro tilt means the robot is tilting forward
        //This code is written assuming that it is
        //May need to invert currentGyroValue otherwise
        //https://www.desmos.com/calculator/ppobiqd4pp
        if(currentGyroValue > targetGyroValue){ 
            //Robot is not tilted enough, increase tilt (right side of desmos graph)
            if(Math.abs(currentGyroValue-targetGyroValue) < maxAllowedError){
                motorPower = (((maxSpeed/2)/Math.pow(maxAllowedError,2))*Math.pow((currentGyroValue-targetGyroValue),2)+ (maxSpeed/2));
            }else{
                motorPower = maxSpeed;
            }
        } else {
            //Robot is tilted too much, decrease tilt (left side of desmos graph)
            if(Math.abs(currentGyroValue-targetGyroValue) < maxAllowedError){
                motorPower = (((-maxSpeed/2)/Math.pow(maxAllowedError,2))*Math.pow((currentGyroValue-targetGyroValue),2) + (maxSpeed/2));
            }else{
                motorPower = 0;
            }
        }
         
        //Manual Override
        if(allowManualOverride){
            double rotateSpeed = OI.getOperatorIntakeRotate();
            if(rotateSpeed != 0){
                motorPower = (rotateSpeed*maxSpeed);
            }
        }

        //Ensures it is between 0 and 1
        motorPower = Util.getMotorLimits(motorPower);

        //Actually sets the speed
        c_intake.setRotateRawSpeed(motorPower);

        //When button pressed, set isDone = true, operator takes over
        //A Button
        if(secondStage){
            if(OI.getDriverRequestCargoLED()){
                this.isDone = true;
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