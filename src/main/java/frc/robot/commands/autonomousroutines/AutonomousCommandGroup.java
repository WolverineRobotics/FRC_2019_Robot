package frc.robot.commands.autonomousroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.oi.AutoSelector;

public class AutonomousCommandGroup extends CommandGroup {

    public AutonomousCommandGroup() {
        String objective = AutoSelector.getObjective();
        String start = AutoSelector.getStartingPosition();

        switch(start){
            case AutoSelector.LEFT_LEVEL_1:
                leftPlatformAutonomous(objective);
                break;
            case AutoSelector.LEFT_LEVEL_2:
                leftHabAutonomous(objective);
                break;
            case AutoSelector.MIDDLE_LEVEL_1:
                middleAutonomous(objective);
                break;
            case AutoSelector.RIGHT_LEVEL_1:
                rightPlatformAutonomous(objective);
                break;
            case AutoSelector.RIGHT_LEVEL_2:
                rightHabAutonomous(objective);
                break;
            default:
                System.out.println("NO AUTO SELECTED ERROR!");
                break;
        }
    }

    private void leftPlatformAutonomous(String objective){
        switch(objective){
            case AutoSelector.CARGO_SHIP_FRONT:
            case AutoSelector.CARGO_SHIP_BOTH:
            case AutoSelector.CARGO_SHIP_SIDE:
            case AutoSelector.CARGO_SHIP_BACK:
            case AutoSelector.ROCKET:
            case AutoSelector.BASELINE:
            default:
            break;
        }
    }

    private void leftHabAutonomous(String objective){
        switch(objective){
            case AutoSelector.CARGO_SHIP_FRONT:
            case AutoSelector.CARGO_SHIP_BOTH:
            case AutoSelector.CARGO_SHIP_SIDE:
            case AutoSelector.CARGO_SHIP_BACK:
            case AutoSelector.ROCKET:
            case AutoSelector.BASELINE:
            default:
            break;
        }
    }

    private void middleAutonomous(String objective){
        switch(objective){
            case AutoSelector.CARGO_SHIP_FRONT:
            case AutoSelector.CARGO_SHIP_BOTH:
            case AutoSelector.CARGO_SHIP_SIDE:
            case AutoSelector.CARGO_SHIP_BACK:
            case AutoSelector.ROCKET:
            case AutoSelector.BASELINE:
            default:
            break;
        }
    }

    private void rightPlatformAutonomous(String objective){
        switch(objective){
            case AutoSelector.CARGO_SHIP_FRONT:
            case AutoSelector.CARGO_SHIP_BOTH:
            case AutoSelector.CARGO_SHIP_SIDE:
            case AutoSelector.CARGO_SHIP_BACK:
            case AutoSelector.ROCKET:
            case AutoSelector.BASELINE:
            default:
            break;
        }
    }

    private void rightHabAutonomous(String objective){
        switch(objective){
            case AutoSelector.CARGO_SHIP_FRONT:
            case AutoSelector.CARGO_SHIP_BOTH:
            case AutoSelector.CARGO_SHIP_SIDE:
            case AutoSelector.CARGO_SHIP_BACK:
            case AutoSelector.ROCKET:
            case AutoSelector.BASELINE:
            default:
            break;
        }
    }

    //********************************************************************************** 
    // left auto front cargo ship
    //**********************************************************************************
    private void left1front(){

    }

    private void left2front(){

    }

    //********************************************************************************** 
    // left auto both cargo ship
    //**********************************************************************************
    private void left1both(){

    }

    private void left2both(){

    }

    //********************************************************************************** 
    // left auto side cargo ship
    //**********************************************************************************
    private void left1side(){

    }

    private void left2side(){

    }

    //********************************************************************************** 
    // left auto back cargo ship
    //**********************************************************************************
    private void left1back(){

    }

    private void left2back(){

    }

    //********************************************************************************** 
    // left auto rocket
    //**********************************************************************************
    private void left1rocket(){

    }

    private void left2rocket(){

    }

    
    //********************************************************************************** 
    // right auto front cargo ship
    //**********************************************************************************
    private void right1front(){

    }

    private void right2front(){

    }

    //********************************************************************************** 
    // right auto both cargo ship
    //**********************************************************************************
    private void right1both(){

    }

    private void right2both(){

    }

    //********************************************************************************** 
    // right auto side cargo ship
    //**********************************************************************************
    private void right1side(){

    }

    private void right2side(){

    }

    //********************************************************************************** 
    // right auto back cargo ship
    //**********************************************************************************
    private void right1back(){

    }

    private void right2back(){

    }

    //********************************************************************************** 
    // right auto rocket
    //**********************************************************************************
    private void right1rocket(){

    }

    private void right2rocket(){
        
    }

    
    //********************************************************************************** 
    // middle auto front cargo ship
    //**********************************************************************************
    private void middle1front(){

    }

    private void middle2front(){

    }

    //********************************************************************************** 
    // middle auto both cargo ship
    //**********************************************************************************
    private void middle1both(){

    }

    private void middle2both(){

    }

    //********************************************************************************** 
    // middle auto side cargo ship
    //**********************************************************************************
    private void middle1side(){

    }

    private void middle2side(){

    }

    //********************************************************************************** 
    // middle auto back cargo ship
    //**********************************************************************************
    private void middle1back(){

    }

    private void middle2back(){

    }

    //********************************************************************************** 
    // middle auto rocket
    //**********************************************************************************
    private void middle1rocket(){

    }

    private void middle2rocket(){
        
    }
}