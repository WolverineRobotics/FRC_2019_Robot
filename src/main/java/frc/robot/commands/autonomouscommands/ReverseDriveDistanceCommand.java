package frc.robot.commands.autonomouscommands;

/**
 * ReverseDriveDistanceCommand
 */
public class ReverseDriveDistanceCommand extends DriveDirectionCommand{
    double distance;

    boolean brakeWhenFinished;

    public ReverseDriveDistanceCommand(double power, double distance, double heading, boolean brakeWhenFinished){
        super(power, heading);

        this.distance = -distance;
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
        return c_drive.getDistance() < distance;
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