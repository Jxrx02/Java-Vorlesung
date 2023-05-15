package Kontrollstrukturen;

import java.util.Scanner;

public class NumberGuess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1;
		int x = (int) (Math.random()*100) + 1;
		
		Scanner scan = new Scanner(System.in);
		int anzahlVersuche=0;
		
		System.out.println("Wie ist dein Name?");
		String spielername = scan.next();
		
		int zahl;
		System.out.println("Die gesuchte Zahl ist: " + x+ " Jetzt bist du dran!");
		while(a==1) {
			System.out.println(spielername + ", rate eine Zahl [1-100]:");
			zahl = scan.nextInt();
			
			
			if(zahl==x)
			{
				System.out.println("Versuch " + ++anzahlVersuche + ": " + zahl + " ist korrekt\nWas möchtest Du tun?\n0 - Spiel beenden\n1 - Spiel fortsetzten");
				if(scan.nextInt()==0)
					break;
			}
			else if (zahl < x)
				System.out.println("Versuch " + ++anzahlVersuche + ": " + zahl + " ist zu niedrig");
			else
				System.out.println("Versuch " + ++anzahlVersuche + ": " + zahl + " ist zu hoch");

		}
		
		
	}

}
