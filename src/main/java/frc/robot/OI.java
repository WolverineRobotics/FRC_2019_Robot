package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.constants.JoystickMap;

public class OI {
    private static Joystick driver = new Joystick(JoystickMap.DRIVER_PORT);
    private static Joystick operator = new Joystick(JoystickMap.OPERATOR_PORT);

    //********************************************************************************** 
    // Driver control constants
    //**********************************************************************************
    public static double getTurn() {
        return driver.getRawAxis(JoystickMap.LEFT_STICK_X);
    }
    public static double getThrottle() {
        return driver.getRawAxis(JoystickMap.RIGHT_STICK_Y);
    }

    //********************************************************************************** 
    // Operator controls
    //**********************************************************************************
    public static boolean getTestButton() {
        return operator.getRawButton(JoystickMap.BUTTON_X);
    }

    public static double getElevatorSpeed(){
        return operator.getRawAxis(JoystickMap.LEFT_STICK_Y);
    }
}
