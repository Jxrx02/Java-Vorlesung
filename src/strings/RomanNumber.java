package strings;

import java.util.Scanner;

public class RomanNumber {
	/**
	 * Programm zu Konvertierung einer römischen Zahl in Dezimalzahl
	 */
	
	public int[] Numbers = { 1000, 500, 100, 50, 10, 5, 1 };
	public char[] RomanNumbers = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.println("Bitte geben Sie eine röm. Zahl ein: ");
		StringBuilder sb = new StringBuilder(scan.next());

		RomanNumber rn = new RomanNumber();

		System.out.println("Der Wert der Zahl " + sb.toString() + " ist " + rn.convertRomanToArabic(sb));

	}

	int getValueFromRoman(char c) {
		int pos = 0;
		for (int i = 0; i < RomanNumbers.length; i++) {
			if (RomanNumbers[i] == c)
				pos = i;
		}
		return Numbers[pos];
	}

	int convertRomanToArabic(StringBuilder sb) {
		int number = 0;

		for (int i = 0; i < sb.length(); i++) {
			int num1 = getValueFromRoman(sb.charAt(i));
			if (i+1 < sb.length()) {
				int num2 = getValueFromRoman(sb.charAt(i + 1));
				if (num1 >= num2)
					number += num1;
				else
					number -= num1;

			} else
				//just add last digit
				number += num1;

		}
		return number;
	}

}
