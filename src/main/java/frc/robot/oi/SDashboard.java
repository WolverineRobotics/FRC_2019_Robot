package frc.robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class SDashboard {

    private static BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();
    private static ClimbSubsystem c_climb = Robot.getClimbSubsystem();
    private static DriveSubsystem c_drive = Robot.getDriveSubsystem();
    private static ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();
    private static IntakeSubsystem c_intake = Robot.getIntakeSubsystem();

    public SDashboard() {

    }

    public static void execute() throws NullPointerException {
        // SmartDashboard.putString("[Blinkin] Colour", c_blinkin.getCurrentLED().name());
        // SmartDashboard.putString("[Blinkin] LED Combo", c_blinkin.getCurrentLEDCombo().name());

        SmartDashboard.putNumber("[Climb] Lift Speed", c_climb.getLiftSpeed());
        // SmartDashboard.putNumber("[Climb] Lift Encoder Position", c_climb.getLiftEncoderPosition());
        // SmartDashboard.putNumber("[Climb] Lift Encoder Distance", c_climb.getLiftEncoderDistance());
        SmartDashboard.putNumber("[Climb] Wheel Speed", c_climb.getWheelSpeed());

        SmartDashboard.putNumber("[Drive] Left Raw Speed", c_drive.getLeftRawSpeed());
        SmartDashboard.putNumber("[Drive] Left Encoder Position", c_drive.getRawLeftEncoder());
        SmartDashboard.putNumber("[Drive] Right Raw Speed", c_drive.getRightRawSpeed());
        SmartDashboard.putNumber("[Drive] Right Encoder Position", c_drive.getRawRightEncoder());

        SmartDashboard.putNumber("[Elevator] Elevator Speed", c_elevator.getElevatorRawSpeed());
        SmartDashboard.putNumber("[Elevator] Elevator Encoder Distance", c_elevator.getEncoderDistance());
        SmartDashboard.putNumber("[Elevator] Elevator Raw Counts", c_elevator.getEncoderRawCounts());
        // // SmartDashboard.putBoolean("[Elevator] Upper Limit Switch", c_elevator.getUpperLimitSwitch());
        // // SmartDashboard.putBoolean("[Elevator] Lower Limit Switch", c_elevator.getLowerLimitSwitch());
        
        SmartDashboard.putNumber("[Intake] Rollers Raw Speed", c_intake.getRollersRawSpeed());
        SmartDashboard.putNumber("[Intake] Rotate Raw Speed", c_intake.getRotateRawSpeed());
        SmartDashboard.putNumber("[Intake] Rotate Encoder Position", c_intake.getRotateEncoderPosition());
        SmartDashboard.putNumber("[Intake] Rotate Encoder Distance", c_intake.getRotateEncoderDistance());

    }

}