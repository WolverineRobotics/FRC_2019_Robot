package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.VisionSubsystem;

public class AutoAlignVisionCommand extends Command {

    private VisionSubsystem c_vision;
    private boolean isDone;
    private int center_y; //TODO make into robotconst, this variable marks the center of the whole pixy camera's Y - axis

    public AutoAlignVisionCommand() {
        c_vision = Robot.getVisionSubsystem();
        isDone = false;
        center_y = (int) ((0 + 199) / 2);
        requires(c_vision);
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

    @Override
    protected void execute() {
        byte[] data = c_vision.readCamera(); 
        
        //block 1
        int x1 = data[0];
        int y1 = data[1];

        //block 2
        int x2 = data[2];
        int y2 = data[3];

        //INSERT PID STUFF HERE
    }


}