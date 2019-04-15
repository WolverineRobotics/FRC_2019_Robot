package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.JoystickMap;
import frc.robot.oi.OI;
import frc.robot.pid.GyroPID;
import frc.robot.subsystems.DriveSubsystem;

/**
 * ReverseDriveCommand
 */
public class ReverseDriveDirectionCommand extends Command{
    protected double power, heading, speed;

    protected GyroPID gyroPID;

    protected DriveSubsystem c_drive;

    public ReverseDriveDirectionCommand(double power, double heading){
        c_drive = Robot.getDriveSubsystem();
        System.out.println("Requires Drivesubsytem " + c_drive.getSubsystem());
        requires(c_drive);

        gyroPID = c_drive.gyroPID;

        this.power = power;
        this.heading = heading;
        this.speed = 0;

        setInterruptible(false);
    }

    @Override 
    protected void initialize() {	
        gyroPID.setSetpoint(heading);
        gyroPID.setEnabled(true);

    }
    
    @Override
    protected void execute() {
        double leftSpeed, rightSpeed;
        double steering;
 
        steering = gyroPID.calculate(c_drive.getPigeonHeading());

        speed = -power;

        leftSpeed = -(speed + steering);
        rightSpeed = (speed - steering);
        
        c_drive.setRawSpeeds(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        return OI.getDriver().getRawButton(JoystickMap.BUTTON_SELECT);
    }

    @Override
    protected void end() {
        c_drive.setRawSpeeds(0, 0);
        gyroPID.setEnabled(false);
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void setHeading(double heading){
        c_drive.gyroPID.setSetpoint(heading);
        this.heading = heading;
    }
    
}