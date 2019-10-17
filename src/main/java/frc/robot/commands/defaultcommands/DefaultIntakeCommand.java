package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.AutoHatchCommand;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.constants.JoystickMap;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeSubsystem;
import frc.util.Util;

public class DefaultIntakeCommand extends Command {

    private IntakeSubsystem c_intake;

    public DefaultIntakeCommand() {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
    }

    @Override
    protected void execute() {
        // Rotate ***************************
        double rotateSpeed = OI.getOperatorIntakeRotate() * 0.70;
        if(c_intake.getRotateEncoderPosition() < -110 && rotateSpeed == 0) {
            rotateSpeed = 0.07;
        }
        c_intake.setRotateRawSpeed(rotateSpeed);

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
        // if (c_intake.getUpperLimit()) {
        //     c_intake.resetEncoders();
        // }

        // Auto Hatch ************************
        if(OI.getOperatorAutoHatch()) {
            Util.addCommand(new AutoHatch());
        }

        // Auto Ball *************************
        if(OI.getOperatorAutoBall()) {
            if(!c_intake.getBallDetected()) {
                Util.addCommand(new AutoBall());
            }
        }

        // Reset Encoders ********************
        // if (OI.getTest().getRawButton(JoystickMap.BUTTON_START)) {
        //     c_intake.resetEncoders();
        // }
    }

    private class AutoHatch extends CommandGroup {
        public AutoHatch(){
            addSequential(new OpenClawCommand(true));
            addSequential(new OpenShovelCommand(true));
            addParallel(new SetElevatorCommand(100, 0.8));
            addSequential(new SetIntakeRotateCommand(-165, 1));
            addSequential(new AutoHatchCommand());
        }
    }

    private class AutoBall extends Command {
        private boolean isDone;
        public AutoBall() {
        }

        @Override
        protected void initialize() {
            // Util.addCommand(new AutoBallRotateDown()); //rotate down, open shovel and claw.
        }

        @Override
        protected void execute() {
            c_intake.setRotateRawSpeed(1); //intaking ball
            if(c_intake.getBallDetected() || !OI.getOperatorAutoBall()) { //if the ball is detected or if the operator lets go off the button
                isDone = true;
            }
        }

        @Override
        protected void end() {
            Util.addCommand(new SetIntakeRotateCommand(-175, 0.8));
        }

        @Override
        protected boolean isFinished() {
            return isDone;
        }
    }

    private class AutoBallRotateDown extends CommandGroup {
        public AutoBallRotateDown() {
            addParallel(new OpenShovelCommand(true));
            addParallel(new OpenClawCommand(true));
            addSequential(new SetIntakeRotateCommand(-175, 0.8));
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