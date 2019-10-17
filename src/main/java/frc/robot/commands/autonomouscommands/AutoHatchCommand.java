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
        // requires(c_intake);
        isDone = false;
    }

    @Override
    protected void initialize() {
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
        System.out.println("engaging claw thingy");
        Scheduler.getInstance().add(new LatchHatchCommandGroup());
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

    private class LatchHatchCommandGroup extends CommandGroup {
        public LatchHatchCommandGroup() {
            c_intake.setRollersRawSpeed(0);
            addSequential(new OpenShovelCommand(false)); //close shovel
            addSequential(new SetIntakeRotateCommand(-120, 0.9)); //rotate up for momentum
            addSequential(new WaitCommand(0.5));
            addSequential(new OpenClawCommand(false));
        }
    }

}