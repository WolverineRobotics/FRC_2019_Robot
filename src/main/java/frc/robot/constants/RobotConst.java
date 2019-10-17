package frc.robot.constants;

public class RobotConst {
    //********************************************************************************** 
    // Drive constants
    //**********************************************************************************
    public static final double DRIVE_TURN_TRIGGER_VALUE = 0.10;
    public static final double DRIVE_THORTTLE_TRIGGER_VALUE = 0.20;

    public static final double DRIVE_SPEED_REDUCTION_RATIO = 0.80;
    
    public static final double DRIVE_ENCODER_COUNTS_PER_INCH = 12.92;
    //********************************************************************************** 
    // Elevator constants
    //**********************************************************************************
    public static double ELEVATOR_RIGHT_STICK_Y_TRIGGER_VALUE = 0.20;
    public static double ELEVATOR_LEFT_STICK_Y_TRIGGER_VALUE = 0.20;

        public static final int ELEVATOR_SOFT_MIN_ENCODER_DISTANCE = 100;
        public static final int ELEVATOR_SOFT_MAX_ENCODER_DISTANCE = 1000;
        public static final double ELEVATOR_SOFT_LIMIT_MULTIPLE = 0.7;

    
    //********************************************************************************** 
    // Intake constants
    //**********************************************************************************
    public static final double INTAKE_ROTATE_TRIGGER_VALUE = 0.20;

    //********************************************************************************** 
    // Climb constants
    //**********************************************************************************
    public static final double CLIMB_THROTTLE_TRIGGER_VALUE = 0.05;

    //TODO: Set Encoder Positions
    public static final int CLIMB_SOFT_MIN_ENCODER_DISTANCE = -10000;
    public static final int CLIMB_SOFT_MAX_ENCODER_DISTANCE = -30;
    public static final double CLIMB_SOFT_LIMIT_MULTIPLE = 0.5;
    public static final int CLIMB_HARD_MAX_ENCODER_DISTANCE = 1;
    public static final int CLIMB_HARD_MIN_ENCODER_DISTANCE = 2;
    


    //********************************************************************************** 
    // Misc constants
    //**********************************************************************************
    public static final double RUMBLE_INTENSITY = 0.80;

}