package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeSubsystem;

public class OpenShovelCommand extends Command {

    private IntakeSubsystem c_intake;
    boolean toOpen;

    public OpenShovelCommand(boolean toOpen) {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
        this.toOpen = toOpen;
    }

    @Override
    protected void initialize() {
        c_intake.setShovel(toOpen);
    }

    @Override
    protected boolean isFinished() {
        return true;   
    }

}