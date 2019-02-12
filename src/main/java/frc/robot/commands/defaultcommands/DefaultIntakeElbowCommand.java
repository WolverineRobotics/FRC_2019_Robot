package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeElbowSubsystem;

public class DefaultIntakeElbowCommand extends Command{

    private final IntakeElbowSubsystem c_intakeElbow = Robot.getIntakeElbowSubsystem();

    private final double maxEncoderCount = 0; //TBD
    private final double minEncoderCount = 0; //TBD

    public DefaultIntakeElbowCommand() {
        this.requires(c_intakeElbow);
    }

    // Someone professional please look over this
    // Untested
    @Override
    public void execute() {
        double tilt = OI.getOperatorIntakeTilt();
        double currentEncoderCount = c_intakeElbow.getEncoderPosition();
        double anticipate = currentEncoderCount + tilt;
        if(!(anticipate < minEncoderCount && anticipate > maxEncoderCount)) { //checks if anticipated rotate will exceed limits
            c_intakeElbow.setEncoderPosition((int) Math.floor(anticipate)); //0 is timeoutMs - time out in milliseconds?? idk help me i wanna die
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}