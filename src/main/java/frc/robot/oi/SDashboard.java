package frc.robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeElbowSubsystem;
import frc.robot.subsystems.IntakeInOutSubsystem;

/*
 * We will be using shuffleboard for displaying data on the driverstation.
 * 
 * Docs:
 * https://wpilib.screenstepslive.com/s/currentCS/m/shuffleboard/l/814689-tour-
 * of-shuffleboard
 */

// THIS IS STILL TODO!

public class SDashboard {

private DriveSubsystem drivesys = Robot.getDriveSubsystem();
private ElevatorSubsystem elevsys = Robot.getElevatorSubsystem();
private IntakeInOutSubsystem intakeInOut = Robot.getIntakeInOutSubsystem();
private IntakeElbowSubsystem intakeElbow = Robot.getIntakeElbowSubsystem();
private ClimbSubsystem climbsys = Robot.getClimbSubsystem();

// DRIVE
/*
getPositionLeft()
getPositionRight()
getVelocityLeftEncoder()
getVelocityRightEncoder()
*/

public SDashboard() {
    SmartDashboard.putNumber("Intake Elbow Encoder Position", intakeElbow.getEncoderPosition());
    SmartDashboard.putBoolean("Intake Activated", intakeInOut.getActivated());
}

// ELEVATOR

// INTAKE

// CLIMB


}


