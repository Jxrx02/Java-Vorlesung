package Abstrakteklassen_Interfaces.abstrakt;

public class Car extends Vehicle {

	public void info(){
		System.out.println("Car: \n vMax: " + this.vMax + " AnzRäder:" + this.AnzRäder + " Pos:" + this.getPosition());
	}


	public Car(double vCurrent) {
		super(vCurrent);
		this.vMax=140;

		this.AnzRäder=4;

	}
}
