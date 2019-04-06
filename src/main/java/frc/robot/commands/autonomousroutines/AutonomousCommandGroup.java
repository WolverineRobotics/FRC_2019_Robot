package frc.robot.commands.autonomousroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.autonomouscommands.AutoHatchDeliverCommand;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.DriveTowardsVisionTargetCommand;
import frc.robot.commands.autonomouscommands.ExecuteAfterWaitCommand;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.commands.autonomouscommands.RotateToVisionTargetCommand;
import frc.robot.commands.autonomouscommands.SetElevatorCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.commands.autonomouscommands.SimpleBackawayCommand;
import frc.robot.commands.commandgroups.AutomaticZeroCommandGroup;
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
            addSequential(new AutoHatchDeliverCommand()); //already contains drive towards vision

            System.out.println("backing away");
            addSequential(new ExecuteAfterWaitCommand(1, new SimpleBackawayCommand(1, 0.5)));

        }
    }

    /**
     * Right Rocket ship close hatch 1
     */
    private void rightRSC1(int level){
        if(level == 1 || level == 2 || level == 3) {
            // Drive up to the rocket
            addSequential(new DriveDistanceCommand(0.5, 50, 0, false));
            addSequential(new RotateToHeadingCommand(315)); //(45 degrees on a clock)
            addSequential(new DriveDistanceCommand(0.6, 137.2, 45, false));
            if(level == 1) {
                addSequential(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1));
            } else if (level == 2) {
                addSequential(new ElevatorLevelCommandGroup(GamePiece.HATCH, 2));
            } else if (level == 3) {
                //danger zone don't wanna do anything here yet. :)
            }
            // deliver hatch, contains drive to vision targets
            addSequential(new AutoHatchDeliverCommand());

            //go to player station
            addSequential(new SimpleBackawayCommand(10, 0.4));
            addSequential(new RotateToHeadingCommand(180));
            addSequential(new DriveDistanceCommand(0.5, 195, 180, true));
            addParallel(new OpenClawCommand(true));
            addParallel(new OpenShovelCommand(true));
            addParallel(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1));
            addSequential(new DriveTowardsVisionTargetCommand(2));
        }
    }

    private void rightRSF1(int level){
        if(level == 1 || level == 2 || level == 3) {
            //Drive up to rocket
            addSequential(new DriveDistanceCommand(0.5, 212.80 + 10, 0, false)); //drive towards rocket
            addSequential(new RotateToHeadingCommand(270)); //rotate 90 degrees to right
            addParallel(new SetElevatorCommand(6000, 0.40)); //make space for camera to get targets
            addParallel(new SetIntakeRotateCommand(20, 0.40)); //make space for camera to get targets
            addSequential(new RotateToHeadingCommand(225)); //look towards far side hatch
            addSequential(new DriveDistanceCommand(0.3, 55.95 + 5, 225, true)); //drve a little towards  rocket
            addSequential(new RotateToVisionTargetCommand());
            if(level == 1)  {
                addSequential(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1));
            } else if(level == 2) {
                //semi danger zone
            } else {
                //danger zone
            }
            addSequential(new AutoHatchDeliverCommand()); //contains driving towarsd vision target
            
            //going back to player station
            addSequential(new SimpleBackawayCommand(27, 0.50)); //back away so the hatch is applied
            addSequential(new AutomaticZeroCommandGroup()); //zero intake and elevator
            addParallel(new OpenShovelCommand(true)); //open shovel
            addParallel(new OpenClawCommand(true)); //open claw
            addParallel(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1)); //ready to get hatch from player station
            addSequential(new DriveDistanceCommand(0.60, 201.13 + 5, 180, false)); //drive distance to player station
            addSequential(new DriveTowardsVisionTargetCommand(3)); //at right side player station
        }
    }

    //********************************************************************************** 
    // second action right
    //**********************************************************************************
    
    private void rightCS2(int pos){

    }

    /**
     * Assuming from player station ready to grab hatch
     */
    private void rightRSC2(int level){
        addSequential(new OpenClawCommand(false)); //close claw to latch hatch
        addSequential(new SimpleBackawayCommand(10, 0.45)); //back away from player station
        addSequential(new OpenShovelCommand(false)); //latch hatch
    }

    /**
     * Assuming from player station ready to grab hatch
     */
    private void rightRSF2(int level){
        addSequential(new OpenClawCommand(false)); //close claw to latch hatch
        addSequential(new SimpleBackawayCommand(10, 0.45)); //back away from player station
        addSequential(new OpenShovelCommand(false)); //grab hatch even more

    }
}