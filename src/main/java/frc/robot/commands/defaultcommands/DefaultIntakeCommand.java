package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.constants.RobotConst;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeSubsystem;

public class DefaultIntakeCommand extends Command {

    private IntakeSubsystem c_intake = Robot.getIntakeSubsystem();

    public DefaultIntakeCommand() {
        requires(c_intake);
    }
    
    @Override
    public void execute() { 
        //ROTATE -----------------------------------------------
        double tilt = OI.getOperatorIntakeTilt();
        double currentEncoderCount = c_intake.getRotateRawEncoderPosition();
        double anticipate = currentEncoderCount + tilt;
        if(!(anticipate < RobotConst.INTAKE_ELBOW_ENCODER_MINIMUM && anticipate > RobotConst.INTAKE_ELBOW_ENCODER_MAXIMUM)) {
            c_intake.setCargoIntakeRawSpeed(anticipate);
        }

        //CARGO INTAKE -----------------------------------------
        boolean intakeIn = OI.getOperatorIntakeIn();
        boolean intakeOut = OI.getOperatorIntakeOut();
        if(!(intakeIn && intakeOut)) { //Precaution: makes sure both aren't pressed at the same time
            if(intakeIn) {
                c_intake.setCargoIntakeRawSpeed(0.75);
            } else if(intakeOut) {
                c_intake.setRotateRawSpeed(-0.75);
            }
        }

        //HATCH INTAKE --------------------------------------
        boolean openClaw = OI.getOperatorGrabHatch();
        boolean kachunkPush = OI.getOperatorEjectHatch();
        if(openClaw) {
            c_intake.clawOpen();
        } else {
            c_intake.clawClose();
        }
        if(kachunkPush) {
            c_intake.kachunk();
        } else {
            c_intake.kachink();
        }
    }

    /**
     * Default command does not finish
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

}