package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.commandgroups.ClimbCommandGroup;
import frc.robot.oi.OI;
import frc.robot.subsystems.ClimbSubsystem;

public class DefaultClimbCommand extends Command {

    private ClimbSubsystem c_climb;

    public DefaultClimbCommand() {
        c_climb = Robot.getClimbSubsystem();
        requires(c_climb);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        if (OI.getDriverClimbState()) {
            Scheduler.getInstance().add(new ClimbCommandGroup());
            c_climb.unlockLock(false);
		}
		
		if (OI.getDriverCancel()) {
            c_climb.unlockLock(true);
        }
        
		//climb lift
		double speedUp = OI.getDriverClimbSpeedUp();
        double speedDown = OI.getDriverClimbSpeedDown();
        double speed = speedUp - speedDown;
                
        c_climb.setLiftRawSpeed(speed);

        //wheel lift
        double throttle = OI.getDriverThrottle();
        c_climb.setWheelRawSpeed(-throttle * 0.9);
    }
}