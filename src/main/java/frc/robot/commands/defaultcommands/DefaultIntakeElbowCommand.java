package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.RobotConst;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeElbowSubsystem;

public class DefaultIntakeElbowCommand extends Command{

    private final IntakeElbowSubsystem c_intakeElbow = Robot.getIntakeElbowSubsystem();

    public DefaultIntakeElbowCommand() {
        requires(c_intakeElbow);
    }

    // Someone professional please look over this & UNTESTED (TODO)
    @Override
    public void execute() {
        double tilt = OI.getOperatorIntakeTilt();
        double currentEncoderCount = c_intakeElbow.getEncoderPosition();
        double anticipate = currentEncoderCount + tilt;
        if(!(anticipate < RobotConst.INTAKE_ELBOW_ENCODER_MINIMUM && anticipate > RobotConst.INTAKE_ELBOW_ENCODER_MAXIMUM)) { //checks if anticipated rotate will exceed limits
            c_intakeElbow.setRawSpeed(anticipate);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}