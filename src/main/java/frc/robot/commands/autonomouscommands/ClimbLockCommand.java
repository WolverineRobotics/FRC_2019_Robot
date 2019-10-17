package frc.robot.commands.autonomouscommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbLockCommand extends Command{

    private ClimbSubsystem c_climb;
    private boolean isDone;
    private boolean lock;

    public ClimbLockCommand(final boolean lock){
        c_climb = Robot.getClimbSubsystem();
        requires(c_climb);
        this.lock = !lock;
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

    @Override
    protected void initialize() {
        c_climb.unlockLock(lock);
        isDone = true;
    }

    @Override
    protected void execute() {
    }
    
}