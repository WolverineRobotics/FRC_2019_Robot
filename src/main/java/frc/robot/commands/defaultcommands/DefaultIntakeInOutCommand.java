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
        boolean intakeIn = OI.getOperatorIntakeIn();
        boolean intakeOut = OI.getOperatorIntakeOut();
        if(!(intakeIn && intakeOut)) { //Precaution: makes sure both aren't pressed at the same time
            if(intakeIn) {
                c_intakeInOut.activate(true);
                OI.driverRumble(true);
            } else {
                c_intakeInOut.activate(false);
                OI.driverRumble(false);
            }
        }
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
}