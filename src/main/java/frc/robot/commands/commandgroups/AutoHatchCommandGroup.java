package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoHatchCommandGroup extends CommandGroup {

    private IntakeSubsystem c_intake;
    private boolean isDone;

    public AutoHatchCommandGroup() {
        c_intake = Robot.getIntakeSubsystem();
        // requires(c_intake); //not sure if this should require since it uses other commands that require the same subsystem, like SetIntakeRotateCommand.
        isDone = false;
    }

    @Override
    protected void initialize() {
        addParallel(new OpenShovelCommand(true));
        addParallel(new SetIntakeRotateCommand(0 /*TBD - Kissing floor Encoder Pos */, 0.9 /* 90% speed */));
    }

    @Override
    protected void execute() {
        c_intake.setRollersRawSpeed(1); //Intaking out (to grab hatch)
        if(!OI.getOperatorAutoHatch()) { //Once button is not pressed anymore, see #end();
            isDone = true;
        }
    }

    @Override
    protected void end() {
        c_intake.setRollersRawSpeed(0); //Stop intaking
        Scheduler.getInstance().add(new LatchHatchCommandGroup()); //Call local commandgroup, see #LatchHatchCommandGroup below
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

    class LatchHatchCommandGroup extends CommandGroup {
        public LatchHatchCommandGroup() {
            addParallel(new OpenShovelCommand(false)); // close the shovel
            addParallel(new SetIntakeRotateCommand(-20, 1 /* FULL SPEED */)); // rotate for momentum
            addSequential(new OpenClawCommand(false)); // once the two above commands are done, latch the hatch
            addParallel(new OpenShovelCommand(true)); // open the shovel
            addParallel(new SetIntakeRotateCommand(-60, 1)); // rotate forward for convenience and so its away from the elevator
        }
    }

}