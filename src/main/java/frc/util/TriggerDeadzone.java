package frc.util;

public class TriggerDeadzone{
    public TriggerDeadzone(){

    }

    public double getDeadzoneResult(double controlInput, double deadzoneAmount){
        //Allows for input values less than trigger values. 
        //Piecewise function, if less than deadzone value, 0
        //Else linear
        //https://www.desmos.com/calculator/h7gnlk21iz 

        if(Math.abs(controlInput) < deadzoneAmount){
            controlInput = 0;
        }else {
            if(controlInput>0){
                controlInput = ((controlInput - deadzoneAmount)/(1-deadzoneAmount));
            }else{
                controlInput = ((controlInput + deadzoneAmount)/(1-deadzoneAmount));
            }  
        }
        return controlInput;
    }
}