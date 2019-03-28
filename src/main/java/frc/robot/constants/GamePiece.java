package frc.robot.constants;

public enum GamePiece {
    HATCH(1500, 6800, 12500, -130, -130, -130, 0),
    CARGO(4600, 7900, 12800, -161, -112, -78, 0);

    private int elevatorEncoderPosLvl_1;
    private int elevatorEncoderPosLvl_2;
    private int elevatorEncoderPosLvl_3;
    
    private int intakeRotateEncoderPosLvl_1;
    private int intakeRotateEncoderPosLvl_2;
    private int intakeRotateEncoderPosLvl_3;

    GamePiece(int elevatorEncoderPosLvl_1, int elevatorEncoderPosLvl_2, int elevatorEncoderPosLvl_3, int intakeElbowEncoderPosLvl_1, int intakeElbowEncoderPosLvl_2, int intakeElbowEncoderPosLvl_3, int humanStation) {
        this.elevatorEncoderPosLvl_1 = elevatorEncoderPosLvl_1;
        this.elevatorEncoderPosLvl_2 = elevatorEncoderPosLvl_2;
        this.elevatorEncoderPosLvl_3 = elevatorEncoderPosLvl_3;

        this.intakeRotateEncoderPosLvl_1 = intakeElbowEncoderPosLvl_1;
        this.intakeRotateEncoderPosLvl_2 = intakeElbowEncoderPosLvl_2;
        this.intakeRotateEncoderPosLvl_3 = intakeElbowEncoderPosLvl_3;
    }

    public int getElevatorEncoderPos(int level) {
        switch (level) {
        case 1:
            return elevatorEncoderPosLvl_1;
        case 2:
            return elevatorEncoderPosLvl_2;
        case 3:
            return elevatorEncoderPosLvl_3;
        default:
            return RobotConst.ELEVATOR_SAFE_LEVEL_HEIGHT;
        }
    }

    public int getIntakeRotateEncoderPos(int level) {
        switch (level) {
            case 1:
                return this.intakeRotateEncoderPosLvl_1;
            case 2:
                return this.intakeRotateEncoderPosLvl_2;
            case 3:
                return this.intakeRotateEncoderPosLvl_3;
            default:
                return RobotConst.INTAKE_ROTATE_ENCODER_MAXIMUM;
        }
    }
}