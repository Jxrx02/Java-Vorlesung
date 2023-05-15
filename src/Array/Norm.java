package Array;

import java.util.Scanner;

public class Norm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bitte Anzahl der Elemente n eingeben: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int a[] = new int[n];
		double betrag = 0;
		for(int i = 0;i < n; i++) {
			System.out.println("Bitte x_" + i +" eingeben: ");
			a[i] = scan.nextInt();
			betrag += a[i] * a[i];
		}

		betrag = Math.sqrt(betrag);
		System.out.println("Der Betrag von x ist: " + betrag);
		
	}

}
