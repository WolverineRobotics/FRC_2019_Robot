package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.constants.JoystickMap;

public class OI {
    private static Joystick driver = new Joystick(JoystickMap.DRIVER_PORT);
    private static Joystick operator = new Joystick(JoystickMap.OPERATOR_PORT);

    public static double getLeftSpeed() {
        return driver.getRawAxis(JoystickMap.LEFT_STICK_Y);
    }

    public static double getRightSpeed() {
        return driver.getRawAxis(JoystickMap.RIGHT_STICK_Y);
    }

    public static boolean getTestButton() {
        return operator.getRawButton(JoystickMap.BUTTON_X);
    }
}
