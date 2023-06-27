package A_21_22_Abstrakteklassen_Interfaces_Events.abstrakt;

public class Simulation {


	/**
	 *
	 * @abstrakte Klasse mit Methode info() in Vehicle
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehicle[] vehicles = new Vehicle[4];
		
		vehicles[0] = new Bicycle(20);
		vehicles[1] = new Car(150.0);
		vehicles[2] = new RacingCar(200.0);
		vehicles[3] = new Ambulance(80.0,true);
				
		vehicles[0].drive(240);
		
		for (int i = 0; i < vehicles.length; i++) {
			vehicles[i].drive(60);
		}

		// Output Race
		System.out.println("Infomethode: ");

		for (int i = 0; i < vehicles.length; i++) {
			System.out.println(vehicles[i].toString());

			vehicles[i].info();
		}
		((Ambulance) vehicles[3]).setBlauLicht(true);


	}

}
