package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotConst;
import frc.robot.oi.OI;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends Command {
    private DriveSubsystem c_drive = Robot.getDriveSubsystem();

    public DefaultDriveCommand() {
        requires(c_drive);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        double throttle = OI.getDriverThrottle();
        double turn = OI.getDriverTurn();

        double leftSpeed = 0;
        double rightSpeed = 0;

        if (Math.abs(throttle) < RobotConst.DRIVE_THORTTLE_TRIGGER_VALUE) {
            throttle = 0;
        }

        if (Math.abs(turn) < RobotConst.DRIVE_TURN_TRIGGER_VALUE) {
            turn = 0;
        }

        leftSpeed = throttle - turn;
        rightSpeed = throttle + turn;
        
        c_drive.setRawSpeeds(leftSpeed, -rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}