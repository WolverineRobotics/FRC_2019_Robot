package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.GamePiece;
import frc.robot.subsystems.ElevatorSubsystem;

public class SetElevatorLevelCommand extends Command {

    private ElevatorSubsystem c_elevator;

    private boolean isDone;
    private int desiredEncoderPos;

    public SetElevatorLevelCommand(GamePiece gamePiece, int level) {
        c_elevator = Robot.getElevatorSubsystem();
        requires(c_elevator);
        this.desiredEncoderPos = gamePiece.getElevatorEncoderPos(level);
    }

    @Override
    protected void execute() {
        int currentPos = c_elevator.getEncoderRawCounts();
        if(currentPos < desiredEncoderPos) { //current pos is below desired pos
            c_elevator.setElevatorRawSpeed(0.4 /* RobotConst.ELEVATOR_SAFE_SPEED */); //go up
        } else if(currentPos > desiredEncoderPos) { //current pos is above desired pos
            c_elevator.setElevatorRawSpeed(-0.4 /* RobotConst.ELEVATOR_SAFE_SPEED */); //go down
        }
        if(Math.abs(desiredEncoderPos - currentPos) < 3 /* RobotConst.ELEVATOR_ENCODER_DEADBAND*/) { //TODO add dead band so if the encoder pos is NEARLY at our desired encoder pos, it'll be done. NEEDS TESTING
            isDone = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return isDone;
    }

}