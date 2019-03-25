package frc.robot.commands.autonomouscommands;

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
        this.goingUp = false;
        this.isDone = false;
    }

    @Override
    protected void initialize() {
        int currentEncoderPos = c_elevator.getEncoderPosition();
        if(currentEncoderPos < desiredEncoderPos) { //
            goingUp = false;
            c_elevator.setElevatorRawSpeed(-1);
        } else if(currentEncoderPos > desiredEncoderPos){
            goingUp = true;
            c_elevator.setElevatorRawSpeed(1);
        } else {
            isDone = true;
        }
    }

    @Override
    protected void execute() {
        int currentEncoderPos = c_elevator.getEncoderPosition();
        if(goingUp){
            if(currentEncoderPos < desiredEncoderPos){
                isDone = true;
            }
        } else {
            if(currentEncoderPos > desiredEncoderPos){
                isDone = true;
            }
        }
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