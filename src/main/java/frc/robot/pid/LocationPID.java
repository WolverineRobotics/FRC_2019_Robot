package frc.robot.pid;


public class LocationPID extends GyroPID{
    private LocationCalculatorCurved locationCalc;
    

    public LocationPID(double kP){
        super(kP);
    }

    public LocationPID(double kP, double kI){
        super(kP, kI);
    }

    public LocationPID(double kP, double kI, double kD){
        super(kP, kI, kD);
    }

    // Must be called before starting
    public void initialize(double startingDistance, double startingHeading){
        this.locationCalc = new LocationCalculatorCurved(startingDistance, startingHeading, 0.75);
        setEnabled(true);
    }

    public double getDistance(){
        double[] distanceDirection = locationCalc.getDistanceDirection();
        return distanceDirection[0];
    }

    // Use getDistance to determine distance
    public double calculate(double currentGyroAngle, double distanceChange) {
        locationCalc.update(distanceChange, currentGyroAngle);
        double[] distanceDirection = locationCalc.getDistanceDirection();
        setSetpoint(distanceDirection[1]);
        return super.calculate(currentGyroAngle);
    }
}