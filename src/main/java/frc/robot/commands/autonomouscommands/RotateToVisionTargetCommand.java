package frc.robot.commands.autonomouscommands;

import frc.robot.Robot;

/**
 * Only to run with vision targets found.
 */
public class RotateToVisionTargetCommand extends RotateToHeadingCommand{

    public RotateToVisionTargetCommand() {
        super(Robot.getDriveSubsystem().getPigeonHeading() - Robot.m_camera.getDegreesOff());
    }

    @Override
    protected boolean isFinished() {
        return super.isFinished();
    }

}