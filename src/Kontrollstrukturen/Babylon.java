package Kontrollstrukturen;

import java.util.Scanner;

public class Babylon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);		
		System.out.println("Wurzel aus welcher Zahl ziehen?");
		int a = scan.nextInt();
		double xn, x=1;


		do {
			xn = x;
			x=(xn+(double)(a/xn))/2;
			System.out.println("xn:" + xn);
		}	
		while(Math.abs(x-xn)>Math.pow(10, -6));
		
		System.out.println("Die Wurzel aus " + a + " ist " + x);
	}
	
}

