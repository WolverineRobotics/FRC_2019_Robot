package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;
import frc.robot.constants.RobotConst;

public class BlinkinSubsystem extends Subsystem {
    private Spark blinkin = new Spark(RobotMap.BLINKIN_PWM_PORT);

    @Override
    protected void initDefaultCommand() {

    }

    //********************************************************************************** 
    // Blinkin functions
    //********************************************************************************** 
    public void setLedStipColour(int colour)
    {
        switch(colour)
        {
            case RobotConst.LED_COLOUR_HOT_PINK:
            {
                blinkin.set(0.57);
                break;
            }
            case RobotConst.LED_COLOUR_DARK_RED:
            {
                blinkin.set(0.59);
                break;
            }
            case RobotConst.LED_COLOUR_RED:
            {
                blinkin.set(0.61);
                break;
            }
            case RobotConst.LED_COLOUR_RED_ORANGE:
            {
                blinkin.set(0.63);
                break;
            }
            case RobotConst.LED_COLOUR_ORANGE:
            {
                blinkin.set(0.65);
                break;
            }
            case RobotConst.LED_COLOUR_GOLD:
            {
                blinkin.set(0.67);
                break;
            }
            case RobotConst.LED_COLOUR_YELLOW:
            {
                blinkin.set(0.69);
                break;
            }
            case RobotConst.LED_COLOUR_LAWN_GREEN:
            {
                blinkin.set(0.71);
                break;
            }
            case RobotConst.LED_COLOUR_LIME:
            {
                blinkin.set(0.73);
                break;
            }
            case RobotConst.LED_COLOUR_DARK_GREEN:
            {
                blinkin.set(0.75);
                break;
            }
            case RobotConst.LED_COLOUR_GREEN:
            {
                blinkin.set(0.77);
                break;
            }
            case RobotConst.LED_COLOUR_BLUE_GREEN:
            {
                blinkin.set(0.79);
                break;
            }
            case RobotConst.LED_COLOUR_AQUA:
            {
                blinkin.set(0.81);
                break;
            }
            case RobotConst.LED_COLOUR_SKY_BLUE:
            {
                blinkin.set(0.83);
                break;
            }
            case RobotConst.LED_COLOUR_DARK_BLUE:
            {
                blinkin.set(0.85);
                break;
            }
            case RobotConst.LED_COLOUR_BLUE:
            {
                blinkin.set(0.87);
                break;
            }
            case RobotConst.LED_COLOUR_BLUE_VIOLET:
            {
                blinkin.set(0.89);
                break;
            }
            case RobotConst.LED_COLOUR_VIOLET:
            {
                blinkin.set(0.91);
                break;
            }
            case RobotConst.LED_COLOUR_WHITE:
            {
                blinkin.set(0.93);
                break;
            }
            case RobotConst.LED_COLOUR_GRAY:
            {
                blinkin.set(0.95);
                break;
            }
            case RobotConst.LED_COLOUR_DARK_GRAY:
            {
                blinkin.set(0.97);
                break;
            }
            case RobotConst.LED_COLOUR_BLACK:
            {
                blinkin.set(0.99);
                break;
            }
            default:
            {
                // Default is off (black)
                blinkin.set(0.99);
            }
        }
    }
}