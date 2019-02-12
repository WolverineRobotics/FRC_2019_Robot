package frc.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.constants.JoystickMap;

/**
 * WIP:
 * 
 * Driver Controller
 * 	Sticks:
 * 		Right Stick Y-axis 	= Drive Motor Turn
 * 		Left Stick X-axis  	= Drive Motor Throttle
 * 	Buttons:
 *      A Button            = Requesting Hatch (Toggle) - LED: Yellow
 *      B Button            = Requesting Cargo (Toggle) - LED: Orange
 *      X Button            = Climbing mode (Toggle) - LED: Aqua
 * 	Bumpers/Triggers:
 * 		Left Bumper			= High Gear (Turbo)
 * 		Left Trigger 		= Climb Speed down (Manual Control)
 * 		Right Trigger		= Climb Speed up (Manual Control) 
 *  Extras:
 *      Rumble              = Auto intaking
 * 
 * 
 * Operator Controller
 * 	Sticks:
 * 		Left Stick Y-axis  	= Elevator Motor Speed (Manual Control)
 * 		Right Stick Y-axis	= Intake Tilt Motor Speed (Manual Control)
 * 		Right Stick X    	=
 * 		Right Stick Y    	= 
 * 		Right Stick Press  	= 
 * 		Left Stick Press 	= 
 * 	Buttons:
 *      A Button            = 
 * 		X Button			= 
 * 	Bumpers/Triggers:
 * 		Left Trigger 		= Intake in (ball mechanism)
 * 		Right Trigger		= Intake out (ball mechanism)
 * 		Left Bumper			= Eject hatch (automatic)		
 * 		Right Bumper		= Grab hatch (automatic)
 *
 */

public class OI {
    private static Joystick driver = new Joystick(JoystickMap.DRIVER_PORT);
    private static Joystick operator = new Joystick(JoystickMap.OPERATOR_PORT);

    //********************************************************************************** 
    // Driver control constants
    //**********************************************************************************
    public static double getDriverTurn() { //returns -1 to 1 on left stick X
        return driver.getRawAxis(JoystickMap.RIGHT_STICK_X);
    }
    public static double getDriverThrottle() { //returns -1 to 1 on right stick Y
        return driver.getRawAxis(JoystickMap.LEFT_STICK_Y);
    }
    public static boolean getDriverClimbingLED() {
        return driver.getRawButtonReleased(JoystickMap.BUTTON_X);
    }
    public static boolean getDriverRequestionHatchLED() {
        return driver.getRawButtonReleased(JoystickMap.BUTTON_A);
    }
    public static boolean getDriverRequestCargoLED() {
        return driver.getRawButtonReleased(JoystickMap.BUTTON_B);
    }
    public static boolean getDriverClimbSpeedDown() {
        return driver.getRawButtonPressed(JoystickMap.LEFT_TRIGGER);
    }
    public static boolean getDriverClimbSpeedUp() {
        return driver.getRawButtonPressed(JoystickMap.RIGHT_TRIGGER);
    }

    //********************************************************************************** 
    // Operator controls
    //**********************************************************************************
    public static double getElevatorSpeed(){
        return operator.getRawAxis(JoystickMap.LEFT_STICK_Y);
    }

    public static double getOperatorIntakeTilt() {
        return operator.getRawAxis(JoystickMap.RIGHT_STICK_Y);
    }

    public static boolean getOperatorIntakeIn() {
        return operator.getRawButtonPressed(JoystickMap.LEFT_TRIGGER);
    }

    public static boolean getOperatorIntakeOut() {
        return operator.getRawButtonPressed(JoystickMap.RIGHT_TRIGGER);
    }

    public static boolean getOperatorEjectHatch() {
        return operator.getRawButtonReleased(JoystickMap.BUTTON_LEFT_BUMPER);
    }
    
    public static boolean getOperatorGrabHatch() {
        return operator.getRawButtonReleased(JoystickMap.BUTTON_RIGHT_BUMPER);
    }
}
