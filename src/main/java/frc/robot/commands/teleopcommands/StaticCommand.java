package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.blinkin.Colour;
import frc.robot.constants.blinkin.LEDCombo;
import frc.robot.subsystems.BlinkinSubsystem;


public class StaticCommand extends Command{

    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();

    private Colour colour1;
    private boolean isDone;

    public StaticCommand(Colour colour1){
        requires(c_blinkin);
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