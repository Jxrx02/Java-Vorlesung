package Array;

import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] fib = new int[50]; 
		
		for(int i=0; i < 50; i++)
		{
			
			fib[i] = fibbonacci(i);
			System.out.println(i+1 + ": "+  fib[i]);
		}
		
		
		
	}
	
	public static int fibbonacci(int n) {
		if(n==0 || n==1) return 1;
		else
			return fibbonacci(n-1) + fibbonacci(n-2);
	}

}
