package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeSubsystem;

public class OpenClawCommand extends Command {

    private IntakeSubsystem c_intake;
    boolean toOpen;

    public OpenClawCommand(boolean toOpen) {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
        this.toOpen = toOpen;
    }

    @Override
    protected void initialize() {
        c_intake.setClaw(toOpen);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}