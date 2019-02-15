package frc.robot.constants;

public enum GamePiece {
    HATCH(0, 0, 0, 0, 0, 0), //TODO SET VALUES THIS IS REALLY IMPORTANT FOR SETELEVATORLEVELCOMMAND AND SETINTAKEELBOWCOMMAND()
    CARGO(0, 0, 0, 0, 0, 0), 
    NONE(0, 0, 0, 0, 0, 0);

    private int elevatorEncoderPosLvl_0;
    private int elevatorEncoderPosLvl_1;
    private int elevatorEncoderPosLvl_2;
    private int intakeElbowEncoderPosLvl_0;
    private int intakeElbowEncoderPosLvl_1;
    private int intakeElbowEncoderPosLvl_2;

    GamePiece(int elevatorEncoderPosLvl_0, int elevatorEncoderPosLvl_1, int elevatorEncoderPosLvl_2, int intakeElbowEncoderPosLvl_0, int intakeElbowEncoderPosLvl_1, int intakeElbowEncoderPosLvl_2) {
        this.elevatorEncoderPosLvl_0 = elevatorEncoderPosLvl_0;
        this.elevatorEncoderPosLvl_1 = elevatorEncoderPosLvl_1;
        this.elevatorEncoderPosLvl_2 = elevatorEncoderPosLvl_2;

        this.intakeElbowEncoderPosLvl_0 = intakeElbowEncoderPosLvl_0;
        this.intakeElbowEncoderPosLvl_1 = intakeElbowEncoderPosLvl_1;
        this.intakeElbowEncoderPosLvl_2 = intakeElbowEncoderPosLvl_2;
    }

    public int getElevatorEncoderPos(int level) {
        if(level == 0) {
            return elevatorEncoderPosLvl_0;
        } else if(level == 1) {
            return elevatorEncoderPosLvl_1;
        } else if(level == 2) {
            return elevatorEncoderPosLvl_2;
        } else {
            return 0; //TODO determine safe default encoder value
        }
    }

    public int getIntakeElbowEncoderPos(int level) {
        switch (level) {
            case 0:
                return this.intakeElbowEncoderPosLvl_0;
            case 1:
                return this.intakeElbowEncoderPosLvl_1;
            case 2:
                return this.intakeElbowEncoderPosLvl_2;
            default:
                return 0; //TODO determine safe default encoder value
        }
    }
}