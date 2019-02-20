package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.blinkin.Colour;
import frc.robot.subsystems.BlinkinSubsystem;

//Sets LED to colour1 for "delay" time, then sets LED to colour2


public class BlinkCommand extends Command{

    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();
    private boolean isDone;

    private long delay;
    private Colour colour1;
    private Colour colour2;

    public BlinkCommand(long delay, Colour colour1, Colour colour2){
        requires(c_blinkin);
        this.delay = delay;
        this.colour1 = colour1;
        this.colour2 = colour2;
    }

    @Override
    protected void execute() {
        try {
            c_blinkin.setColour(colour1);
            Thread.sleep(delay);
            c_blinkin.setColour(colour2);
            Thread.sleep(delay);
        } catch (Exception e) {
            System.out.println("Thread sleeping caused an error");
        }
        isDone = true;
    }
    
    @Override
    protected boolean isFinished() {
        return isDone;
    }
    

}