//Testing git
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class Robot extends TimedRobot {
	private static DriveSubsystem m_drive = new DriveSubsystem();
	private static BlinkinSubsystem m_blinkin = new BlinkinSubsystem();
	
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
}
