package frc.robot.commands.drive;

import frc.robot.Robot;

public class driveDistanceCommand extends driveDirectionCommand {
    double distance;
    public driveDistanceCommand(double heading, double distance, double speed, double timeout){
        super(heading, speed, timeout);
        this.distance = distance;
    }

    @Override
    protected boolean isFinished() {
        double goal = (Robot.getDriveSubsystem().getPositionLeft() + Robot.getDriveSubsystem().getPositionLeft())/2;
        if (goal >= distance) {
			System.out.println("ending drive");
			return true;
		}

        return isTimedOut();
    }
}