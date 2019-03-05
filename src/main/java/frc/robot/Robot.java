//Testing git
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.oi.SDashboard;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class Robot extends TimedRobot {
	private static BlinkinSubsystem m_blinkin;
	private static ClimbSubsystem m_climb;
	private static DriveSubsystem m_drive;
	private static ElevatorSubsystem m_elevator;
	private static IntakeSubsystem m_intake;
	private static VisionSubsystem m_vision;
	
	@Override
	public void robotInit() {
		m_blinkin = new BlinkinSubsystem();
		m_climb = new ClimbSubsystem();
		m_drive = new DriveSubsystem();
		m_elevator = new ElevatorSubsystem();
		m_intake = new IntakeSubsystem();
		m_vision = new VisionSubsystem();
	}

	@Override
	public void robotPeriodic() {
		SDashboard.execute(); // Periodically outputs information
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// Scheduler.getInstance().enable();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		SDashboard.execute(); // Periodically outputs information
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
	
	public static VisionSubsystem getVisionSubsystem() {
		return m_vision;
	}

}
