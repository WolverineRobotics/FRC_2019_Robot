package frc.util;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Util{
    

    public static void addCommand(Command command1){
        Scheduler.getInstance().add(command1);
    }

    //Allows for input values less than trigger values. 
    //Piecewise function, if less than deadzone value, 0        
    //Else linear
    //https://www.desmos.com/calculator/h7gnlk21iz 

    public static double getDeadzoneResult(double controlInput, double deadzoneAmount){

        if(Math.abs(controlInput) < deadzoneAmount){
            controlInput = 0;
        } else {
            if(controlInput>0){
                controlInput = ((controlInput - deadzoneAmount)/(1-deadzoneAmount));
            }else{
                controlInput = ((controlInput + deadzoneAmount)/(1-deadzoneAmount));
            }  
        }
        return controlInput;
    }



    //Ensures motor power values are between -1 and 1
    public static double getMotorLimits(double motorPower){
        if (motorPower < -1){
            motorPower = -1;
        }else if(motorPower > 1){
            motorPower = 1;
        }

        return motorPower;
    }


   public static double setDeadzoneLimits(double controlInput, double deadzoneValue){
        
        controlInput = getDeadzoneResult(controlInput, deadzoneValue);
        controlInput = getMotorLimits(controlInput);
        return controlInput;
        

    }

}