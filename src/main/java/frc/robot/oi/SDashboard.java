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

    public static void execute() {
        // SmartDashboard.putString("[Blinkin] Colour", c_blinkin.getCurrentLED().name());
        // SmartDashboard.putString("[Blinkin] LED Combo" c_blinkin.getCurrentLEDCombo().name());

        SmartDashboard.putNumber("[Climb] Lift Speed", c_climb.getLiftSpeed());
        SmartDashboard.putNumber("[Climb] Lift Encoder Position", c_climb.getLiftEncoderPosition());
        SmartDashboard.putNumber("[Climb] Lift Encoder Distance", c_climb.getLiftEncoderDistance());
        SmartDashboard.putNumber("[Climb] Wheel Speed", c_climb.getWheelSpeed());

    }

}