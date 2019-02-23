package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.blinkin.Colour;
import frc.robot.oi.OI;
import frc.robot.subsystems.BlinkinSubsystem;

//Sets LED to colour1 for "delay" time, then sets LED to colour2


public class BlinkCommand extends Command{

    private BlinkinSubsystem c_blinkin;
    private boolean isDone;

    private long delay;
    private Colour colour1;
    private Colour colour2;

    public BlinkCommand(long delay, Colour colour1, Colour colour2){
        c_blinkin = Robot.getBlinkinSubsystem();
        requires(c_blinkin);
        this.isDone = false;
        this.delay = delay;
        this.colour1 = colour1;
        this.colour2 = colour2;
    }

    @Override
    protected void execute() {
        while(!isDone) {
            try {
                c_blinkin.setColour(colour1);
                Thread.sleep(delay);
                c_blinkin.setColour(colour2);
                Thread.sleep(delay);
            } catch (Exception e) {
                System.out.println("Thread sleeping caused an error");
            }
            if(OI.getDriverCancel()) {
                isDone = true;
                break;
            }
        }
    }
    
    @Override
    protected boolean isFinished() {
        return isDone;
    }
    

}