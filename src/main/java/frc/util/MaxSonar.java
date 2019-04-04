package frc.util;

import edu.wpi.first.wpilibj.AnalogInput;

public class MaxSonar extends AnalogInput {

    public MaxSonar(int channel) {
        super(channel);
    }

    public double getRangeInches() {
        return (((getVoltage()/1024)/5)*25.4);
    }

}