package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;

public class PixyI2C {

    private I2C i2c; //connection to ARDUINO
    private PixyPacket[] packets;
    private PixyException pExc;
    private int Signature;


    public PixyI2C(Port port, int deviceAddress) {
        i2c = new I2C(port, deviceAddress);
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
    
    /**
     * This method gathers data, then parses that data and assigns the ints to global variables.
     */
    public PixyPacket readPacket(int signature, int dataLength) throws PixyException {
        byte[] rawData = new byte[dataLength];
        int Sig;
        int Checksum;
        
        i2c.readOnly(rawData, rawData.length);

        if(rawData.length < 32) {
            System.out.println("Pixy Cam did not give the correct byte length.")
            return null;
        }

        for (int i = 0; i <= 16; i++) {
            int syncWord = cvt(rawData[i+1], rawData[i+0]);
            if(syncWord == 0xaa55) { //checks if first two bytes equal a "sync word"which indicates the start of a packet of valid data
                syncWord = cvt(rawData[i+3], rawData[i+0]);
                if(syncWord!= 0xaa55) {
                    i = i - 2;
                }
                //This next block parses the rest of the data
                Checksum = cvt(rawData[i+5], rawData[i+4]);
                Sig = cvt(rawData[i+7], rawData[i+6]);
                if(Sig <= 0 || Sig > packets.length) {
                    break;
                }

                packets[Sig - 1] = new PixyPacket();
				packets[Sig - 1].x = cvt(rawData[i+9], rawData[i+8]);
				packets[Sig - 1].y = cvt(rawData[i+11], rawData[i+10]);
				packets[Sig - 1].width = cvt(rawData[i+13], rawData[i+12]);
				packets[Sig - 1].height = cvt(rawData[i+15], rawData[i+14]);
				//Checks whether the data is valid using the checksum *This if block should never be entered*
				if (Checksum != Sig + packets[Sig - 1].x + packets[Sig - 1].y + packets[Sig - 1].width + packets[Sig - 1].height) {
					packets[Sig - 1] = null;
					throw pExc;
				}
				break;
            } else {
                System.out.println("Syncword: " + syncWord);
            }
        }
        //Assigns our packet to a temp packet, then delets data so that we don't return old data.
        PixyPacket pkt= packets[Signature - 1];
        packets[Signature - 1] = null;
        return pkt;
    }

    public int cvt(byte upper, byte lower) {
        return (((int) upper & 0xff) << 8) | ((int) lower & 0xff);
    }

    
    //delete later
    public void testBlink(String command) {
        char[] cArray = command.toCharArray();
        byte[] data = new byte[cArray.length];
        for(int i = 0; i < cArray.length; i++) {
            data[i] = (byte) cArray[i];
        }
        pixyCam.transaction(data, data.length, null, 0); //will send byte[] data, will tell that the length of the byte, and will receive null and will receive bytes of size 0.
    }
}