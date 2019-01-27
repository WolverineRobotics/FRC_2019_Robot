package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;

public class defaultDriveCommand extends Command {
    private DriveSubsystem c_drive = Robot.getDriveSubsystem();

    public defaultDriveCommand() {
        requires(c_drive);
    }

    @Override
    protected void execute() {
        //driver input
        double turn = OI.getTurn();
        double throttle = OI.getThrottle();

        //percentage stick pushed until changes start
        double turnTriggerValue = 0.2;
        double throttleTriggerValue = 0.1;

        //misc values
        double leftSpeed = 0;
        double rightSpeed = 0;
        double slowDownSpeed = 0.5;
        boolean stopped = false;

        //trigger for throttle
        if(Math.abs(throttle) < throttleTriggerValue){
            throttle = 0;
            stopped = true;
        } else {
            throttle = OI.getThrottle();
            stopped = false;
        }
        
        //trigger for turning
        if(Math.abs(turn) < turnTriggerValue){
            turn = 0;
            stopped = true;
        } else {
            turn = OI.getTurn();
            stopped = false;
        }

        //set speeds
        leftSpeed = throttle + turn;
        rightSpeed = throttle - turn;

        //max limit
        if(leftSpeed > 1){
            leftSpeed = 1;
        }

        //min limit
        if(leftSpeed < -1){
            leftSpeed = -1;
        }

        //Slow to stop
        if(stopped){
            leftSpeed *= slowDownSpeed;
            rightSpeed *= slowDownSpeed;
        }

        //setSpeeds
        c_drive.setRawSpeeds(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    
}