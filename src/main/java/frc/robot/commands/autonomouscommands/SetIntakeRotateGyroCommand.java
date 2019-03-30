package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeSubsystem;

public class SetIntakeRotateGyroCommand extends Command {

    private IntakeSubsystem c_intake;

    //Set desiredEncoderPos to -1 to disable
    private int desiredEncoderPos;
    private double speed;
    private double maxSpeed;
    private double targetGyroValue;
    private double currentGyroValue;

    private boolean goingUp;
    private boolean isDone;
    private boolean allowManualOverride;


    public SetIntakeRotateGyroCommand(double maxSpeed, double targetGyroValue, boolean allowManualOverride) {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
        this.maxSpeed = maxSpeed;
        this.targetGyroValue = targetGyroValue;
        this.allowManualOverride = allowManualOverride;
        this.desiredEncoderPos = -1;
        this.goingUp = true;
    }

    public SetIntakeRotateGyroCommand(double maxSpeed, double targetGyroValue, boolean allowManualOverride, int desiredEncoderPos){
        this(maxSpeed, targetGyroValue, allowManualOverride);
        this.desiredEncoderPos = desiredEncoderPos;
    }

    public SetIntakeRotateGyroCommand(double maxSpeed, double targetGyroValue, boolean allowManualOverride, int desiredEncoderPos, boolean goingUp){
        this(maxSpeed, targetGyroValue, allowManualOverride);
        this.desiredEncoderPos = desiredEncoderPos;
        this.goingUp = false;
    }



    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        int actual = c_intake.getRotateEncoderPosition();
        currentGyroValue = c_intake.getGyroTilt();

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
        if(currentGyroValue < targetGyroValue){ 
            //Robot is tilted too much back, slows down tilt

        }else if(currentGyroValue > targetGyroValue){
            //Robot is not tilted enough, increases tilt 

        }



            
        //Manual Override
        if(allowManualOverride){
            double rotateSpeed = OI.getOperatorIntakeTilt();
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