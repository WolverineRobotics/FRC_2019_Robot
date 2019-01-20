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
        c_drive.setRawSpeeds(OI.getLeftSpeed(), OI.getRightSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    
}