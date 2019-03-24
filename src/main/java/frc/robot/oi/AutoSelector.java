package frc.robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class AutoSelector {
    private static SendableChooser<String> startPosition;
    private static SendableChooser<String> objective;

    public static String LEFT_LEVEL_1 = "L1";
    public static String LEFT_LEVEL_2 = "L2";
    public static String MIDDLE_LEVEL_1 = "M1";
    public static String RIGHT_LEVEL_1 = "R1";
    public static String RIGHT_LEVEL_2 = "R2";

    public static String ROCKET = "r";
    public static String CARGO_SHIP = "c";
    public static String BASELINE = "b";

    static {
        LEFT_LEVEL_1 = "L1";
        LEFT_LEVEL_2 = "L2";
        MIDDLE_LEVEL_1 = "M1";
        RIGHT_LEVEL_1 = "R1";
        RIGHT_LEVEL_2 = "R2";
        startPosition = new SendableChooser<>();

        startPosition.setDefaultOption("Left level 1", LEFT_LEVEL_1);
        startPosition.addOption("Left level 2", LEFT_LEVEL_2);
        startPosition.addOption("Middle", MIDDLE_LEVEL_1);
        startPosition.addOption("Right level 1", RIGHT_LEVEL_1);
        startPosition.addOption("Right level 2", RIGHT_LEVEL_2);

        objective = new SendableChooser<>();
        objective.setDefaultOption("Baseline", BASELINE);
        objective.addOption("Cargo ship", CARGO_SHIP);
        objective.addOption("Rocket", ROCKET);
    }

    public static String getStartingPosition(){
        return startPosition.getSelected();
    }

    public static String getObjective(){
        return objective.getSelected();
    }
    

}