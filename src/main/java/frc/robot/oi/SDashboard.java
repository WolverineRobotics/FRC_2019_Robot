package frc.robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.constants.GamePiece;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.VisionSubsystem;

/*
 * We will be using shuffleboard for displaying data on the driverstation.
 * 
 * Docs:
 * https://wpilib.screenstepslive.com/s/currentCS/m/shuffleboard/l/814689-tour-
 * of-shuffleboard
 */

public class SDashboard {

    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();
    private ClimbSubsystem c_climb = Robot.getClimbSubsystem();
    private DriveSubsystem c_drive = Robot.getDriveSubsystem();
    private ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();
    private IntakeSubsystem c_intake = Robot.getIntakeSubsystem();
    private VisionSubsystem c_vision = Robot.getVisionSubsystem();

    public SDashboard() {
        execute();
    }

    public void execute() {
        GamePiece hatch = GamePiece.HATCH;
        GamePiece cargo = GamePiece.CARGO;
    
        SmartDashboard.putString("[Blinkin] Current LED: ", c_blinkin.getCurrentLED().name());
        SmartDashboard.putString("[Blinkin] Current LED Combo: ", c_blinkin.getCurrentLEDCombo().name());
    
        SmartDashboard.putBoolean("[Climb] Climb Mode: ", c_climb.getClimbMode());
        SmartDashboard.putNumber("[Climb] Wheel Speed: ", c_climb.getWheelRawSpeed());
        SmartDashboard.putNumber("[Climb] Wheel Encoder Position: ", c_climb.getWheelRawPosition());
        SmartDashboard.putNumber("[Climb] Climb Speed: ", c_climb.getClimbRawSpeed());
        SmartDashboard.putNumber("[Climb] Climb Encoder Position: ", c_climb.getClimbRawPosition());
    
        SmartDashboard.putNumber("[Drive] Left Speed: ", c_drive.getRawLeftSpeed());
        // SmartDashboard.putNumber("[Drive] Left Encoder Position: ", c_drive.getPositionLeft());
        SmartDashboard.putNumber("[Drive] Right Speed: ", c_drive.getRawRightSpeed());
        // SmartDashboard.putNumber("[Drive] Right Encoder Position: ", c_drive.getPositionRight());
    
        SmartDashboard.putNumber("[Elevator] Speed: ", c_elevator.getRawEncoderSpeed());
        SmartDashboard.putNumber("[Elevator] Encoder Position: ", c_elevator.getRawEncoderPosition());
    
        SmartDashboard.putNumber("[Intake] Intake Speed", c_intake.getIntakeRawSpeed());
        SmartDashboard.putNumber("[Intake] Rotate Speed", c_intake.getRotateRawSpeed());
        SmartDashboard.putNumber("[Intake] Rotate Encoder Position: ", c_intake.getRotateRawEncoderPosition());
        SmartDashboard.putString("[Intake] Kachunker", c_intake.getKachunkerValue().name());
        SmartDashboard.putBoolean("[Intake] Cargo Sensor", c_intake.getCargoLimitSwitch());
        SmartDashboard.putBoolean("[Intake] Hatch Top Sensor", c_intake.getHatchTopLimitSwitch());
        SmartDashboard.putBoolean("[Intake] Hatch Bottom Sensor", c_intake.getHatchBottomLimitSwitch());
    
        SmartDashboard.putNumber("[Elevator] (Constant) Hatch Level 0: ", hatch.getElevatorEncoderPos(0));
        SmartDashboard.putNumber("[Elevator] (Constant) Hatch Level 1: ", hatch.getElevatorEncoderPos(1));
        SmartDashboard.putNumber("[Elevator] (Constant) Hatch Level 2: ", hatch.getElevatorEncoderPos(2));
          
        SmartDashboard.putNumber("[Elevator] (Constant) Cargo Level 0: ", cargo.getElevatorEncoderPos(0));
        SmartDashboard.putNumber("[Elevator] (Constant) Cargo Level 1: ", cargo.getElevatorEncoderPos(1));
        SmartDashboard.putNumber("[Elevator] (Constant) Cargo Level 2: ", cargo.getElevatorEncoderPos(2));
    }
}


