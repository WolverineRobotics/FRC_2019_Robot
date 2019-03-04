package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.commands.teleopcommands.AutoAlignVisionCommand;
import frc.robot.oi.OI;
import frc.robot.subsystems.VisionSubsystem;

public class DefaultVisionCommand extends Command {

    private VisionSubsystem c_vision;

    public DefaultVisionCommand() {
        c_vision = Robot.getVisionSubsystem();
        requires(c_vision);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        if(OI.getController3TestButton()) {
            Scheduler.getInstance().add(new AutoAlignVisionCommand());
        }
    }



}