package frc.util;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Util{
    

    public static void addCommand(Command command1){
        Scheduler.getInstance().add(command1);
    }


    

}