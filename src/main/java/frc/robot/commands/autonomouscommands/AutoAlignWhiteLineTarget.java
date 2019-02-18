package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;

public class AutoAlignWhiteLineTarget extends Command {
    private DriveSubsystem c_drive = Robot.getDriveSubsystem();
    
    public AutoAlignWhiteLineTarget(int timeout) {
        super(timeout);
    }
    
    @Override
    protected void execute() {
        if(isWhite()){
            c_drive.setRawSpeeds(0.5, 0.6);
        } else {
            c_drive.setRawSpeeds(0.6, 0.5);
        }
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }

    private boolean isWhite() {
        if (c_drive.getRed() >= 255 && c_drive.getGreen() >= 255 && c_drive.getBlue() >= 255) {
            return true;
        } else {
            return false;
        }
    }
}