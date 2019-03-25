package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.JoystickMap;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeSubsystem;

public class DefaultIntakeCommand extends Command {

    private IntakeSubsystem c_intake;

    public DefaultIntakeCommand() {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
    }

    @Override
    protected void execute() {
        // Rotate ***************************
        double rotateSpeed = OI.getOperatorIntakeTilt();
        c_intake.setRotateRawSpeed(rotateSpeed*0.6);

        // Rollers *************************
        boolean intakeIn = OI.getOperatorIntakeIn(); 
        boolean intakeOut = OI.getOperatorIntakeOut();
        if(intakeIn) {
            c_intake.setRollersRawSpeed(1);
        } else if(intakeOut) {
            c_intake.setRollersRawSpeed(-0.75);
        } else {
            c_intake.setRollersRawSpeed(0);
        }

        // Claw *****************************
        if (OI.getOperatorClaw()) {
            c_intake.toggleClaw();
        }
        c_intake.executeClaw();

        // Shovel ***************************
        if (OI.getOperatorShovel()) {
            c_intake.toggleShovel();
        }
        c_intake.executeShovel();

        // Encoders **************************
        if (c_intake.getUpperLimit()) {
            c_intake.resetEncoders();
        }
        if (OI.getDriver().getRawButton(JoystickMap.BUTTON_START) && OI.getOperator().getRawButton(JoystickMap.BUTTON_START)) {
            c_intake.resetEncoders();
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