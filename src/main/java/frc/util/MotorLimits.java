package frc.util;

public class MotorLimits {

    public MotorLimits(){

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
}