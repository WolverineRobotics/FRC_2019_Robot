package frc.util.combo;

import frc.util.*;;


//Requires TriggerDeadzone.java and MotorLimits.java

public class LimitDeadzoneCombo{

    public static double setDeadzoneLimits(double controlInput, double deadzoneValue){
        
        double output = controlInput;
        output = TriggerDeadzone.getDeadzoneResult(output, deadzoneValue);
        output = MotorLimits.getMotorLimits(output);
        return output;
        

    }
}