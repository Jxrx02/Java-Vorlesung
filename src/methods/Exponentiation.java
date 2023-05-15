package methods;

import java.util.Scanner;

public class Exponentiation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		System.out.println("Geben Sie bitte die Basis ein:");
		double x = scan.nextDouble();
		
		System.out.println("Geben Sie bitte den positiven ganzzahligen Exponenten ein");
		int n = scan.nextInt();
		System.out.println(x +  "^" + n  + " = " + xPowerN(x,n));
		
	}
	 
	
	
	public static double xPowerN(double x,int n) {
		if(n==0)
			return 1;
		else return x*xPowerN(x,n-1);
	}
}
