package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;
import frc.util.PID;

public class RotateToHeadingCommand extends Command {
    private DriveSubsystem c_drive;
    private PID gyropid;


    public RotateToHeadingCommand(double heading){
        c_drive = Robot.getDriveSubsystem();
        requires(c_drive);
        gyropid = c_drive.gyroPID;
        gyropid.setDesiredValue(heading);
        gyropid.resetErrorSum();
        System.out.println("Rotating to " + heading);
    }

    @Override
    protected void execute() {
        double steering = gyropid.calcPID(c_drive.getPigeonHeading());

        c_drive.setRawLeftSpeed(steering);
        c_drive.setRawRightSpeed(steering);
    }

    @Override
    protected void end() {
        System.out.println("finished at " + c_drive.getPigeonHeading());
    }

    @Override
    protected boolean isFinished() {
        return gyropid.isDone();
    }
    
}