package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.GamePiece;
import frc.robot.constants.RobotPIDValues;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.util.PID;

public class SetElevatorLevelCommand extends Command {

    private PID pid;
    private double speed;
    private int desiredEncoderPos;
    private ElevatorSubsystem c_elevator = Robot.getElevatorSubsystem();
    private boolean isDone;

    public SetElevatorLevelCommand(GamePiece gamePiece, int level) {
        requires(c_elevator);
        pid = new PID(RobotPIDValues.ELEVATOR_POSITION_KP, RobotPIDValues.ELEVATOR_POSITION_KI, RobotPIDValues.ELEVATOR_POSITION_KD, 0);
        desiredEncoderPos = gamePiece.getElevatorEncoderPos(level);
        pid.setDesiredValue(desiredEncoderPos);
        isDone = false;
    }

    @Override
    public boolean isFinished() {
        return isDone;
    }

    @Override
    public void execute() {
        double currentPos = c_elevator.getRawEncoderPosition();
        speed = pid.calcPID(currentPos);
        c_elevator.setElevatorRawSpeed(speed);
        if(currentPos == desiredEncoderPos) { //TODO: see if position is NEAR (not completely equal)
            isDone = true;
        }
        
    }

    public void setFinished(boolean finished) {
        isDone = finished;
    }
}