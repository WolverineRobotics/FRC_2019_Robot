package frc.robot.commands.autonomousfunctions;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ElevatorSubsystem;

public class SetElevatorCommand extends Command {

    private ElevatorSubsystem c_elevator;
    private int desiredEncoderPos;

    private boolean goingUp;
    private boolean isDone;

    public SetElevatorCommand(int desiredEncoderPos) {
        c_elevator = Robot.getElevatorSubsystem();
        requires(c_elevator);
        this.desiredEncoderPos = desiredEncoderPos;
    }

    @Override
    protected void initialize() {
        if(c_elevator.getEncoderRawCounts() < desiredEncoderPos){
            isDone = false;
            goingUp = false;

            c_elevator.setElevatorRawSpeed(-1);
        } else
        if(c_elevator.getEncoderRawCounts() > desiredEncoderPos){
            isDone = false;
            goingUp = true;

            c_elevator.setElevatorRawSpeed(1);
        } else {
            isDone = true;
        }
    }

    @Override
    protected void execute() {
        int actual = c_elevator.getEncoderRawCounts();
        if(goingUp){
            if(actual < desiredEncoderPos){
                isDone = true;
            }
        } else {
            if(actual > desiredEncoderPos){
                isDone = true;
            }
        }

        // SmartDashboard.putNumber("[Elevator] position error!", error);
    
    }

    @Override
    protected void end() {
        c_elevator.setElevatorRawSpeed(0);
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

}