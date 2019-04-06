package frc.robot.commands.autonomousroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.AutoHatchDeliverCommand;
import frc.robot.commands.autonomouscommands.DriveDirectionCommand;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.ExecuteAfterWaitCommand;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.commands.autonomouscommands.SimpleBackawayCommand;
import frc.robot.commands.commandgroups.ElevatorLevelCommandGroup;
import frc.robot.constants.GamePiece;
import frc.robot.oi.AutoSelector;

/**
 * Handles full sandstorm (autonomous)
 */

public class AutonomousCommandGroup extends CommandGroup{
    private String pos, action1, action2;

    public AutonomousCommandGroup(){
        pos = AutoSelector.getPosition();
        action1 = AutoSelector.getFirstAction();
        action2 = AutoSelector.getSecondAction();

        System.out.println("=================Starting Auto=================");
        System.out.println("position    : " + pos);
        System.out.println("1st action  : " + action1);
        System.out.println("2nd action  : " + action1);
        System.out.println("===============================================");
        
        addSequential(new OpenShovelCommand(false)); //close shovel
        addSequential(new ExecuteAfterWaitCommand(5, new OpenClawCommand(true))); //after 5 seconds, open claw

        if(pos == AutoSelector.POS_LEFT){
            switch(action1){
                case AutoSelector.CS_FRONT:
                leftCS1(0);
                break;

                case AutoSelector.CS_SIDE1:
                leftCS1(1);
                break;

                case AutoSelector.CS_SIDE2:
                leftCS1(2);
                break;

                case AutoSelector.CS_SIDE3:
                leftCS1(3);
                break;

                case AutoSelector.RS_CLOSE1:
                leftRSC1(1);
                break;

                case AutoSelector.RS_CLOSE2:
                leftRSC1(2);
                break;

                case AutoSelector.RS_CLOSE3:
                leftRSC1(3);
                break;

                case AutoSelector.RS_FAR1:
                leftRSF1(1);
                break;
                
                case AutoSelector.RS_FAR2:
                leftRSF1(2);
                break;
                
                case AutoSelector.RS_FAR3:
                leftRSF1(3);
                break;

                default:
                break;
            }
        } else 
        if(pos == AutoSelector.POS_RIGHT){
            switch(action1){
                case AutoSelector.CS_FRONT:
                rightCS1(0);
                break;

                case AutoSelector.CS_SIDE1:
                rightCS1(1);
                break;

                case AutoSelector.CS_SIDE2:
                rightCS1(2);
                break;

                case AutoSelector.CS_SIDE3:
                rightCS1(3);
                break;

                case AutoSelector.RS_CLOSE1:
                rightRSC1(1);
                break;

                case AutoSelector.RS_CLOSE2:
                rightRSC1(2);
                break;

                case AutoSelector.RS_CLOSE3:
                rightRSC1(3);
                break;

                case AutoSelector.RS_FAR1:
                rightRSF1(1);
                break;
                
                case AutoSelector.RS_FAR2:
                rightRSF1(2);
                break;
                
                case AutoSelector.RS_FAR3:
                rightRSF1(3);
                break;

                default:
                break;
            }
        }

        if(pos == AutoSelector.POS_LEFT){
            switch(action2){
                case AutoSelector.CS_FRONT:
                leftCS2(0);
                break;

                case AutoSelector.CS_SIDE1:
                leftCS2(1);
                break;

                case AutoSelector.CS_SIDE2:
                leftCS2(2);
                break;

                case AutoSelector.CS_SIDE3:
                leftCS2(3);
                break;

                case AutoSelector.RS_CLOSE1:
                leftRSC2(1);
                break;

                case AutoSelector.RS_CLOSE2:
                leftRSC2(2);
                break;

                case AutoSelector.RS_CLOSE3:
                leftRSC2(3);
                break;

                case AutoSelector.RS_FAR1:
                leftRSF2(1);
                break;

                case AutoSelector.RS_FAR2:
                leftRSF2(2);
                break;
                
                case AutoSelector.RS_FAR3:
                leftRSF2(3);
                break;

                default:
                break;
            }
        } else 
        if(pos == AutoSelector.POS_RIGHT){
            switch(action1){
                case AutoSelector.CS_FRONT:
                rightCS2(0);
                break;

                case AutoSelector.CS_SIDE1:
                rightCS2(1);
                break;

                case AutoSelector.CS_SIDE2:
                rightCS2(2);
                break;

                case AutoSelector.CS_SIDE3:
                rightCS2(3);
                break;

                case AutoSelector.RS_CLOSE1:
                rightRSC2(1);
                break;

                case AutoSelector.RS_CLOSE2:
                rightRSC2(2);
                break;

                case AutoSelector.RS_CLOSE3:
                rightRSC2(3);
                break;

                case AutoSelector.RS_FAR1:
                rightRSF2(1);
                break;
                
                case AutoSelector.RS_FAR2:
                rightRSF2(2);
                break;
                
                case AutoSelector.RS_FAR3:
                rightRSF2(3);
                break;

                default:
                break;
            }
        }
    }

