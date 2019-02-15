package frc.robot.oi;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.constants.JoystickMap;
import frc.robot.constants.RobotConst;

/**
 * Driver Controller
 * 	Sticks:
 * 		Right Stick Y-axis 	= Drive Motor Turn
 * 		Left Stick X-axis  	= Drive Motor Throttle
 * 	Buttons:
 *      A Button            = Requesting Cargo - Blink between ORANGE and WHITE
 *      B Button            = Default - Static RED
 *      X Button            = Requesting Hatch - Blink between YELLOW and WHITE 
 *      Y Button            = Climbing LEDs - Blink between AQUA and WHITE
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
    public static double getDriverTurn() { //returns -1 to 1 on left stick X axis
        return driver.getRawAxis(JoystickMap.RIGHT_STICK_X);
    }
    public static double getDriverThrottle() { //returns -1 to 1 on right stick Y axis
        return driver.getRawAxis(JoystickMap.LEFT_STICK_Y);
    }
    public static boolean getDriverRequestCargoLED() { //returns true if A was released
        return driver.getRawButtonReleased(JoystickMap.BUTTON_A);
    }
    public static boolean getDriverCancel() { //returns true if B was released
        return driver.getRawButtonReleased(JoystickMap.BUTTON_B);
    }
    public static boolean getDriverRequestionHatchLED() { //returns true if X was released
        return driver.getRawButtonReleased(JoystickMap.BUTTON_X);
    }
    public static boolean getDriverClimbing() { //returns true if Y was released
        return driver.getRawButtonReleased(JoystickMap.BUTTON_Y);
    }
    public static boolean getDriverClimbSpeedDown() { //returns true if LEFT TRIGGER was pushed
        return driver.getRawButtonPressed(JoystickMap.LEFT_TRIGGER);
    }
    public static boolean getDriverClimbSpeedUp() { //returns true if RIGHT TRIGGER was pushed
        return driver.getRawButtonPressed(JoystickMap.RIGHT_TRIGGER);
    }

    //********************************************************************************** 
    // Operator controls
    //**********************************************************************************
    public static double getOperatorElevatorSpeed(){ //returns -1 to 1 double on LEFT STICK Y axis
        return operator.getRawAxis(JoystickMap.LEFT_STICK_Y);
    }

    public static double getOperatorIntakeTilt() { //returns -1 to 1 double on RIGHT STICK Y axis. 
        return operator.getRawAxis(JoystickMap.RIGHT_STICK_Y);
    }

    public static boolean getOperatorIntakeIn() { //returns true if LEFT TRIGGER is pushed
        return operator.getRawButtonPressed(JoystickMap.LEFT_TRIGGER);
    }

    public static boolean getOperatorIntakeOut() { //returns true if RIGHT TRIGGER is pushed
        return operator.getRawButtonPressed(JoystickMap.RIGHT_TRIGGER);
    }

    public static boolean getOperatorEjectHatch() { //returns true if LEFT BUMPER is released
        return operator.getRawButtonReleased(JoystickMap.BUTTON_LEFT_BUMPER);
    }
    
    public static boolean getOperatorGrabHatch() { //returns true if RIGHT BUMPER is released
        return operator.getRawButtonReleased(JoystickMap.BUTTON_RIGHT_BUMPER);
    }

    public static boolean getOperatorElevatorBase() { //returns true if BUTTON A is released
        return operator.getRawButtonReleased(JoystickMap.BUTTON_A);
    }

    public static boolean getOperatorElevatorLevel2() { //returns true if BUTTON B is released
        return operator.getRawButtonReleased(JoystickMap.BUTTON_B);
    }

    public static boolean getOperatorElevatorLevel3() { //returns true if BUTTON Y is released
        return operator.getRawButtonReleased(JoystickMap.BUTTON_Y);
    }


    public static void driverRumble(boolean rumble) {
        if(rumble) {
            driver.setRumble(RumbleType.kLeftRumble, RobotConst.RUMBLE_INTENSITY);
            driver.setRumble(RumbleType.kRightRumble, RobotConst.RUMBLE_INTENSITY);
        } else {
            driver.setRumble(RumbleType.kLeftRumble, 0);
            driver.setRumble(RumbleType.kRightRumble, 0);
        }
    }
}

