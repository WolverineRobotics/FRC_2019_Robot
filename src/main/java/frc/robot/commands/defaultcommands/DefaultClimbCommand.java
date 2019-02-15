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
        if(OI.getDriverClimbing()) { //if driver presses Y, activate climb mode.
            c_climb.setClimbMode(true);
        }
        if(OI.getDriverCancel()) { //if driver presses B, disable climb mode.
            c_climb.setClimbMode(false);
        }
        if(c_climb.getClimbMode()) { //if climb subsystem is in climb mode,
            double throttle = OI.getDriverThrottle(); //get throttle (LEFT STICK Y)
            if(throttle < RobotConst.DRIVE_THORTTLE_TRIGGER_VALUE) { //if is not within trigger value
                throttle = 0; //do not move
            }
            c_climb.setWheelRawSpeed(throttle); //set the climb wheel to driver throttle
            if(OI.getDriverClimbSpeedUp() > 0.2) {
                c_climb.setClimbRawSpeed(0.2); //TODO adjust velocity value to liking
            } else if(OI.getDriverClimbSpeedDown() > 0.2) {
                c_climb.setClimbRawSpeed(-0.2); //TODO adjust velocity value to liking
            }
        }
    }

    /**
     * Default Commands will never finish.
     */
    @Override
    public boolean isFinished() {
        return false;
    }

}