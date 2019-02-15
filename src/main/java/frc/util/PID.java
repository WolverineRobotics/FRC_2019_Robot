package frc.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PID  {
    private double kP;
	private double kI;
	private double kD;
	private double targetValue;
	protected double prevError;
	private double sumError;
	protected double finishedRange;
    private double maxOutput;
    private double minOutput;
	private int minCycleCount;
	private int currentCycleCount;
	private boolean firstCycle;
	private boolean resetI;
	protected boolean debug;
	
	public PID(double p, double i, double d, double epsRange){
		this.kP = p;
		this.kI = i;
		this.kD = d;
		this.finishedRange = epsRange; 
		this.resetI = true;
		this.targetValue = 0.0;
		this.firstCycle = true;
		this.maxOutput = 1.0;
		this.currentCycleCount = 0;
		this.minCycleCount = 5;
		this.debug = false;
		
	}
	
	public void setConstants(double p,double i, double d){
		this.kP = p;
		this.kI = i;
		this.kD = d;
	}
	
	public void setDesiredValue(double val) {
        this.targetValue = val;
    }
	
	public void setFinishedRange(double range){
		this.finishedRange = range;
	}
	
	public void disableIReset(){
		this.resetI = false;
	}
	
	public void enableIReset(){
		this.resetI = true;
	}
	
	public void enableDebug(){
		this.debug = true;
	}
	
	public void disableDebug(){
		this.debug = false;
	}
	
	public void setMaxOutput(double max) {
        if(max < 0.0) {
            this.maxOutput = 0.0;
        } else if(max > 1.0) {
            this.maxOutput = 1.0;
        } else {
            this.maxOutput = max;
        }
    }

    public void setMinOutput(double min) { //khalil, i did this. -jeremy
        if(min > 0.0) {
            this.minOutput = 0.0;
        } else if(min < -1.0) {
            this.minOutput = -1.0;
        } else {
            this.minOutput = min;
        }
    }
    
    public void setMinDoneCycles(int num) {
        this.minCycleCount = num;
    }
    
    public void resetErrorSum() {
        this.sumError = 0.0;
    }
    
    public double getDesiredVal() {
        return this.targetValue;
    }
    
        
    public double calcPID(double current) {
    	return calcPIDError(this.targetValue - current);
    }
	
    private double calcPIDError (double error){
    	double pVal = 0.0;
        double iVal = 0.0;
        double dVal = 0.0;
        
        if(this.firstCycle) {
            this.prevError = error;
            this.firstCycle = false;
        }
        
        ///////P Calc///////
        pVal = this.kP * error;
        
        ///////I Calc///////
        if(Math.abs(pVal) >= 1.0){ // P output is >= 1.0 which means we are very far away
        	this.sumError = 0.0;
        }else if(Math.abs(error) <= this.finishedRange){ // within range
        	if(this.resetI){
        		this.sumError = 0.0;
        	}else{
        		//this.errorSum += error; //maybe we need this? 
        	}
        }else if(pVal > 0.0){ // going forward
        	if(this.sumError < 0.0){ // we were going backwards
        		this.sumError = 0.0;
        	}
        	 this.sumError += error; 
        }else{ // going backwards
        	if(this.sumError > 0.0){ // we were going forward
        		this.sumError = 0.0;
        	}
        	 this.sumError += error; 
        }
        
        iVal = this.kI * this.sumError;
        
        ///////D Calc///////
        double deriv = error - this.prevError;
        dVal = this.kD * deriv;
        
        //overal PID calc
        double output = pVal + iVal + dVal;
        
        //limit the output
        if(output > this.maxOutput) {
            output = this.maxOutput;
        } else if(output < -this.maxOutput) {
            output = -this.maxOutput;
        }
        
        //store current value as previous for next cycle
        this.prevError = error;
        
        if(this.debug) {
        	SmartDashboard.putNumber("P out", pVal);
        	SmartDashboard.putNumber("I out", iVal);
        	SmartDashboard.putNumber("D out", dVal);
        	SmartDashboard.putNumber("PID OutPut", output);
        }
        return output;
    }
    
    public boolean isDone() {
        double currError = Math.abs(this.prevError);
        
        //close enough to target
        if(currError <= this.finishedRange) {
            this.currentCycleCount++;
        }
        //not close enough to target
        else {
            this.currentCycleCount = 0;
        }
        
        return this.currentCycleCount > this.minCycleCount;
    }
    
    public boolean getFirstCycle(){
    	return this.firstCycle;
    }
    
    public void resetPreviousVal() {
        this.firstCycle = true;
    } 
}