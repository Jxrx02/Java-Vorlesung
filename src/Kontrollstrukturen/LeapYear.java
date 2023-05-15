package Kontrollstrukturen;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\nEingabe: ");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welches Jahr soll auf Schaltjahr geprüft werden?");
	
		int year = scan.nextInt();
		
		if(isLeapYear(year))
			System.out.println(year+ " ist ein Schaltjahr");
		else
			System.out.println(year+ " ist kein Schaltjahr");

	}
	private static boolean isLeapYear(int year) {
		if(year%4==0) {
			if(year%100==0) {
			
				if(year%400==0)
					return true;
				else return false;
			}
		return true;
		}
		return false;
		
	}

}
