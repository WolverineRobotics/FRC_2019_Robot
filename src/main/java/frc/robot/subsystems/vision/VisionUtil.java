package frc.robot.subsystems.vision;

import java.nio.ByteBuffer;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public class VisionUtil {

    private final Port port = I2C.Port.kOnboard;
    private final int deviceAddress = 0;

    private I2C i2c = new I2C(port, deviceAddress);

    //Converts byte array data to String
    public static String getCommand(byte[] data) {
        String cmd = "";
        for(byte b : data) {
            cmd = cmd + b;
        }
        return cmd;
    }

    //Converts String commnad to byte array
    public static byte[] getCommand(String command) {
        char[] cArray = command.toCharArray();
        byte[] byteCommand = new byte[cArray.length];
        for(int i = 0; i < cArray.length; i++) {
            byteCommand[i] = (byte) cArray[i];
        }
        return byteCommand;
    }
    
    //Sends command to arduino
    public void sendCommand(byte[] byteCommand) {
        i2c.transaction(byteCommand, byteCommand.length, null, 0);
    }

    public byte[] getData() {
        ByteBuffer bb; //TODO
        int count = 0; //TODO
        i2c.read(deviceAddress, count, bb);
    }
}