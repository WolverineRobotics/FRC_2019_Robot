package frc.robot.oi;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.constants.JoystickMap;
import frc.robot.constants.RobotConst;

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
 *  Extras:
 *      Rumble              = Operator is intaking
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
        double throttle = driver.getRawAxis(JoystickMap.LEFT_STICK_Y);
        if (throttle > 1) {
            throttle = 1;
        } else if(throttle < -1) {
            throttle = -1;
        }
        return throttle;
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
    public static boolean getDriverRequestionHatchLED() {
        return driver.getRawButton(JoystickMap.BUTTON_X);
    }
    
    /**
     * Driver cancel request
     * Button B
     * @return True when button released (toggle)
     */
    public static boolean getDriverCancel() {
        return driver.getRawButton(JoystickMap.BUTTON_B);
    }
    
    /**
     * Driver climb state
     * Button Y
     * @return True when button released (toggle)
     */
    public static boolean getDriverClimbState() {
        return driver.getRawButton(JoystickMap.BUTTON_Y);
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

    //********************************************************************************** 
    // Operator controls
    //**********************************************************************************
    /**
     * Operator elevator speed
     * Left stick y
     * @return double from -1 to 1
     */
    public static double getOperatorElevatorSpeed() {
        double val = operator.getRawAxis(JoystickMap.LEFT_STICK_Y);

        if(Math.abs(val) > RobotConst.ELEVATOR_LEFT_STICK_Y_TRIGGER_VALUE){
            return val;
        } else {
            return -0.07;
        }
    }

    /**
     * Operator intake tilt speed
     * Right stick y
     * @return double from -1 to 1
     */
    public static double getOperatorIntakeRotate() {
        return -operator.getRawAxis(JoystickMap.RIGHT_STICK_Y);
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

    public static boolean getOperatorAutoHatch() {
        return operator.getRawButton(JoystickMap.BUTTON_SELECT);
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