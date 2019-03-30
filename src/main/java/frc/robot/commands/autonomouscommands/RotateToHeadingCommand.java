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
        gyropid.setSetpoint(heading);
        gyropid.setEnabled(true);
        System.out.println("Rotating to " + heading);
    }

    @Override
    protected void execute() {
        double steering = gyropid.calculate(c_drive.getPigeonHeading());

        c_drive.setRawLeftSpeed(steering);
        c_drive.setRawRightSpeed(steering);
    }

    @Override
    protected void end() {
        gyropid.disable();
        System.out.println("finished at " + c_drive.getPigeonHeading());
    }

    @Override
    protected boolean isFinished() {
        return (Math.abs(gyropid.getError()) < 2);
    }
    
}