package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.AutoHatchCommand;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
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
        double rotateSpeed = OI.getOperatorIntakeRotate();
        c_intake.setRotateRawSpeed(rotateSpeed*0.6);
        if(c_intake.getRotateEncoderPosition() < -110 && rotateSpeed == 0) {
            c_intake.setRotateRawSpeed(0.07);
        }

        // Rollers *************************
        boolean intakeIn = OI.getOperatorIntakeIn(); 
        boolean intakeOut = OI.getOperatorIntakeOut();
        if(intakeIn) {
            c_intake.setRollersRawSpeed(1);
        } else if(intakeOut) {
            c_intake.setRollersRawSpeed(-0.95);
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

        // Auto Hatch ************************
        if(OI.getOperatorAutoHatch()) {
            Scheduler.getInstance().add(new AutoHatch());
        }

        if (OI.getDriver().getRawButton(JoystickMap.BUTTON_START) && OI.getOperator().getRawButton(JoystickMap.BUTTON_START)) {
            c_intake.resetEncoders();
        }
    }

    private class AutoHatch extends CommandGroup {
        AutoHatch(){
            addSequential(new OpenClawCommand(true));
            addSequential(new OpenShovelCommand(true));
            addParallel(new SetElevatorCommand(100, 0.8));
            addSequential(new SetIntakeRotateCommand(-175, 1));
            addSequential(new AutoHatchCommand());
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