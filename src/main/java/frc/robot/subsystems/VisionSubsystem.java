package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;

public class VisionSubsystem extends Subsystem {

    private PixyI2C pixyCam;

    private PixyPacket[] packet1 = new PixyPacket[7];

    public VisionSubsystem() {
        pixyCam = new PixyI2C(Port.kOnboard, RobotMap.VISION_I2C_DEVICE_ADDRESS);
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

    //delete later
    public void testBlink2() {
        for(int i = 0; i < packet1.length; i++) { //clears packet1
            packet1[i] = null;
        }
        for (int i = 1; i < 8; i++) {
			try {
				packet1[i - 1] = pixyCam.readPacket(i);
			} catch (PixyException e) {
				System.out.println("gearPixy Error: " + i + "exception");
			}
			if (packet1[i - 1] == null) {
				System.out.println("gearPixy Error: " + i + "True");
				continue;
			}
			System.out.println("gearPixy X Value: " + i + packet1[i - 1].x);
			System.out.println("gearPixy Y Value: " + i + packet1[i - 1].y);
			System.out.println("gearPixy Width Value: " + i + packet1[i - 1].width);
			System.out.println("gearPixy Height Value: " + i + packet1[i - 1].height);
			System.out.println("gearPixy Error: " + i + "False");
		}
    }
    
}