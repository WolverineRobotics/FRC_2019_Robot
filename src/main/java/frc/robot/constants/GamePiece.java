package frc.robot.constants;

public enum GamePiece {
    HATCH(0, 0, 0), //TODO SET VALUES THIS IS REALLY IMPORTANT FOR SETELEVATORLEVELCOMMAND()
    CARGO(0, 0, 0), 
    NONE(0, 0, 0);

    private int encoderPosLvl_0;
    private int encoderPosLvl_1;
    private int encoderPosLvl_2;

    GamePiece(int encoderPosLvl_0, int encoderPosLvl_1, int encoderPosLvl_2) {
        this.encoderPosLvl_0 = encoderPosLvl_0;
        this.encoderPosLvl_1 = encoderPosLvl_1;
        this.encoderPosLvl_2 = encoderPosLvl_2;
    }

    public int getEncoderPos(int level) {
        if(level == 0) {
            return encoderPosLvl_0;
        } else if(level == 1) {
            return encoderPosLvl_1;
        } else if(level == 2) {
            return encoderPosLvl_2;
        } else {
            return 0;
        }
    }
}