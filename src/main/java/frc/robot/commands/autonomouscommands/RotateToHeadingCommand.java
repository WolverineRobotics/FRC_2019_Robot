package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.pid.GyroPID;
import frc.robot.subsystems.DriveSubsystem;

public class RotateToHeadingCommand extends Command {
    private DriveSubsystem c_drive;
    private GyroPID gyropid;


    public RotateToHeadingCommand(double heading){
        c_drive = Robot.getDriveSubsystem();
        requires(c_drive);

        gyropid = c_drive.gyroPID;
        gyropid.reset();
        gyropid.setSetpoint(heading);
        gyropid.enable();
        System.out.println("Rotating to " + heading);
    }

    @Override
    protected void execute() {
        double steering = gyropid.calculate(c_drive.getPigeonHeading());
        System.out.println(steering);
        c_drive.setRawLeftSpeed(steering);
        c_drive.setRawRightSpeed(steering);
    }

    @Override
    protected void end() {
        System.out.println("finished at " + c_drive.getPigeonHeading());
        gyropid.disable();
    }

    @Override
    protected boolean isFinished() {
        return (Math.abs(gyropid.getError()) < 4);
        // return false;
    }
}