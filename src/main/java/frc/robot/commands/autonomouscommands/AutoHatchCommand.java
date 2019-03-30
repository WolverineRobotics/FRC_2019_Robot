package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoHatchCommand extends Command {

    private IntakeSubsystem c_intake;
    private boolean isDone;

    public AutoHatchCommand() {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
        isDone = false;
    }

    @Override
    protected void execute() {
        c_intake.setRollersRawSpeed(1);
        if(!OI.getOperatorAutoHatch()) {
            isDone = true;
        }
    }

    @Override
    protected void end() {
        c_intake.setRollersRawSpeed(0);
        Scheduler.getInstance().add(new GrabHatchCommandGroup());
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

    class GrabHatchCommandGroup extends CommandGroup {
        public GrabHatchCommandGroup() {
            addParallel(new OpenShovelCommand(false));
            addSequential(new SetIntakeRotateCommand(-20, 0.9));
            addSequential(new OpenClawCommand(false));
        }
    }

}