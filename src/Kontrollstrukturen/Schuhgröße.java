package Kontrollstrukturen;

public class Schuhgröße {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double z=0;
		double z_old=0;
		int g=30;
		
		System.out.printf("%10s |%10s","Zentimeter","Größe\n");
		System.out.println("-----------------------------------");
		
		for(int i=0;i<20;i++) {
			
			z = (g)/1.5;
			z_old = (g-1)/1.5;
			System.out.printf("\n %3.2f-%3.2f|%3d",z_old,z, g);
			g++;

		}
	}

}
