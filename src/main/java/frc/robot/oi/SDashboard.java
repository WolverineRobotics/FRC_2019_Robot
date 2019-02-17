package frc.robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.constants.GamePiece;
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
    GamePiece hatch = GamePiece.HATCH;
    GamePiece cargo = GamePiece.CARGO;

    SmartDashboard.putNumber("Current Elevator Pos", elevsys.getEncoderRawCounts());

    SmartDashboard.putNumber("Hatch Level 0:", hatch.getElevatorEncoderPos(0));
    SmartDashboard.putNumber("Hatch Level 1:", hatch.getElevatorEncoderPos(1));
    SmartDashboard.putNumber("Hatch Level 2:", hatch.getElevatorEncoderPos(2));
      
    SmartDashboard.putNumber("Cargo Level 0:", cargo.getElevatorEncoderPos(0));
    SmartDashboard.putNumber("Cargo Level 1:", cargo.getElevatorEncoderPos(1));
    SmartDashboard.putNumber("Cargo Level 2:", cargo.getElevatorEncoderPos(2));

    SmartDashboard.putNumber("Current Intake Elbow Pos", intakeElbow.getEncoderPosition());
    }

// ELEVATOR

// INTAKE

// CLIMB


}


