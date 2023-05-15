package Kontrollstrukturen;

public class Einmaleins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Einmaleins: \n");
		
		for(int i =1; i <=10;i++) {
			for(int j =1; j<=10;j++) {
				System.out.printf("%3d ", i*j);
			}
			System.out.println();
		}
	}

}
