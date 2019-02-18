package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class VisionSubsystem extends Subsystem {

    public VisionSubsystem() {
        
    }

    @Override
    protected void initDefaultCommand() {

    }

    class PixyPacket {
        int x;
        int y;
        int width;
        int height;
        int angle;
    }

    class PixyException extends Exception {
        public PixyException(String message) {
            super(message);
        }
    }
}