package frc.robot.oi;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.constants.JoystickMap;
import frc.robot.constants.RobotConst;
import frc.util.Util;

/**
 * Driver Controller
 * 	Sticks:
 * 		Right Stick X-axis 	= Drive Motor Turn
 * 		Left Stick Y-axis  	= Drive Motor Throttle
 * 	Buttons:
 *      A Button            = 
 *      B Button            = Disables Climbing Mode (Climb Wheel Disabled, Unlocks Climb Lock)
 *      X Button            = 
 *      Y Button            = Enables Climbing Mode (Climb Wheel Enabled, Brings Elevator to 0, Locks Climb Lock)
 * 
 * 	Bumpers/Triggers:
 * 		Left Trigger 		= Climb Speed down (Manual Control)
 * 		Right Trigger		= Climb Speed up (Manual Control) 
 *      Right Bumper        = Fine Control
 *  Extras:
 *      Rumble              = Operator is intaking
 *      Select              = Cancel Command
 * 
 * Operator Controller
 * 	Sticks:
 * 		Left Stick Y-axis  	= Elevator Motor Speed (Manual Control)
 * 		Right Stick Y-axis	= Intake Rotate Motor Speed (Manual Control)
 * 	Buttons:
 *      A Button            = 1st Elevator Level
 *      B Button            = 2nd Elevator Level
 *      X Button            = Player Station Cargo Level
 * 		Y Button			= 3rd Elevator Level
 * 	Bumpers/Triggers:
 * 		Left Bumper 		= Activate Shovel
 * 		Right Bumper		= Activate Claw
 *  POV:
 *      Forward (0)         = Manual outtake ball
 *      Backward (180)      = Manual intake ball
 *      Extras:
 *      Select              = Cancel Command
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
        return Util.setDeadzoneLimits(driver.getRawAxis(JoystickMap.RIGHT_STICK_X), RobotConst.DRIVE_TURN_TRIGGER_VALUE);
    }

    /**
     * Driver throttle stick
     * 
     * Left stick y
     * @return double from -1 to 1
     */
    public static double getDriverThrottle() {
        return Util.setDeadzoneLimits(driver.getRawAxis(JoystickMap.LEFT_STICK_Y), RobotConst.DRIVE_THORTTLE_TRIGGER_VALUE);
    }

    /**
     * Driver request cargo
     * A Button
     * @return True when button released (toggle)
     */
    public static boolean getDriverRequestCargoLED() {
        return driver.getRawButton(JoystickMap.BUTTON_A);
    }
    
    /**
     * Driver request hatch
     * X Button
     * @return True when button released (toggle)
     */
    public static boolean getDriverAutoAlign() {
        return driver.getRawButton(JoystickMap.BUTTON_X);
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
    public static boolean getDriverClimbState() {
        return driver.getRawButtonPressed(JoystickMap.BUTTON_Y);
    }

    /**
     * Manual climb down
     * Left trigger
     * @return double from 0 to 1
     */
    public static double getDriverClimbSpeedDown() {
        return Util.setDeadzoneLimits(driver.getRawAxis(JoystickMap.LEFT_TRIGGER), RobotConst.CLIMB_THROTTLE_TRIGGER_VALUE);

    }
    
    /**
     * Manuel climb up
     * Right trigger
     * @return double from 0 to 1
     */
    public static double getDriverClimbSpeedUp() {
        return Util.setDeadzoneLimits(driver.getRawAxis(JoystickMap.RIGHT_TRIGGER), RobotConst.CLIMB_THROTTLE_TRIGGER_VALUE);
    }

    /**
     * Set driver controller rumble
     * @param rumble rumble intensity
     */
    public static void driverRumble(double rumble) {
        driver.setRumble(RumbleType.kLeftRumble, rumble);
        driver.setRumble(RumbleType.kRightRumble, rumble);
    }

    /**
     * Get driver fine control
     * Right bumper
     * @return button press
     */
    public static boolean getFineControl(){
        return driver.getRawButton(JoystickMap.BUTTON_RIGHT_BUMPER);
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
        return Util.setDeadzoneLimits(operator.getRawAxis(JoystickMap.LEFT_STICK_Y), RobotConst.ELEVATOR_LEFT_STICK_Y_TRIGGER_VALUE);
    }

    /**
     * Operator intake tilt speed
     * Right stick y
     * @return double from -1 to 1
     */
    public static double getOperatorIntakeRotate() {
        return Util.setDeadzoneLimits(-operator.getRawAxis(JoystickMap.RIGHT_STICK_Y), RobotConst.ELEVATOR_RIGHT_STICK_Y_TRIGGER_VALUE);
    }

    /**
     * Operator manual ball intake
     * POV backward
     * @return True when being pressed;
     */
    public static boolean getOperatorIntakeIn() {
        return (
            operator.getPOV() == JoystickMap.POV_SOUTH ||
            operator.getPOV() == JoystickMap.POV_SOUTH_EAST ||
            operator.getPOV() == JoystickMap.POV_SOUTH_WEST
        );
    }

    /**
     * Operator manual ball outake
     * POV forward
     * @return True when being pressed
     */
    public static boolean getOperatorIntakeOut() {
        return (
            operator.getPOV() == JoystickMap.POV_NORTH ||
            operator.getPOV() == JoystickMap.POV_NORTH_EAST ||
            operator.getPOV() == JoystickMap.POV_NORTH_WEST
        );
    }

    /**
     * Operator auto ground hatch
     * Right trigger
     * @return True when being pressed
     */
    public static boolean getOperatorAutoHatch() {
        return operator.getRawAxis(JoystickMap.RIGHT_TRIGGER) > 0.2;
    }

    /**
     * Operator engage claw
     * Right bumper
     * @return True when being pressed
     */
    public static boolean getOperatorClaw() {
        return operator.getRawButtonPressed(JoystickMap.BUTTON_RIGHT_BUMPER);
    }

    /**
     * Operator engage shovel
     * Left bumper
     * @return True when being pressed
     */
    public static boolean getOperatorShovel() {
        return operator.getRawButtonPressed(JoystickMap.BUTTON_LEFT_BUMPER);
    }
    
    /**
     * Operator deliver level 1
     * Button A
     * @return True once pressed
     */
    public static boolean getOperatorElevatorLevel1() {
        return operator.getRawButton(JoystickMap.BUTTON_A);
    }

    /**
     * Operator deliver level 2
     * Button B
     * @return True once pressed
     */
    public static boolean getOperatorElevatorLevel2() {
        return operator.getRawButton(JoystickMap.BUTTON_B);
    }

    /**
     * Operator auto intake
     * Button X
     * @return True once pressed
     */
    public static boolean getOperatorPlayerStationBall() {
        return operator.getRawButton(JoystickMap.BUTTON_X);
    }

    /**
     * Operator deliver level 3
     * Button Y
     * @return True once pressed
     */
    public static boolean getOperatorElevatorLevel3() {
        return operator.getRawButton(JoystickMap.BUTTON_Y);
    }
  
    public static void driverRumble(boolean toRumble) {
        if(toRumble) {
            driver.setRumble(RumbleType.kLeftRumble, RobotConst.RUMBLE_INTENSITY);
            driver.setRumble(RumbleType.kRightRumble, RobotConst.RUMBLE_INTENSITY);
            operator.setRumble(RumbleType.kLeftRumble, RobotConst.RUMBLE_INTENSITY);
            operator.setRumble(RumbleType.kRightRumble, RobotConst.RUMBLE_INTENSITY);
        } else {
            driver.setRumble(RumbleType.kLeftRumble, 0);
            driver.setRumble(RumbleType.kRightRumble, 0);
            operator.setRumble(RumbleType.kLeftRumble, 0);
            operator.setRumble(RumbleType.kRightRumble, 0);
        }
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