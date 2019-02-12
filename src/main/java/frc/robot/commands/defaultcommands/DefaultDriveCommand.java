package frc.robot.commands.defaultcommands;

import java.io.BufferedReader;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends Command {
    private DriveSubsystem c_drive = Robot.getDriveSubsystem();

    public DefaultDriveCommand() {
        requires(c_drive);
    }

    @Override
    protected void execute() {
        //driver input
        double turn = OI.getDriverTurn();
        double throttle = OI.getDriverThrottle();

        //percentage stick pushed until changes start
        final double turnTriggerValue = 0.2;
        final double throttleTriggerValue = 0.1;

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
            throttle = OI.getDriverThrottle();
            stopped = false;
        }
        
        //trigger for turning
        if(Math.abs(turn) < turnTriggerValue){
            turn = 0;
            stopped = true;
        } else {
            turn = OI.getDriverTurn();
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
        c_drive.setRawSpeeds(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    
}