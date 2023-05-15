package Array;

import java.util.Scanner;

public class Bubblesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Bitte Anzahl der Elemente n eingeben: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];

		String s ="";
		for(int i = 0;i < n; i++) {
			System.out.print("Bitte x_" + i +" eingeben: ");
			a[i] = scan.nextInt();
		}


		for(int j=0; j<n-1; j++) {	
			for(int i = 0; i<a.length-1;i++) {
				if(a[i] > a[i+1]) { 
					int tmp = a[i]; 
					a[i] = a[i+1];  
					a[i+1] = tmp;   
				}
			
			
			}
			for(int k = 0; k<n; k++)
			{
				System.out.print(a[k] + " ");

			}
			System.out.println();
		}
		System.out.println("\nSortiert: ");
		for(int k = 0; k<n; k++)
		{
			System.out.print(a[k] + " ");

		}
		for(int x: a) {
			System.out.println("x: " +x);
		}
		
		
		
		
	
	}

}
