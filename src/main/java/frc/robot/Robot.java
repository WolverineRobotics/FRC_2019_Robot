//Testing git
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.TechnicalSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class Robot extends TimedRobot {
	private static DriveSubsystem m_drive = new DriveSubsystem();
	private static ElevatorSubsystem m_elevator = new ElevatorSubsystem();
	private static IntakeSubsystem m_intake = new IntakeSubsystem();
	private static TechnicalSubsystem m_technical = new TechnicalSubsystem();
	private static VisionSubsystem m_vision = new VisionSubsystem();
	private static ClimbSubsystem m_climb = new ClimbSubsystem();
	private static BlinkinSubsystem m_blinkin = new BlinkinSubsystem();

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
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

	public static TechnicalSubsystem getTechnicalSubsystem() {
		return m_technical;
	}

	public static VisionSubsystem getVisionSubsystem(){
		return m_vision;
	}

	public static ClimbSubsystem getClimbSubsystem(){
		return m_climb;
	}

	public static BlinkinSubsystem getBlinkinSubsystem(){
		return m_blinkin;
	}
}
