package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.pid.GyroPID;
import frc.robot.subsystems.DriveSubsystem;

public class RotateToHeadingCommand extends Command {
    private DriveSubsystem c_drive;
    private GyroPID gyropid;
    private double heading;


    public RotateToHeadingCommand(double heading){
        c_drive = Robot.getDriveSubsystem();
        requires(c_drive);

        gyropid = c_drive.gyroPID;
        this.heading = heading;
    }

    @Override
    protected void initialize() {
        gyropid.reset();
        gyropid.setSetpoint(heading);
        gyropid.enable();
        System.out.println("Rotating to " + heading + " from " + c_drive.getPigeonHeading());
    }

    @Override
    protected void execute() {
        double steering = gyropid.calculate(c_drive.getPigeonHeading());
        if(steering >= 0.3){
            steering = 0.3;
        } else if(steering <= -0.3){
            steering = -0.3;
        }
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
        return (Math.abs(gyropid.getError()) < 2);
        // return (Math.abs(gyropid.getError()) < 12) && (c_drive.getRate() <= 5);
        // return false;
    }
}