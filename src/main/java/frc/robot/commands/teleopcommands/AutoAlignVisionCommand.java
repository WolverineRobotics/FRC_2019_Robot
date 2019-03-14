package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.VisionSubsystem;
import frc.util.PID;
import frc.util.PixyPacket;

public class AutoAlignVisionCommand extends Command {

    private VisionSubsystem c_vision;
    private boolean isDone;
    private int center_y; //TODO make into robotconst, this variable marks the center of the whole pixy camera's Y - axis
    private PID pid;

    public AutoAlignVisionCommand() {
        c_vision = Robot.getVisionSubsystem();
        isDone = false;
        center_y = (int) ((0 + 199) / 2);
        requires(c_vision);
        int kP = 0; //TBD make into robotconst
        int kI = 0; //TBD make into robotconst
        int kD = 0; //TBD make into robotconst
        pid = new PID(kP, kI, kD, 10);
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

    @Override
    protected void execute() {
        PixyPacket[] packets = c_vision.read();
        int x1 = packets[0].x;
        int y1 = packets[0].y;
        int width1 = packets[0].width;
        int height1 = packets[0].height;
        int x2 = packets[1].x;
        int y2 = packets[1].y;
        int width2 = packets[1].width;
        int height2 = packets[1].height;

        int center = (y2 - y1) / 2;
        double current = 0;
        if(center < center_y) { //go right
            
        } else { //go left
            
        }
        //INSERT PID STUFF HERE
    }


}