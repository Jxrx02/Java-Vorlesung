package polymorphie;

public class Vehicle {

	protected int AnzRäder = 0;
	protected double vMax = 0;
	protected double position;
	
	private double vCurrent;							
	protected double getvCurrent() {
		return this.vCurrent;
	}
	protected void setvCurrent(double pvCurrent) {
		if(vCurrent >= vMax)
			this.vCurrent = this.vMax;
		else
			this.vCurrent = pvCurrent;
	}
	   public double getPosition() {
	       return position;
	   }

	   public void setPosition(double position) {
	       this.position = position;
	   }
	
	protected void drive(double minutes) {
		
	    if (this.getvCurrent()>0.0)   // Bedingung eigentlich sinnlos!
	           setPosition(this.position + (this.getvCurrent() * minutes / 60));
	
	}
	
   
	
	public Vehicle() {}
	public Vehicle(double vCurrent) {
		setvCurrent(vCurrent);
		this.vCurrent = vCurrent;		

	}

	   public String toString() {
	       return this.getClass().getSimpleName()+" mit "+
	               this.AnzRäder+" Rädern an Position "+
	               this.getPosition()+" mit v="+this.getvCurrent()+" km/h.";        
	   }

	
	
}
