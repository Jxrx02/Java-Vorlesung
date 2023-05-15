package Array;

import java.util.Scanner;

public class DotProduct {

	public static void main(String[] args) {
		System.out.println("Bitte Anzahl der Elemente n eingeben: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int a[] = new int[n];
		int b[] = new int[n];

		double betrag = 0;
		
		
		for(int i = 0;i < n; i++) {
			System.out.println("Bitte x_" + i +" eingeben: ");
			a[i] = scan.nextInt();

		}
		for(int i = 0;i < n; i++) {
			System.out.println("Bitte y_" + i +" eingeben: ");
			b[i] = scan.nextInt();
		}
		for(int i = 0;i < n; i++) {
			betrag += b[i]*a[i];
		}


		System.out.println("Das Skalarprodukt von x und y ist: " + betrag);
		

	}

}
