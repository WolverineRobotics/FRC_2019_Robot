package frc.robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class SDashboard {

    // private static BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();
    private static ClimbSubsystem c_climb = Robot.getClimbSubsystem();
    private static DriveSubsystem c_drive = Robot.getDriveSubsystem();
    private static ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();
    private static IntakeSubsystem c_intake = Robot.getIntakeSubsystem();

    public SDashboard() {

    }

    public static void execute() {
        // SmartDashboard.putString("[Blinkin] Colour", c_blinkin.getCurrentLED().name());
        // SmartDashboard.putString("[Blinkin] LED Combo" c_blinkin.getCurrentLEDCombo().name());

        // SmartDashboard.putNumber("[Climb] Lift Speed", c_climb.getLiftSpeed());
        // SmartDashboard.putNumber("[Climb] Lift Encoder Position", c_climb.getLiftEncoderPosition());
        // SmartDashboard.putNumber("[Climb] Lift Encoder Distance", c_climb.getLiftEncoderDistance());
        SmartDashboard.putNumber("[Climb] Wheel Speed", c_climb.getWheelSpeed());
        SmartDashboard.putBoolean("[Climb] Climb Mode!", c_climb.getClimbActive());

        SmartDashboard.putNumber("[Drive] Left Speed", c_drive.getLeftRawSpeed());
        SmartDashboard.putNumber("[Drive] Left Encoder", c_drive.getRawLeftEncoder());
        SmartDashboard.putNumber("[Drive] Right Speed", c_drive.getRightRawSpeed());
        SmartDashboard.putNumber("[Drive] Right Encoder", c_drive.getRawRightEncoder());
        SmartDashboard.putNumber("[Drive] Heading 1", c_drive.getHeading());
        SmartDashboard.putNumber("[Drive] Heading 2", c_drive.getPigeonHeading());

        // SmartDashboard.putNumber("[Elevator] Desired Position", c_elevator.getDesiredPosition());
        SmartDashboard.putNumber("[Elevator] Raw Speed", c_elevator.getElevatorRawSpeed());
        // SmartDashboard.putNumber("[Elevator] Encoder Distance", c_elevator.getEncoderDistance());
        SmartDashboard.putNumber("[Elevator] Encoder Raw Counts", c_elevator.getEncoderRawCounts());
        // SmartDashboard.putBoolean("[Elevator] Lower Limit Switch", c_elevator.getLowerLimitSwitch());
        SmartDashboard.putBoolean("[Elevator] Upper Limit Switch", c_elevator.getUpperLimitSwitch());
        
        SmartDashboard.putBoolean("[Intake] Ball Detected", c_intake.ballDetected());
        SmartDashboard.putNumber("[Intake] Rollers Raw Speed", c_intake.getRollersRawSpeed());
        // SmartDashboard.putNumber("[Intake] Rotate Encoder Distance", c_intake.getRotateEncoderDistance());
        SmartDashboard.putNumber("[Intake] Rotate Encoder Position", c_intake.getRotateEncoderPosition());
        SmartDashboard.putNumber("[Intake] Rotate Raw Speed", c_intake.getRotateRawSpeed());
        SmartDashboard.putString("[Intake] Claw Active", c_intake.getClawActive() ? "Forward" : "Reverse");
        SmartDashboard.putString("[Intake] Shovel Active", c_intake.getShovelActive() ? "Forward" : "Reverse");
        SmartDashboard.putBoolean("[Intake] Upper Limit Reached", c_intake.getUpperLimit());

        SmartDashboard.putData(c_intake);
        SmartDashboard.putData(c_elevator);
    }
}