package Abstrakteklassen_Interfaces_Events.abstrakt;

public class Ambulance extends Car {

	private boolean blauLicht;
	
	
	public boolean isBlauLicht() {
		return blauLicht;
	}


	public void setBlauLicht(boolean blauLicht) {
		this.blauLicht = blauLicht;
	}

	public void info(){
		System.out.println("Ambulance: \n vMax: " + this.vMax + " Blaulicht: " + blauLicht   + " AnzRäder:" + this.AnzRäder + " Pos:" + this.getPosition() );
	}

	public Ambulance(double vCurrent, boolean light) {
		super(vCurrent);
		setBlauLicht(light);

	}
}
