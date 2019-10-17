package frc.robot.constants;

public class RobotMap {
    //********************************************************************************** 
    // CAN Addresses
    //**********************************************************************************
    public static final int TECHNICAL_PCM_MAIN_ADDRESS              = 14;
    public static final int TECHNICAL_PDP_ADDRESS                   = 15;

    public static final int DRIVE_LEFT_MOTOR_MASTER_ADDRESS         = 1;
    public static final int DRIVE_LEFT_MOTOR_SLAVE_ADDRESS          = 2;
    public static final int DRIVE_RIGHT_MOTOR_MASTER_ADDRESS        = 3;
    public static final int DRIVE_RIGHT_MOTOR_SLAVE_ADDRESS         = 4;
    public static final int DRIVE_PIGEON_IMU_ADDRESS                = 12;
    
    public static final int ELEVATOR_MOTOR_MASTER_ADDRESS           = 7;
    public static final int ELEVATOR_MOTOR_SLAVE_ADDRESS            = 8;
    
    public static final int INTAKE_MOTOR_ROLLERS_ADDRESS            = 5;
    public static final int INTAKE_MOTOR_ROTATE_ADDRESS             = 9;
    
    public static final int CLIMB_MOTOR_WHEEL_ADDRESS               = 6;
    public static final int CLIMB_MOTOR_LIFT_ADDRESS                = 10;

    public static final int VISION_LED_RING                         = 11;
    //********************************************************************************** 
    // PCM Pneumatics Addresses
    //**********************************************************************************
    public static final int INTAKE_CLAW_FORWARD_ADDRESS             = 0;
    public static final int INTAKE_CLAW_REVERSE_ADDRESS             = 1;
    public static final int INTAKE_PISTON_CLAW_PCM_MODULE_ADDRESS   = TECHNICAL_PCM_MAIN_ADDRESS;

    public static final int INTAKE_PISTON_SHOVEL_FORWARD_ADDRESS    = 2;
    public static final int INTAKE_PISTON_SHOVEL_REVERSE_ADDRESS    = 3;
	public static final int INTAKE_PISTON_SHOVEL_PCM_MODULE_ADDRESS = TECHNICAL_PCM_MAIN_ADDRESS;

	public static final int CLIMB_LOCK_FORWARD_ADDRESS              = 4;
    public static final int CLIMB_LOCK_REVERSE_ADDRESS              = 5;
    public static final int CLIMB_LOCK_PCM_ADDRESS                  = TECHNICAL_PCM_MAIN_ADDRESS;

    //**********************************************************************************
    // PDP Port Addresses
    //**********************************************************************************
	public static final int TECHNICAL_PDP_LDRIVE_MASTER             = 0;
	public static final int TECHNICAL_PDP_LDRIVE_SLAVE              = 1;
	public static final int TECHNICAL_PDP_RDRIVE_MASTER             = 2;
	public static final int TECHNICAL_PDP_RDRIVE_SLAVE              = 3;

	public static final int TECHNICAL_PDP_ELEVATOR_MASTER           = 4;
	public static final int TECHNICAL_PDP_ELEVATOR_SLAVE            = 5;

	public static final int TECHNICAL_PDP_INTAKE_TILT               = 6;
	public static final int TECHNICAL_PDP_INTAKE_ROLLERS            = 7;

	public static final int TECHNICAL_PDP_CLIMB_LIFT                = 8;
    public static final int TECHNICAL_PDP_CLIMB_WHEEL               = 9;
    
    public static final int TECHNICAL_PDP_BLNIKIN                   = 10;
    public static final int TECHNICAL_PDP_LED_RING                  = 11;

    public static final int TECHNICAL_PDP_AUX_VRM                   = 12;
    public static final int TECHNICAL_PDP_AUX_PCM                   = 13;

    //**********************************************************************************
    // DIO Addresses
    //**********************************************************************************
    public static final int ELEVATOR_ENCODER_A                      = 0;
	public static final int ELEVATOR_ENCODER_B                      = 1;

    public static final int INTAKE_ROTATE_ENCODER_A                 = 2;
    public static final int INTAKE_ROTATE_ENCODER_B                 = 3;
    
    public static final int DRIVE_RIGHT_ENCODER_A                   = 4;
    public static final int DRIVE_RIGHT_ENCODER_B                   = 5;
    
    public static final int DRIVE_LEFT_ENCODER_A                    = 6;
    public static final int DRIVE_LEFT_ENCODER_B                    = 7;

    public static final int CLIMB_LIFT_ENCODER_A                    = 8; 
    public static final int CLIMB_LIFT_ENCODER_B                    = 9; 

    public static final int INTAKE_BALL_SENSOR_ADDRESS              = 10;

    public static final int ULTRASONIC                              = 0;
    
    //**********************************************************************************
    // PWM Addresses
    //**********************************************************************************
    public static final int BLINKIN_PWM_PORT                        = 0;
}