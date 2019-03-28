package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeSubsystem;

public class OpenShovelCommand extends Command {

    private IntakeSubsystem c_intake;

    private boolean toOpen;
    private boolean isDone;

    public OpenShovelCommand(boolean toOpen) {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
        this.toOpen = toOpen;
        this.isDone = false;
    }

    @Override
    protected void initialize() {
        c_intake.setClaw(toOpen);
    }

    @Override
    protected boolean isFinished() {
        return isDone;   
    }

}