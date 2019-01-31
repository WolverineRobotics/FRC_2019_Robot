package frc.robot.oi;

import frc.robot.Robot;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
private IntakeSubsystem intakesys = Robot.getIntakeSubsystem();
private ClimbSubsystem climbsys = Robot.getClimbSubsystem();

// DRIVE
/*
getPositionLeft()
getPositionRight()
getVelocityLeftEncoder()
getVelocityRightEncoder()
*/

// ELEVATOR

// INTAKE

// CLIMB


}


