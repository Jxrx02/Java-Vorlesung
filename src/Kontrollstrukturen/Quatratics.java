package Kontrollstrukturen;

import java.util.Scanner;

public class Quatratics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\nEingabe: ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		double x;
		double x2;
		int d = b*b-4*a*c;
		if(a==0) {
			if(b==0)
			{
				System.out.println("Die Gleichung ist degeneriert.");
			}
			else {
				x= -(c/b);
				System.out.println("x=" + x);
			}
		}
		else {
			if(d>=0) {
				x = (-b+Math.sqrt(d))/(2*a);
				x2 = (-b-Math.sqrt(d))/(2*a);
				System.out.println("x1 = " + x + "\t x2 = " + x2);
			}
			else {
				System.out.println("Die Lösung ist konjugiert komplex.");
			}
		}
		
		
		
	}

}
