//Testing git
package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.autonomouscommands.ClimbLockCommand;
import frc.robot.commands.commandgroups.FinalsAutoWestern;
import frc.robot.commands.commandgroups.TestAndResetCommandGroup;
import frc.robot.commands.commandgroups.TestAuto;
import frc.robot.constants.JoystickMap;
import frc.robot.constants.RobotMap;
import frc.robot.oi.AutoSelector;
import frc.robot.oi.OI;
import frc.robot.oi.SDashboard;
import frc.robot.subsystems.BlinkinSubsystem;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

@SuppressWarnings("deprecation")
public class Robot extends TimedRobot {
	private static BlinkinSubsystem m_blinkin = new BlinkinSubsystem();
	private static ClimbSubsystem m_climb = new ClimbSubsystem();
	private static DriveSubsystem m_drive = new DriveSubsystem();
	private static ElevatorSubsystem m_elevator = new ElevatorSubsystem();
	private static IntakeSubsystem m_intake = new IntakeSubsystem();
	public static CameraSubsystem m_camera = new CameraSubsystem();
	public static UsbCamera camera;

	@Override
	public void robotInit() {
		
		m_intake.resetEncoders();
		m_elevator.resetEncoder();
		m_climb.resetEncoders();
		m_drive.resetEncoders();
		m_drive.pigeon.setYaw(0);

		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setVideoMode(PixelFormat.kMJPEG, 320, 240, 15);
		camera.setExposureManual(70);

		// to clean up
		VictorSPX ledring = new VictorSPX(RobotMap.VISION_LED_RING);
		ledring.set(ControlMode.PercentOutput, -1);

        SmartDashboard.putData("start position", AutoSelector.startPosition);
        SmartDashboard.putData("first hatch", AutoSelector.firstHatch);
        SmartDashboard.putData("second hatch", AutoSelector.secondHatch);
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
		m_drive.resetEncoders();
		m_drive.pigeon.setYaw(0);

		// Scheduler.getInstance().add(new AutonomousCommandGroup());
		// (new AutonomousCommandGroup()).start();
		// Util.addCommand(new TestAuto(1));
		// (new ClimbLockCommand(true)).start();
		// (new TestAuto(1)).start();
		// (new FinalsAutoWestern()).start();
		(new TestAndResetCommandGroup()).start();
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

		(new ClimbLockCommand(true)).start();
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void teleopPeriodic() {
		m_camera.updatePeriodic();
		Scheduler.getInstance().run();

		if(OI.getOperator().getRawButton(JoystickMap.BUTTON_X)){
			Scheduler.getInstance().removeAll();
		}
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
