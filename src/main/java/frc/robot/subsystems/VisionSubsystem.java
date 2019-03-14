package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultVisionCommand;
import frc.util.PixyPacket;

public class VisionSubsystem extends Subsystem {

    private I2C i2c;
    private final int MAX_SIZE = 32;
    private final int REGISTER_ADDRESS = 0; //TBD

    public VisionSubsystem() {
        i2c = new I2C(Port.kOnboard, 0x54);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultVisionCommand());
    }



    /**
     * Returns the data received from the arduino
     * Example:
     * x|y|width|height|x|y|width|height
     * @return PixyPacket with length of 2 (ALWAYS)
     * PixyPacket[0] gives you the first vision target
     * PixyPacket[1] gives you the second vision target
     * 
     */
    private PixyPacket[] read() {
        byte[] data = new byte[MAX_SIZE];
        i2c.read(0, MAX_SIZE, data);
        String output[] = (new String(data)).split("\\|");
        if(!output[0].equals("none") && output[0].equals("")) {
            for(int i = 0; i < output.length; i+=4) {
                int x = (int) 
            }
        }

        PixyPacket target1 = new PixyPacket();
        PixyPacket target2 = new PixyPacket();
        PixyPacket[] packets = new PixyPacket[2];
        packets[0] = target1;
        packets[1] = target2;
        return packets;
    }

}