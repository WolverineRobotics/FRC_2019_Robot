package frc.robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoSelector {
    private static SendableChooser<String> startPosition;
    private static SendableChooser<String> objective;

    //starting positions
    public static final String LEFT_LEVEL_1 = "L1";
    public static final String LEFT_LEVEL_2 = "L2";
    public static final String MIDDLE_LEVEL_1 = "M1";
    public static final String RIGHT_LEVEL_1 = "R1";
    public static final String RIGHT_LEVEL_2 = "R2";

    //objectives
    public static final String ROCKET = "r";
    public static final String CARGO_SHIP_FRONT = "c1";
    public static final String CARGO_SHIP_BOTH = "c2";
    public static final String CARGO_SHIP_SIDE = "c3";
    public static final String CARGO_SHIP_BACK = "c4";

    public static final String BASELINE = "b";

    static {
        startPosition = new SendableChooser<>();

        startPosition.setDefaultOption("Left level 1", LEFT_LEVEL_1);
        startPosition.addOption("Left level 2", LEFT_LEVEL_2);
        startPosition.addOption("Middle", MIDDLE_LEVEL_1);
        startPosition.addOption("Right level 1", RIGHT_LEVEL_1);
        startPosition.addOption("Right level 2", RIGHT_LEVEL_2);

        objective = new SendableChooser<>();
        objective.setDefaultOption("Baseline", BASELINE);
        objective.addOption("Cargo ship 2 front hatches", CARGO_SHIP_FRONT);
        objective.addOption("Cargo ship 2 close side hatches", CARGO_SHIP_SIDE);
        objective.addOption("Cargo ship 2 far side hatches", CARGO_SHIP_BACK);
        objective.addOption("Cargo ship 1 front 1 side hatch", CARGO_SHIP_BOTH);
        objective.addOption("Rocket bottom 2", ROCKET);

        SmartDashboard.putData(startPosition);
        SmartDashboard.putData(objective);
    }

    public static String getStartingPosition(){
        return startPosition.getSelected();
    }

    public static String getObjective(){
        return objective.getSelected();
    }
    

}