package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeSubsystem;

public class DefaultIntakeCommand extends Command {

    private IntakeSubsystem c_intake;

    public DefaultIntakeCommand() {
        c_intake = Robot.getIntakeSubsystem();
        requires(c_intake);
    }

    @Override
    protected void execute() {
        //Rotate
        double rotateSpeed = OI.getOperatorIntakeTilt();
        if(Math.abs(rotateSpeed) > 0.2) { //TODO add robot const trigger vals. if greater than trigger values
            c_intake.setRotateRawSpeed(rotateSpeed*0.5); //set rotate speed to half
        } else {
            c_intake.setRotateRawSpeed(0);
        }

        //Rollers
        boolean intakeIn = OI.getOperatorIntakeIn(); 
        boolean intakeOut = OI.getOperatorIntakeOut();
        if(intakeIn) {
            c_intake.setRollersRawSpeed(1);
        } else if(intakeOut) {
            c_intake.setRollersRawSpeed(-1);
        } else {
            c_intake.setRollersRawSpeed(0);
        }

        //Kachunker
        if(OI.getOperatorKachunk()) {
            c_intake.setKachunker(Value.kForward);
        } else {
            c_intake.setKachunker(Value.kReverse);
        }
        
        //Booper
        if(OI.getOperatorBooper()) {
            c_intake.setBooper(Value.kForward);
        } else {
            c_intake.setBooper(Value.kReverse);
        }
    }

    /**
     * Default commands never finish.
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

}