package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.blinkin.Colour;
import frc.robot.subsystems.BlinkinSubsystem;


public class StaticCommand extends Command{

    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();

    private boolean isDone;
    private Colour colour1;

    public StaticCommand(Colour colour1){
        c_blinkin = Robot.getBlinkinSubsystem();
        requires(c_blinkin);
        this.isDone = false;
        this.colour1 = colour1;
    }

    @Override
    protected void execute() {
        c_blinkin.setColour(colour1);
        isDone = true;
    }


    @Override
    protected boolean isFinished() {
        return isDone;
    }


}