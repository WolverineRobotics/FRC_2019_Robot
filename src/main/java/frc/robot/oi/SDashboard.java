package frc.robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class SDashboard {

    private static ClimbSubsystem c_climb = Robot.getClimbSubsystem();
    private static DriveSubsystem c_drive = Robot.getDriveSubsystem();
    private static ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();
    private static IntakeSubsystem c_intake = Robot.getIntakeSubsystem();

    public static void execute() {

        SmartDashboard.putNumber("[Climb] Lift Speed", c_climb.getLiftRawSpeed());
        SmartDashboard.putNumber("[Climb] Lift Encoder Position", c_climb.getLiftEncoderPosition());
        // SmartDashboard.putNumber("[Climb] Lift Encoder Distance", c_climb.getLiftEncoderDistance());
        SmartDashboard.putNumber("[Climb] Wheel Speed", c_climb.getWheelRawSpeed());
        SmartDashboard.putBoolean("[Climb] Climb Mode", c_climb.getClimbingMode());

        SmartDashboard.putNumber("[Drive] Left Speed", c_drive.getLeftRawSpeed());
        SmartDashboard.putNumber("[Drive] Left Encoder", c_drive.getRawLeftEncoder());
        SmartDashboard.putNumber("[Drive] Right Speed", c_drive.getRightRawSpeed());
        SmartDashboard.putNumber("[Drive] Right Encoder", c_drive.getRawRightEncoder());
        SmartDashboard.putNumber("[Drive] Heading 1", c_drive.getHeading());
        SmartDashboard.putNumber("[Drive] Heading 2", c_drive.getPigeonHeading() % 360);
        SmartDashboard.putData("[Drive] Gyro PID", c_drive.gyroPID);

        SmartDashboard.putNumber("[Elevator] Raw Speed", c_elevator.getElevatorRawSpeed());
        // SmartDashboard.putNumber("[Elevator] Encoder Distance", c_elevator.getEncoderDistance());
        SmartDashboard.putNumber("[Elevator] Encoder Raw Counts", c_elevator.getEncoderPosition());
        SmartDashboard.putBoolean("[Elevator] Upper Limit Switch", c_elevator.getUpperLimitSwitch());
        
        SmartDashboard.putBoolean("[Intake] Ball Detected", c_intake.getBallDetected());
        SmartDashboard.putNumber("[Intake] Rollers Raw Speed", c_intake.getRollersRawSpeed());
        // SmartDashboard.putNumber("[Intake] Rotate Encoder Distance", c_intake.getRotateEncoderDistance());
        SmartDashboard.putNumber("[Intake] Rotate Encoder Position", c_intake.getRotateEncoderPosition());
        SmartDashboard.putNumber("[Intake] Rotate Raw Speed", c_intake.getRotateRawSpeed());
        SmartDashboard.putBoolean("[Intake] Claw Open", c_intake.getClawOpen());
        SmartDashboard.putBoolean("[Intake] Shovel Open", c_intake.getShovelOpen());
        SmartDashboard.putBoolean("[Intake] Upper Limit Reached", c_intake.getUpperLimit());

        SmartDashboard.putData(c_intake);
        SmartDashboard.putData(c_elevator);

        //gyro pitch
        double[] data = new double[3];
        c_drive.pigeon.getYawPitchRoll(data);
        SmartDashboard.putNumber("[Drive] Pigeon Pitch", data[1]);
        SmartDashboard.putNumber("[Drive] Pigeon Yaw", data[0]);
        SmartDashboard.putNumber("[Drive] Pigeon Roll", data[2]);
        //intake rotate - power and encoder
        //climb - power and encoder
        SmartDashboard.putNumber("[Drive] Distance", c_drive.getDistance());
        // SmartDashboard
    }
}