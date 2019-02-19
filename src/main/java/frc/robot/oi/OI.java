package frc.robot.oi;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.constants.JoystickMap;

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
 * 
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
 * 		Right Stick Y-axis	= Intake Elbow Motor Speed (Manual Control)
 * 	Buttons:
 *      A Button            = 1st Level
 *      B Button            = 2nd Level
 *      X Button            = Auto Intake
 * 		Y Button			= 3rd Level
 * 	Bumpers/Triggers:
 * 		Left Bumper 		= Close Claw (toggle default open claw)
 * 		Right Bumper		= Kachunk Kachunker (toggle default kachink)
 *  POV:
 *      Forward (0)         = Manual outtake ball
 *      Backward (180)      = Manual intake ball
 */

public class OI {
    private static Joystick driver = new Joystick(JoystickMap.DRIVER_PORT);
    private static Joystick operator = new Joystick(JoystickMap.OPERATOR_PORT);

    //********************************************************************************** 
    // Driver control
    //**********************************************************************************

    /**
     * Driver turning stick
     * 
     * Right stick x
     * @return double from -1 to 1
     */
    public static double getDriverTurn() {
        return driver.getRawAxis(JoystickMap.RIGHT_STICK_X);
    }

    /**
     * Driver throttle stick
     * 
     * Left stick y
     * @return double from -1 to 1
     */
    public static double getDriverThrottle() {
        return driver.getRawAxis(JoystickMap.LEFT_STICK_Y);
    }

    /**
     * Driver request cargo
     * A Button
     * @return True when button released (toggle)
     */
    public static boolean getDriverRequestCargoLED() {
        return driver.getRawButtonReleased(JoystickMap.BUTTON_A);
    }
    
    /**
     * Driver request hatch
     * X Button
     * @return True when button released (toggle)
     */
    public static boolean getDriverRequestionHatchLED() {
        return driver.getRawButtonPressed(JoystickMap.BUTTON_X);
    }
    
    /**
     * Driver cancel request
     * Button B
     * @return True when button released (toggle)
     */
    public static boolean getDriverCancel() {
        return driver.getRawButtonPressed(JoystickMap.BUTTON_B);
    }
    
    /**
     * Driver climb state
     * Button Y
     * @return True when button released (toggle)
     */
    public static boolean getDriverClimbing() {
        return driver.getRawButtonPressed(JoystickMap.BUTTON_Y);
    }

    /**
     * Manual climb down
     * Left trigger
     * @return double from 0 to 1
     */
    public static double getDriverClimbSpeedDown() {
        return driver.getRawAxis(JoystickMap.LEFT_TRIGGER);
    }
    
    /**
     * Manuel climb up
     * Right trigger
     * @return double from 0 to 1
     */
    public static double getDriverClimbSpeedUp() {
        return driver.getRawAxis(JoystickMap.RIGHT_TRIGGER);
    }

    /**
     * Set driver controller rumble
     * @param rumble rumble intensity
     */
    public static void driverRumble(double rumble) {
        driver.setRumble(RumbleType.kLeftRumble, rumble);
        driver.setRumble(RumbleType.kRightRumble, rumble);
    }

    //********************************************************************************** 
    // Operator controls
    //**********************************************************************************
    /**
     * Operator elevator speed
     * Left stick y
     * @return double from -1 to 1
     */
    public static double getOperatorElevatorSpeed() {
        return operator.getRawAxis(JoystickMap.LEFT_STICK_Y);
    }

    /**
     * Operator intake tilt speed
     * Right stick y
     * @return double from -1 to 1
     */
    public static double getOperatorIntakeTilt() {
        return operator.getRawAxis(JoystickMap.RIGHT_STICK_Y);
    }

    /**
     * Operator manual ball intake
     * POV backward
     * @return True when being pressed;
     */
    public static boolean getOperatorIntakeIn() {
        return operator.getPOV() == JoystickMap.POV_SOUTH;
    }

    /**
     * Operator manual ball outake
     * POV forward
     * @return True when being pressed
     */
    public static boolean getOperatorIntakeOut() {
        return operator.getPOV() == JoystickMap.POV_NORTH;
    }

    /**
     * Operator kachunk
     * Right bumper
     * @return True when being pressed
     */
    public static boolean getOperatorKachunk() {
        return operator.getRawButton(JoystickMap.BUTTON_RIGHT_BUMPER);
    }

    /**
     * Operator close claw
     * Left bumper
     * @return True when being pressed
     */
    public static boolean getOperatorClaw() {
        return operator.getRawButton(JoystickMap.BUTTON_LEFT_BUMPER);
    }
    
    /**
     * Operator deliver level 1
     * Button A
     * @return True once pressed
     */
    public static boolean getOperatorElevatorLevel1() {
        return operator.getRawButtonPressed(JoystickMap.BUTTON_A);
    }

    /**
     * Operator deliver level 2
     * Button B
     * @return True once pressed
     */
    public static boolean getOperatorElevatorLevel2() {
        return operator.getRawButtonPressed(JoystickMap.BUTTON_B);
    }

    /**
     * Operator deliver level 3
     * Button Y
     * @return True once pressed
     */
    public static boolean getOperatorElevatorLevel3() { //returns true if BUTTON Y is released
        return operator.getRawButtonPressed(JoystickMap.BUTTON_Y);
    }

    /**
     * @return instance of driver
     */
    public static Joystick getDriver() {
        return driver;
    }

    /**
     * @return instance of operator
     */
    public static Joystick getOperator() {
        return operator;
    }
}