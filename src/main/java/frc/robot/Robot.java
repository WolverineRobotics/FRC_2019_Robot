//Testing git
package frc.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.oi.SDashboard;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

// @SuppressWarnings("deprecation")
public class Robot extends TimedRobot {
	private static BlinkinSubsystem m_blinkin = new BlinkinSubsystem();
	private static ClimbSubsystem m_climb = new ClimbSubsystem();
	private static DriveSubsystem m_drive = new DriveSubsystem();
	private static ElevatorSubsystem m_elevator = new ElevatorSubsystem();
	private static IntakeSubsystem m_intake = new IntakeSubsystem();
	
	@Override
	
	public void robotInit() {
		CameraServer.getInstance().startAutomaticCapture();
	}

	@Override
	public void robotPeriodic() {
		SDashboard.execute(); // Periodically outputs information
	}

	@Override
	public void autonomousInit() {
		m_intake.resetEncoders();
		m_elevator.resetEncoder();
		m_climb.resetEncoders();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().close();
		Scheduler.getInstance().removeAll();
	}

	public static BlinkinSubsystem getBlinkinSubsystem() {
		return m_blinkin;
	}

	public static ClimbSubsystem getClimbSubsystem() {
		return m_climb;
	}

	public static DriveSubsystem getDriveSubsystem() {
		return m_drive;
	}

	public static ElevatorSubsystem getElevatorSubsystem() {
		return m_elevator;
	}

	public static IntakeSubsystem getIntakeSubsystem() {
		return m_intake;
	}
	
}
