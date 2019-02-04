package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotPIDValues;
import frc.robot.oi.OI;
import frc.robot.subsystems.DriveSubsystem;
import frc.util.PID;

public class defaultDriveCommand extends Command {
    private DriveSubsystem c_drive = Robot.getDriveSubsystem();
    private PID gyroPid =
        new PID(RobotPIDValues.GYRO_KP,
                RobotPIDValues.GYRO_KI,
                RobotPIDValues.GYRO_KD, 0);

    public defaultDriveCommand() {
        requires(c_drive);
    }

    @Override
    protected void initialize() {
        gyroPid.setMaxOutput(1);
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
        double heading;
        double currentHeading = Robot.getDriveSubsystem().getGyroAngle();
        double steering = gyroPid.calcPID(currentHeading);

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
            heading = c_drive.getGyroAngle();
            gyroPid.setDesiredValue(heading);
            stopped = false;
        }

        //set speeds
        leftSpeed = throttle + turn;
        rightSpeed = throttle - turn;

        //max limit
        if (leftSpeed > 1) {
            leftSpeed = 1;
        }
        
        if (rightSpeed > 1) {
            rightSpeed = 1;
        }

        //min limit
        if (leftSpeed < -1) {
            leftSpeed = -1;
        }
        
        if (leftSpeed < -1) {
            leftSpeed = -1;
        }

        //Slow to stop
        if (stopped) {
            leftSpeed *= slowDownSpeed;
            rightSpeed *= slowDownSpeed;
        }
        
        //steering correction
        if(steering < 0){
            rightSpeed *= 1 - rightSpeed;
        }

        if(steering > 0){
            leftSpeed *= 1 - leftSpeed;
        }
        
        //move robot
        c_drive.setRawSpeeds(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}