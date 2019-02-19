//Testing git
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class Robot extends TimedRobot {
	private static DriveSubsystem m_drive = new DriveSubsystem();
	private static BlinkinSubsystem m_blinkin = new BlinkinSubsystem();
	private static ElevatorSubsystem m_elevator = new ElevatorSubsystem();
	private static IntakeSubsystem m_intake = new IntakeSubsystem();
	
	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public static DriveSubsystem getDriveSubsystem() {
		return m_drive;
	}

	public static BlinkinSubsystem getBlinkinSubsystem() {
		return m_blinkin;
	}

	public static ElevatorSubsystem getElevatorSubsystem() {
		return m_elevator;
	}

	public static IntakeSubsystem getIntakeSubsystem() {
		return m_intake;
	}
}
