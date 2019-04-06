package frc.robot.commands.autonomousroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.autonomouscommands.AutoHatchDeliverCommand;
import frc.robot.commands.autonomouscommands.DriveDistanceCommand;
import frc.robot.commands.autonomouscommands.ExecuteAfterWaitCommand;
import frc.robot.commands.autonomouscommands.OpenClawCommand;
import frc.robot.commands.autonomouscommands.OpenShovelCommand;
import frc.robot.commands.autonomouscommands.RotateToHeadingCommand;
import frc.robot.commands.autonomouscommands.SetIntakeRotateCommand;
import frc.robot.commands.autonomouscommands.SimpleBackawayCommand;
import frc.robot.commands.commandgroups.ElevatorLevelCommandGroup;
import frc.robot.constants.GamePiece;
import frc.robot.oi.AutoSelector;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * Handles full sandstorm (autonomous)
 */

public class AutonomousCommandGroup extends CommandGroup{
    private String pos, action1, action2;

    private DriveSubsystem c_drive;
    private CameraSubsystem c_camera;
    private ElevatorSubsystem c_elevator;
    private IntakeSubsystem c_intake;
    private ClimbSubsystem c_climb;

    public AutonomousCommandGroup(){
        pos = AutoSelector.getPosition();
        action1 = AutoSelector.getFirstAction();
        action2 = AutoSelector.getSecondAction();

        c_drive = Robot.getDriveSubsystem();
        c_camera = Robot.m_camera;
        c_elevator = Robot.getElevatorSubsystem();
        c_intake = Robot.getIntakeSubsystem();
        c_climb = Robot.getClimbSubsystem();

        System.out.println("=================Starting Auto=================");
        System.out.println("position    : " + pos);
        System.out.println("1st action  : " + action1);
        System.out.println("2nd action  : " + action1);
        System.out.println("===============================================");
        
        addParallel(new SetIntakeRotateCommand(10, 1));
        addParallel(new OpenShovelCommand(false));
        addParallel(new ExecuteAfterWaitCommand(2, new OpenClawCommand(true)));

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
        } else if(pos == 1 || pos == 2 || pos == 3){
            System.out.println("Driving towards cargo ship position " + pos);
            if(pos == 1){
                addSequential(new DriveDistanceCommand(0.5, 188.8, 0, false));
            } else if(pos == 2){
                addSequential(new DriveDistanceCommand(0.5, 210.55, 0, false));
            } else if(pos ==3){
                addSequential(new DriveDistanceCommand(0.5, 210.55, 0, false));
            }
            
            System.out.println("Rotating to cargoship");
            addSequential(new RotateToHeadingCommand(270));
            addSequential(new ElevatorLevelCommandGroup(GamePiece.HATCH, 1));

            System.out.println("Delivering hatch");
            addSequential(new RotateToHeadingCommand(c_drive.getPigeonHeading() - c_camera.getDegreesOff()));
            addSequential(new AutoHatchDeliverCommand());

            System.out.println("Backing away");
            addParallel(new SetIntakeRotateCommand(0, 1));
            addSequential(new DriveDistanceCommand(0.5, -12, 90, false));

            System.out.println("Returning to alliance station");
            if(pos == 1){
                addSequential(new DriveDistanceCommand(0.5, 255, 201.23, true));
            } else if(pos == 2){
                addSequential(new DriveDistanceCommand(0.5, 285, 199.67, true));
            } else if(pos ==3){
                addSequential(new DriveDistanceCommand(0.5, 295, 198.25, true));
            }

            System.out.println("Finding player station");
            addSequential(new RotateToHeadingCommand(180));
            addSequential(new RotateToHeadingCommand(c_drive.getPigeonHeading() - c_camera.getDegreesOff()));

            System.out.println("retrieving hatch");
            addSequential(new AutoHatchDeliverCommand());
            addSequential(new OpenClawCommand(false));
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

    }

    private void rightRSC2(int level){

    }

    private void rightRSF2(int level){

    }
}