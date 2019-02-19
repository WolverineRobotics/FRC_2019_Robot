package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeSubsystem;

public class DefaultIntakeCommand extends Command {

    private IntakeSubsystem c_intake = Robot.getIntakeSubsystem();

    public DefaultIntakeCommand() {
        requires(c_intake);
    }

    @Override
    protected void execute() {
        double rotateSpeed = OI.getOperatorIntakeTilt();
        if(Math.abs(rotateSpeed) > 0.2) {
            c_intake.setRotateRawSpeed(rotateSpeed*0.5);
        }

        if(OI.getOperatorIntakeOut()) {
            c_intake.setRollersRawSpeed(1);
        } else if(OI.getOperatorIntakeOut()) {
            c_intake.setRollersRawSpeed(-1);
        }
    }

    /**
     * Default commands never finish.
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

}