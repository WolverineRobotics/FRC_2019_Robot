package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.oi.OI;
import frc.robot.subsystems.IntakeInOutSubsystem;

public class DefaultIntakeInOutCommand extends Command {
    private IntakeInOutSubsystem c_intakeInOut = Robot.getIntakeInOutSubsystem();

    public DefaultIntakeInOutCommand() {
        requires(c_intakeInOut);
    }
    @Override
    public void execute() {
        boolean intakeIn = OI.getOperatorIntakeIn(); //if operator is pressing left trigger
        boolean intakeOut = OI.getOperatorIntakeOut(); //if operator is perssing right trigger
        if(!(intakeIn && intakeOut)) { //Precaution: makes sure both aren't pressed at the same time
            if(intakeIn) {
                c_intakeInOut.cargoIntakeIn(true);
            } else if(intakeOut) {
                c_intakeInOut.cargoIntakeOut(true);
            }
        }
    }
    
    /**
     * Default commands don't finish
     */
    @Override
    public boolean isFinished() {
        return false;
    }
}