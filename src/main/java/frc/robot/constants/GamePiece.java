package frc.robot.constants;

/**
 * GamePiece enum:
 * Holds Elevator + Intake encoder positions for each rocket level,
 * as well as human player station.
 */

public enum GamePiece {

    HATCH(               // Elevator + IntakeRotate
            1488, -147,  // Level 1
            6800, -130,  // Level 2
            12500, -130, // Level 3
            1500, -130   // Player Station (Same as level 1)
            ),
    CARGO(               // Elevator + IntakeRotate
            4600, -161,  // Level 1
            7900, -112,  // Level 2
            12800, -78,  // Level 3
            0, 0         // Player Station (TODO)
            );

    private int elevator_1;
    private int intakeRotate_1;

    private int elevator_2;
    private int intakeRotate_2;

    private int elevator_3;
    private int intakeRotate_3;

    private int playerStationElevator;
    private int playerStationIntakeRotate;

    GamePiece(  
                /* Rocket Level 1 */
                int elevator_1, 
                int intakeRotate_1,

                /* Rocket Level 2 */
                int elevator_2, 
                int intakeRotate_2, 

                /* Rocket Level 3*/
                int elevator_3, 
                int intakeRotate_3, 

                /* Player Station Hatch*/
                int playerStationElevator,
                int playerStationIntakeRotate) {

        this.elevator_1 = elevator_1;
        this.intakeRotate_1 = intakeRotate_1;
        
        this.elevator_2 = elevator_2;
        this.intakeRotate_2 = intakeRotate_2;

        this.elevator_3 = elevator_3;
        this.intakeRotate_3 = intakeRotate_3;

        this.playerStationElevator = playerStationElevator;
        this.playerStationIntakeRotate = playerStationIntakeRotate;
        
    }

    public int getElevatorEncoderPos(int level) {
        switch (level) {
        case 1:
            return elevator_1;
        case 2:
            return elevator_2;
        case 3:
            return elevator_3;
        default:
            return 0; //default encoder position
        }
    }

    public int getIntakeRotateEncoderPos(int level) {
        switch (level) {
            case 1:
                return this.intakeRotate_1;
            case 2:
                return this.intakeRotate_2;
            case 3:
                return this.intakeRotate_3;
            default:
                return 0; //default encoder position
        }
    }

    // ****************************************************************
    // Cargo
    // ****************************************************************
    public int getElevatorPlayerStation() {
        return playerStationElevator;
    }

    public int getIntakeRotatePlayerStation() {
        return playerStationIntakeRotate;
    }
    
    
}