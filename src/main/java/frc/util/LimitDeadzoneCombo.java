package frc.util;

public class LimitDeadzoneCombo{
    public static double setDeadzoneLimits(double controlInput, double deadzoneValue){
        double output = controlInput;
        output = MotorLimits.getMotorLimits(output);
        output = TriggerDeadzone.getDeadzoneResult(output, deadzoneValue);
        return output;
        

    }
}