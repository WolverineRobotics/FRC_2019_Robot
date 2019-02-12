package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultTechnicalCommand;

public class TechnicalSubsystem extends Subsystem {
    private PowerDistributionPanel pdp = new PowerDistributionPanel();

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultTechnicalCommand());
    }

    public void clearStickys(){
        pdp.clearStickyFaults();
    }

    public double getPdpTemperature(){
        return pdp.getTemperature();
    }

    public double getPdpVoltage(){
        return pdp.getVoltage();
    }

    public double getCurrentDraw(){
        return pdp.getTotalCurrent();
    }

    public double getCurrentDraw(int channel){
        return pdp.getCurrent(channel);
    }

    public double getPowerDraw(){
        return pdp.getTotalPower();
    }

    public double getEnergyDraw(){
        return pdp.getTotalEnergy();
    }
    
}