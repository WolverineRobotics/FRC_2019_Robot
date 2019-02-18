package frc.robot.commands.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.GamePiece;
import frc.robot.constants.RobotConst;
import frc.robot.constants.RobotPIDValues;
import frc.robot.subsystems.IntakeSubsystem;
import frc.util.PID;

public class SetIntakeElbowCommand extends Command{
    

    private IntakeSubsystem c_intake = Robot.getIntakeSubsystem();

    private double deadBand = RobotConst.INTAKE_ELBOW_DEADBAND;

    private boolean isDone;
    private PID pid;

    /**
     * This command will automatically set the intake elbow level at the right tilt
     * For the game piece to be ejected
     * @param gamePiece Which game piece to eject
     * @param level Which level to eject the game piece
     */
    public SetIntakeElbowCommand(GamePiece gamePiece, int level){
        requires(c_intake);
        this.pid = new PID(RobotPIDValues.INTAKE_TILT_POSITION_KP, RobotPIDValues.INTAKE_TILT_POSITION_KI, RobotPIDValues.INTAKE_TILT_POSITION_KD, deadBand);
        pid.setDesiredValue(gamePiece.getElevatorEncoderPos(level));
        pid.setMaxOutput(1);
    }

    @Override
    public boolean isFinished(){
        return isDone;
    }

    @Override
    public void execute(){
        double power = pid.calcPID(c_intake.getRotateRawEncoderPosition());
        c_intake.setRotateRawSpeed(power);

        //UNTESTED
        int currentPos = c_intake.getRotateRawEncoderPosition();
        int desiredPos = (int) pid.getDesiredVal();
        int difference = Math.abs(currentPos - desiredPos);
        if(difference < deadBand) {
            isDone = true;
        }
        
    }
}