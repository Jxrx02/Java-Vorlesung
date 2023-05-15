package Kontrollstrukturen;

import java.util.Scanner;

public class AddUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		Scanner scan = new Scanner(System.in);
		int x;

		do {
			System.out.println("Zahl eingeben (x<0 für abbruch): ");
			x = scan.nextInt();
			i+=x;
		}
		while(x>0);
		
		/*System.out.println("Zahl eingeben (x<0 für abbruch): ");
		  x = scan.nextInt();
		while(x>0) {
			i+=x;
			System.out.println("Zahl eingeben (x<0 für abbruch): ");
			x = scan.nextInt();
		}*/
		System.out.println(i);
		
	}

}
