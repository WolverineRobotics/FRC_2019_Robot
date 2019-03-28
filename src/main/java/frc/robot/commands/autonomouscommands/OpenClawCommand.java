package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeSubsystem;

public class OpenClawCommand extends Command {

    private IntakeSubsystem c_intake;

    private boolean toOpen;
    private boolean isDone;

    public OpenClawCommand(boolean toOpen) {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
        isDone = false;
        this.toOpen = toOpen;
    }

    @Override
    protected void initialize() {
        c_intake.setClaw(toOpen);
        isDone = true;
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

}