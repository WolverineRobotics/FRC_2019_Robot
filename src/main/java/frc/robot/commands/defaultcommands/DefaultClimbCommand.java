package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotConst;
import frc.robot.oi.OI;
import frc.robot.subsystems.ClimbSubsystem;

public class DefaultClimbCommand extends Command {

    private ClimbSubsystem c_climb = Robot.getClimbSubsystem();

    public DefaultClimbCommand() {
        requires(c_climb);
    }

    @Override
    public void execute() {
        if(c_climb.getClimbMode()) {
            double throttle = OI.getDriverThrottle();
            if(throttle < RobotConst.DRIVE_THORTTLE_TRIGGER_VALUE) {
                throttle = 0;
            }
            c_climb.setWheelVelocity(throttle);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}