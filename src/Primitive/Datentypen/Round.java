package Primitive.Datentypen;

public class Round {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double pi = 3.1415926; // Naeherung der Kreiszahl Pi
		double e = 2.7182818; // Naeherung der Eulerschen Zahl e
		
		int piInt = (int) (pi >0 ?pi+ 0.5:pi-0.5);
		int eInt = (int) (e + 0.5);
		
		
		System.out.println("Pi ganzzahlig: " + piInt); 
		System.out.println("e ganzzahlig: " + eInt); 

		
		
		
	}

}
