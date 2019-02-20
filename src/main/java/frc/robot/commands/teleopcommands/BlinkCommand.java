import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.blinkin.Colour;
import frc.robot.subsystems.BlinkinSubsystem;

public class BlinkCommand extends Command{

    private BlinkinSubsystem c_blinkin = Robot.getBlinkinSubsystem();

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
        c_blinkin.setColour(colour1);
        Thread.sleep(delay);
        c_blinkin.setColour(colour2);
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }
    

}