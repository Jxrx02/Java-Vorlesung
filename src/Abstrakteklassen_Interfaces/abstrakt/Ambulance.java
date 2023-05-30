package Abstrakteklassen_Interfaces.abstrakt;

public class Ambulance extends Car {

	private boolean blauLicht;
	
	
	public boolean isBlauLicht() {
		return blauLicht;
	}


	public void setBlauLicht(boolean blauLicht) {
		this.blauLicht = blauLicht;
	}



	public Ambulance(double vCurrent,boolean light) {
		super(vCurrent);
		setBlauLicht(light);

	}
}
