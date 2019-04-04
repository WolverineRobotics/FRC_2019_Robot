package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeSubsystem;

public class OpenShovelCommand extends Command {

    private IntakeSubsystem c_intake;

    public OpenShovelCommand(boolean toOpen) {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
        c_intake.setShovel(toOpen);
    }

    @Override
    protected boolean isFinished() {
        return true;   
    }

}