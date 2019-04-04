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
    protected void initialize() {
        Scheduler.getInstance().add(new SetIntakeRotateCommand(-170, 0.5));
        Scheduler.getInstance().add(new SetElevatorCommand(0, 0.99));
        c_intake.setRollersRawSpeed(-1);
    }

    @Override
    protected void execute() {
        if(!OI.getOperatorAutoHatch()) { // if the operator releases the button
            isDone = true;
        }
    }

    @Override
    protected void end() {
        c_intake.setRollersRawSpeed(0);
        Scheduler.getInstance().add(new LatchHatchCommandGroup());
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

    private class LatchHatchCommandGroup extends CommandGroup {
        public LatchHatchCommandGroup() {
            addSequential(new OpenShovelCommand(false)); //close shovel
            addSequential(new SetIntakeRotateCommand(-140, 0.9)); //rotate up for momentum
            addParallel(new OpenClawCommand(false)); //close claw
            addSequential(new OpenShovelCommand(true)); //open the shovel
        }
    }

}