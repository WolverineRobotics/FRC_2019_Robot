package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends Command {
    
    private DriveSubsystem c_drive;

    public DefaultDriveCommand() {
        c_drive = Robot.getDriveSubsystem();
        requires(c_drive);
    }

    @Override
    protected void execute() {
        double throttle = OI.getDriverThrottle();
        double turn = OI.getDriverTurn();

        double leftSpeed = 0;
        double rightSpeed = 0;

        // Redundant code, now done in OI.
/*         if (Math.abs(throttle) < RobotConst.DRIVE_THORTTLE_TRIGGER_VALUE) {
            throttle = 0;
        }

        if (Math.abs(turn) < RobotConst.DRIVE_TURN_TRIGGER_VALUE) {
            turn = 0;
        } */

        leftSpeed = throttle - turn;
        rightSpeed = throttle + turn;

        
        if(OI.getFineControl()){
            //If fine control is active.
            c_drive.setRawSpeeds(leftSpeed*0.3, -rightSpeed*0.3);
        }else{
            c_drive.setRawSpeeds(leftSpeed*0.7, -rightSpeed*0.7);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}