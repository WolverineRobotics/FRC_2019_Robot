package frc.util;

import edu.wpi.first.wpilibj.AnalogInput;

public class MaxSonar extends AnalogInput {

    public MaxSonar(int channel) {
        super(channel);
        //Note: If what I understand is correct, this means that the number of reports per second is reduced by 2^6
        //In other words, it should everage 2^6 values together and produce a single result
        //This should not be a problem, since it should be sampled 62500 / second
        //See https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599718-analog-inputs
        setAverageBits(6);
    }


    

    public double getRawRangeInches() {
        return (getRawRangeMM()/25.4);
    }

    public double getRawRangeMM(){
        return (getVoltage()*1000*5/4.88);
    }

    public double getAverageRangeInches(){
        return getAverageRangeMM()/25.4;
    }

    public double getAverageRangeMM(){
        return (getAverageVoltage()*1000*5/4.88);
    }


}