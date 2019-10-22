package frc.robot.commands.autonomouscommands;

public class DriveDistanceCommand extends DriveDirectionCommand {
    double distance;

    boolean brakeWhenFinished;

    public DriveDistanceCommand(double power, double distance, double heading, boolean brakeWhenFinished){
        super(power, heading);

        this.distance = distance;
        this.brakeWhenFinished = brakeWhenFinished;
    }

    @Override
    protected void initialize() {
    	super.initialize();

    	c_drive.resetEncoders();
    }
    
    @Override
    protected boolean isFinished() {
        // System.out.println("Distance: " + c_drive.getDistance());
        if (this.power > 0){
            return c_drive.getDistance() > distance;
        } else if (this.power < 0){
            return c_drive.getDistance() < distance;
        }
        return true;
        
    }

    @Override
    protected void end() {
    	super.end();
        System.out.println("Finished drive distance command at " + c_drive.getDistance());
        if(brakeWhenFinished){
            c_drive.setRawSpeeds(0, 0);
        }
    }

    public void setDistance(double distance){
        this.distance = distance;
    }
}