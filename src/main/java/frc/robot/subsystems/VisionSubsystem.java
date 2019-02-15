package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;

public class VisionSubsystem extends Subsystem {

    private I2C i2c; //connection to ARDUINO

    public VisionSubsystem() {
        i2c = new I2C(Port.kOnboard, RobotMap.VISION_I2C_DEVICE_ADDRESS);
    }

    @Override
    protected void initDefaultCommand() {

    }

    //delete later
    public void testBlink(String command) {
        char[] cArray = command.toCharArray();
        byte[] data = new byte[cArray.length];
        for(int i = 0; i < cArray.length; i++) {
            data[i] = (byte) cArray[i];
        }
        i2c.transaction(data, data.length, null, 0); //will send byte[] data, will tell that the length of the byte, and will receive null and will receive bytes of size 0.
    }
    
}