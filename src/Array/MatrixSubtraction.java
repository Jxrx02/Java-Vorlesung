package Array;

import java.util.Scanner;

public class MatrixSubtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Bitte Anzahl der Zeilen n eingeben: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		
		System.out.println("Bitte Anzahl der Spalten m eingeben: ");
		int m = scan.nextInt();

		int[][] a = new int[n][m];
		int[][] b = new int[n][m];
		
		//Befüllen
		for(int i=0; i <n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j] = (int) (Math.random()*100);
				b[i][j] = (int) (Math.random()*100);
			}
		}
		//Ausgeben a	
		System.out.println("X:");
		for(int i=0; i <n;i++) {
			for(int j=0;j<m;j++) {
				System.out.printf("%4d", a[i][j], " ");
			}
			System.out.println("");
			
		}
		System.out.println("Y:");
		//Ausgeben b
		for(int i=0; i <n;i++) {
			for(int j=0;j<m;j++) {
				System.out.printf("%4d", b[i][j], " ");
			}
			System.out.println();
			
		}
		//Ausgeben a-b
		System.out.println("\nX-Y:");
		for(int i=0; i <n;i++) {
			for(int j=0;j<m;j++) {
				System.out.printf("%4d", a[i][j]-b[i][j], ", ");
			}
			System.out.println();
			
		}

	}

}
