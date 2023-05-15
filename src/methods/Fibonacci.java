package methods;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		System.out.println("Wie viele Fibonacci-Zahlen berechnen?:");
		int n = scan.nextInt();
		
		for(int i = 1; i <= n; i ++ ) {
			System.out.println("Fib("+i+"): \t"+ fib(i));
		}

	}
	
	public static int fib(int n) {
		if(n==1) {
			return 1;
		}
		else if (n==2) {
			return 1;
			}
		else {

			return fib(n-1) +fib(n-2);
		}
	}

}
