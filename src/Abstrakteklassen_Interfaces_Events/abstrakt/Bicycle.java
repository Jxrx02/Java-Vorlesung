package Abstrakteklassen_Interfaces_Events.abstrakt;

public class Bicycle extends Vehicle {

	public void info(){
		System.out.println("Bicycle: \n vMax: " + this.vMax + " AnzRäder:" + this.AnzRäder + " Pos:" + this.getPosition());
	}


	public Bicycle(double vCurrent) {
		// TODO Auto-generated constructor stub
		super(vCurrent);
		this.vMax=30;
		
		this.AnzRäder=2;

	}
}
