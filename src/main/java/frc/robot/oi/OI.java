package frc.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.constants.JoystickMap;

/**
 * WIP:
 * 
 * Driver Controller
 * 	Sticks:
 * 		Right Stick Y-axis 	= Drive Motor Throttle
 * 		Left Stick X-axis  	= Drive Motor Turn
 * 	Buttons:
 *      X Button            = Climbing mode (Toggle) - This should also change LED's
 * 	Bumpers/Triggers:
 * 		Left Bumper			= High Gear (Turbo)
 * 		Left Trigger 		= Climb Speed Up (Manual Control)
 * 		Right Trigger		= Climb Speed down (Manual Control) 
 *  Extras:
 *      Rumble              = Auto intaking
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
 *
 *
 */

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
