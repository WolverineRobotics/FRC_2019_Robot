//Testing git
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeElbowSubsystem;
import frc.robot.subsystems.IntakeInOutSubsystem;
import frc.robot.subsystems.TechnicalSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class Robot extends TimedRobot {
	private static BlinkinSubsystem m_blinkin = new BlinkinSubsystem();
	private static DriveSubsystem m_drive = new DriveSubsystem();
	private static ElevatorSubsystem m_elevator = new ElevatorSubsystem();
	private static IntakeElbowSubsystem m_intakeElbow = new IntakeElbowSubsystem();
	private static IntakeInOutSubsystem m_intakeInOut = new IntakeInOutSubsystem();
	private static TechnicalSubsystem m_technical = new TechnicalSubsystem();
	private static VisionSubsystem m_vision = new VisionSubsystem();
	private static ClimbSubsystem m_climb = new ClimbSubsystem();

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

	public static IntakeElbowSubsystem getIntakeElbowSubsystem() {
		return m_intakeElbow;
	}
	
	public static IntakeInOutSubsystem getIntakeInOutSubsystem() {
		return m_intakeInOut;
	}
}
