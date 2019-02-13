package frc.robot.constants;

public enum LEDCombo {

    REQUEST_HATCH(Colour.WHITE, Colour.HOT_PINK), 
    REQUEST_CARGO(Colour.WHITE, Colour.ORANGE), 
    CLIMBING(Colour.AQUA, Colour.WHITE),
    STATIC_RED(Colour.RED, null),
    NONE(null, null);

    private Colour colour1;
    private Colour colour2;

    LEDCombo(Colour colour1, Colour colour2) {
        this.colour1 = colour1;
        this.colour2 = colour2;
    }

    public Colour getColour1() {
        return this.colour1;
    }

    public Colour getColour2() {
        return this.colour2;
    }

}