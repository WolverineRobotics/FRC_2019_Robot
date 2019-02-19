package frc.robot.constants.blinkin;

public enum Colour {

    /**
     * This enum is for frc.robot.subsystems.BlinkinSubsystem and the commands within it.
     * Each enum holds an encoder value. See getValue()
     */

    HOT_PINK(0.57), DARK_RED(0.59), RED(0.61), RED_ORANGE(0.63), ORANGE(0.65), GOLD(0.67), YELLOW(0.69),
    LAWN_GREEN(0.71), LIME(0.73), DARK_GREEN(0.75), GREEN(0.77), BLUE_GREEN(0.79), AQUA(0.81), SKY_BLUE(0.83),
    DARK_BLUE(0.85), BLUE(0.87), BLUE_VIOLET(0.89), VIOLET(0.91), WHITE(0.93), GRAY(0.95), DARK_GRAY(0.97), BLACK(0.99);

    private double value;

    Colour(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

}