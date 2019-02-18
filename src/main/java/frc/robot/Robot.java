//Testing git
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.commandgroups.AutonomousCommandGroup;
import frc.robot.oi.SDashboard;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.TechnicalSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class Robot extends TimedRobot {
	private static BlinkinSubsystem m_blinkin = new BlinkinSubsystem();
	private static DriveSubsystem m_drive = new DriveSubsystem();
	private static ElevatorSubsystem m_elevator = new ElevatorSubsystem();
	private static IntakeSubsystem m_intake = new IntakeSubsystem();
	private static VisionSubsystem m_vision = new VisionSubsystem();
	private static ClimbSubsystem m_climb = new ClimbSubsystem();
	private static TechnicalSubsystem m_technical = new TechnicalSubsystem();

	private static SDashboard m_dashboard = new SDashboard();

	@Override
	public void robotPeriodic() {
		m_dashboard.execute();
	}

	@Override
	public void autonomousInit() {
		Scheduler.getInstance().add(new AutonomousCommandGroup());
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public static BlinkinSubsystem getBlinkinSubsystem(){
		return m_blinkin;
	}
	
	public static DriveSubsystem getDriveSubsystem() {
		return m_drive;
	}

	public static ElevatorSubsystem getElevatorSubsystem() {
		return m_elevator;
	}

	public static TechnicalSubsystem getTechnicalSubsystem() {
		return m_technical;
	}

	public static VisionSubsystem getVisionSubsystem(){
		return m_vision;
	}

	public static ClimbSubsystem getClimbSubsystem(){
		return m_climb;
	}

	public static IntakeSubsystem getIntakeSubsystem() {
		return m_intake;
	}
}
