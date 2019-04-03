package frc.robot.commands.autonomouscommands;

import frc.robot.subsystems.CameraSubsystem;

/**
 * Drives toward a vision target.
 * Command will finish after certain amount of seconds.
 */

public class DriveTowardsVisionTargetCommand extends DriveDirectionCommand {
    private CameraSubsystem camera;

    public DriveTowardsVisionTargetCommand(double timeoutSeconds){
        super(0.2, 0);
        setTimeout(timeoutSeconds);
        setHeading(c_drive.getPigeonHeading() - camera.getDegreesOff());
    }

    @Override
    protected void execute() {
        setHeading(c_drive.getPigeonHeading() - camera.getDegreesOff());
        super.execute();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
    
}