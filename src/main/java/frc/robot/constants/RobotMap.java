package frc.robot.constants;

public class RobotMap {
    //********************************************************************************** 
    // Drive Subsystem
    //**********************************************************************************
    public static final int DRIVE_LEFT_MOTOR_MASTER_ADDRESS  = 0;
    public static final int DRIVE_LEFT_MOTOR_SLAVE_ADDRESS   = 1;
    public static final int DRIVE_RIGHT_MOTOR_MASTER_ADDRESS = 2;
    public static final int DRIVE_RIGHT_MOTOR_SLAVE_ADDRESS  = 3;

	public static final int DRIVE_PISTON_LEFT_SHIFT_FORWARD_ADDRESS	 = 0;
	public static final int DRIVE_PISTON_LEFT_SHIFT_REVERSE_ADDRESS  = 1;
	public static final int DRIVE_PISTON_RIGHT_SHIFT_FORWARD_ADDRESS = 2;
	public static final int DRIVE_PISTON_RIGHT_SHIFT_REVERSE_ADDRESS = 3;
    

    //********************************************************************************** 
    // Elevator Subsystem
    //**********************************************************************************   
    public static final int ELEVATOR_MOTOR_MASTER_ADDRESS = 4;
    public static final int ELEVATOR_MOTOR_SLAVE_ADDRESS  = 5;

    //********************************************************************************** 
    // Intake Subsystem
    //**********************************************************************************
    public static final int INTAKE_MOTOR_TILT_ADDRESS    = 6;
	public static final int INTAKE_MOTOR_ROLLERS_ADDRESS = 7;
	
	public static final int INTAKE_PISTON_CLAW_FORWARD_ADDRESS   	 = 4;
	public static final int INTAKE_PISTON_CLAW_REVERSE_ADDRESS   	 = 5;
	public static final int INTAKE_PISTON_KACHUNKER_FORWARD_ADDRESS  = 6;
	public static final int INTAKE_PISTON_KACHUNKER_REVERSE_ADDRESS  = 7;

    //********************************************************************************** 
    // Climb Subsystem
    //**********************************************************************************
    public static final int CLIMB_MOTOR_LIFT_ADDRESS  = 8;
    public static final int CLIMB_MOTOR_WHEEL_ADDRESS = 9;

    //********************************************************************************** 
    // Technical Subsystem
    //**********************************************************************************
    public static final int TECHNICAL_PDP_ADDRESS = 10;
	public static final int TECHNICAL_PCM_ADDRESS = 11;
	
	public static final int TECHNICAL_PDP_LDRIVE_MASTER   = 0;
	public static final int TECHNICAL_PDP_LDRIVE_SLAVE    = 1;
	public static final int TECHNICAL_PDP_RDRIVE_MASTER   = 2;
	public static final int TECHNICAL_PDP_RDRIVE_SLAVE    = 3;

	public static final int TECHNICAL_PDP_ELEVATOR_MASTER = 4;
	public static final int TECHNICAL_PDP_ELEVATOR_SLAVE  = 5;

	public static final int TECHNICAL_PDP_INTAKE_TILT     = 6;
	public static final int TECHNICAL_PDP_INTAKE_ROLLERS  = 7;

	public static final int TECHNICAL_PDP_CLIMB_LIFT      = 8;
    public static final int TECHNICAL_PDP_CLIMB_WHEEL     = 9;

    //********************************************************************************** 
    // Blinkin Subsystem
    //**********************************************************************************
    public static final int BLINKIN_PWM_PORT = 0;
}
