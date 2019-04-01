package frc.robot.commands.autonomouscommands;

import frc.robot.subsystems.CameraSubsystem;

/**
 * DriveTowardsVisionTargetCommand
 */
public class DriveTowardsVisionTargetCommand extends DriveDirectionCommand {
    CameraSubsystem camera;

    public DriveTowardsVisionTargetCommand(){
        super(0.2, 0);
        setHeading(c_drive.getPigeonHeading() - camera.getDegreesOff());
    }

    @Override
    protected void execute() {
        setHeading(c_drive.getPigeonHeading() - camera.getDegreesOff());
        super.execute();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    
}