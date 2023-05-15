package Kontrollstrukturen;

import java.util.Scanner;

public class Temperaturtabelle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.printf("%15s |%10s","Fahrenheit", "Celsius");
		System.out.printf("\n    ------------+--------------");
		for (int f=0; f<=300; f+=20) {
			double c = (5.0/9.0) *(f-32);
			System.out.printf("\n %15d|%10.2f",f,c);
		}
		
	}

}
