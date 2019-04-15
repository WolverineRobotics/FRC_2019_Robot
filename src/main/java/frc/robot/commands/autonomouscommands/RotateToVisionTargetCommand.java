package frc.robot.commands.autonomouscommands;

import frc.robot.Robot;

/**
 * Only to run with vision targets found.
 */
public class RotateToVisionTargetCommand extends RotateToHeadingCommand {

    public RotateToVisionTargetCommand() {
        super(Robot.getDriveSubsystem().getPigeonHeading() - Robot.m_camera.getDegreesOff());
        Robot.camera.setExposureManual(20);
    }

    @Override
    protected boolean isFinished() {
        return super.isFinished();
    }

    @Override
    protected void end() {
        Robot.camera.setExposureManual(80);
    }

}