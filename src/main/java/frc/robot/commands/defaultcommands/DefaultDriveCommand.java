package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotConst;
import frc.robot.oi.OI;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends Command {
    private DriveSubsystem c_drive = Robot.getDriveSubsystem();
    private double leftSpeed, rightSpeed;

    

    public DefaultDriveCommand() {
        requires(c_drive);
        leftSpeed = 0;
        rightSpeed = 0;
    }

    @Override
    protected void execute() {
        //driver input
        double turn = OI.getDriverTurn();
        double throttle = OI.getDriverThrottle();

        //misc values
        double slowDownSpeed = 0.5;
        boolean stopped = false;

        //trigger for throttle
        if(Math.abs(throttle) < RobotConst.DRIVE_THORTTLE_TRIGGER_VALUE){
            throttle = 0;
        } else {
            throttle = OI.getDriverThrottle();
        }
        
        //trigger for turning
        if(Math.abs(turn) < RobotConst.DRIVE_TURN_TRIGGER_VALUE){
            turn = 0;
        } else {
            turn = OI.getDriverTurn();
        }

        //set speeds
        // if (stopped == true) {
        //     leftSpeed *= slowDownSpeed;
        //     rightSpeed *= slowDownSpeed;
        // } else {
            leftSpeed = throttle - turn;
            rightSpeed = throttle + turn;
        // }

        //max limit
        if(leftSpeed > 1){
            leftSpeed = 1;
        }

        //min limit
        if(leftSpeed < -1){
            leftSpeed = -1;
        }

        //max limit
        if(rightSpeed > 1) {
            rightSpeed = 1;
        }

        //min limit
        if (rightSpeed < -1) {
            rightSpeed = -1;
        }
        
        c_drive.setRawSpeeds(leftSpeed, -rightSpeed);

        if (OI.getDriverTestButton()) {
            c_drive.shift.set(Value.kForward);
        } else {
            c_drive.shift.set(Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        c_drive.setRawSpeeds(0, 0);
    }
}