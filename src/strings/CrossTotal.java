package strings;

import java.util.Scanner;

public class CrossTotal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Zahl für Quersumme eingeben: ");
		String s = scan.next();
		
		int quersumme = 0;
		
		for(int i = 0; i< s.length();i++) {
			String firstdigit = s.substring(i, i+1);
			quersumme += Integer.parseInt(firstdigit);

		}
		System.out.println(quersumme);
	}

}
