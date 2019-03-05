package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultVisionCommand;

public class VisionSubsystem extends Subsystem {

    private I2C i2c;
    private byte[] data;


    public VisionSubsystem() {
        i2c = new I2C(Port.kOnboard, 0x54);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultVisionCommand());
    }

    public byte[] readCamera() {
        data = new byte[4];
        i2c.readOnly(data, data.length);
        return data;
    }

}