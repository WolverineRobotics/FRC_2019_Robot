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
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {

        //climb up and down
        double speedUp = OI.getDriverClimbSpeedUp();
        double speedDown = OI.getDriverClimbSpeedDown();
        if(Math.abs(speedUp) > 0.2) { //TODO add trigger values in robotconst
            c_climb.setLiftRawSpeed(speedUp*0.5);
        } else if(Math.abs(speedDown) > 0.2) { //TODO add trigger values in robotconst
            c_climb.setLiftRawSpeed(-speedDown*0.5);
        }

        //wheel throttle
        double throttle = OI.getDriverThrottle();
        if(Math.abs(throttle) > RobotConst.DRIVE_THORTTLE_TRIGGER_VALUE) {
            if(throttle > 1) {
                throttle = 1;
            } else if(throttle < -1) {
                throttle = -1;
            }
            c_climb.setWheelRawSpeed(throttle * 0.8);
        }
    }

}