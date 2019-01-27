package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.constants.JoystickMap;

public class OI {
    private static Joystick driver = new Joystick(JoystickMap.DRIVER_PORT);
    private static Joystick operator = new Joystick(JoystickMap.OPERATOR_PORT);

    public static double getTurn() {
        return driver.getRawAxis(JoystickMap.LEFT_STICK_X);
    }

    public static double getSpeed() {
        return driver.getRawAxis(JoystickMap.RIGHT_STICK_Y);
    }
}