    //********************************************************************************** 
    // first action left
    //**********************************************************************************
    private void leftCS1(int pos){
        if(pos == 0){
            /* 
             * front hatch
             */
        } else {
        }
    }

    private void leftRSC1(int level){

    }

    private void leftRSF1(int level){

    }

    //********************************************************************************** 
    // second action left
    //**********************************************************************************
    private void leftCS2(int pos){

    }

    private void leftRSC2(int level){

    }

    private void leftRSF2(int level){

    }

    //********************************************************************************** 
    // first action right
    //**********************************************************************************
    private void rightCS1(int pos){
        if(pos == 0){
            /* 
             * front hatch
             */
        } else if(pos == 1 || pos == 2 || pos == 3){ //if 1 2 or 3
            System.out.println("driving towards cargo ship position " + pos);
            addParallel(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1));
            if(pos == 1){
                addSequential(new DriveDistanceCommand(0.5, 188.8, 0, false));
            } else if(pos == 2){
                addSequential(new DriveDistanceCommand(0.5, 210.55, 0, false));
            } else if(pos ==3){
                addSequential(new DriveDistanceCommand(0.5, 210.55, 0, false));
            }
            
            System.out.println("rotating to cargoship");
            addParallel(new DriveDistanceCommand(0.5, 10, 90, true));
            addSequential(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1));

            System.out.println("delivering hatch");
            addSequential(new AutoHatchDeliverCommand()); //already contains drive

            System.out.println("backing away");
            addSequential(new ExecuteAfterWaitCommand(1, new SimpleBackawayCommand(1, 0.5)));

        }
    }

    private void rightRSC1(int level){

    }

    private void rightRSF1(int level){

    }

    //********************************************************************************** 
    // second action right
    //**********************************************************************************
    private void rightCS2(int pos){

        System.out.println("backing up from player station " );
        addSequential(new DriveDistanceCommand(-0.5, -10, 0, false));
        double angle1;
        double distanceDiagonal;


        if (pos==1){
            angle1 = 197.4;
            distanceDiagonal = 253.7;
        }else if(pos==2){
            angle1 = 196.1;
            distanceDiagonal = 273.8;
        }else{
            angle1 = 194.9;
            distanceDiagonal = 295.0;
        }

        System.out.println("rotating");
        addSequential(new RotateToHeadingCommand(angle1));

        System.out.println("reversing towards cargo ship position " + pos);
        addSequential(new DriveDistanceCommand(-0.5, -distanceDiagonal, 0, false));

        System.out.println("rotating to cargoship");
        addSequential(new RotateToHeadingCommand(90));

        System.out.println("delivering hatch");
        addSequential(new AutoHatchDeliverCommand());

        System.out.println("backing away");
        addSequential(new ExecuteAfterWaitCommand(1, new SimpleBackawayCommand(1, 0.5)));


    }

    private void rightRSC2(int level){

    }

    private void rightRSF2(int level){

    }
}