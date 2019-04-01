package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.pid.GyroPID;
import frc.robot.subsystems.DriveSubsystem;
import frc.util.PID;

public class DriveDirectionCommand extends Command {
    double power, heading, speed;

    boolean brakeWhenFinished;

    PID distancePID;
    GyroPID gyroPID;

    DriveSubsystem c_drive;

    public DriveDirectionCommand(double power, double heading, boolean brakeWhenFinished){
        this.power = power;
        this.heading = heading;
        this.brakeWhenFinished = brakeWhenFinished;
        this.speed = 0;

        c_drive = Robot.getDriveSubsystem();

        gyroPID = c_drive.gyroPID;
        gyroPID.setSetpoint(heading);
    }

    @Override
    protected void execute() {
        double leftSpeed, rightSpeed;
        double steering;
 
        steering = gyroPID.calculate(c_drive.getPigeonHeading());

        if(speed > Math.abs(power)){
            speed = power;
        }

        leftSpeed = speed - steering;
        rightSpeed = -(speed + steering);
        
        c_drive.setRawSpeeds(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        return distancePID.isDone();
    }

    @Override
    protected void end() {
        c_drive.setRawSpeeds(0, 0);
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void setHeading(double heading){
        c_drive.gyroPID.setSetpoint(heading);
        this.heading = heading;
    }
}