package Primitive.Datentypen;

import java.util.Scanner;

public class Easter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {

			System.out.println("\nEingabe: ");
			Scanner scan = new Scanner(System.in);

			int a, b, c, k;
			int p, q, m, n, d, e;
			int input = (int) scan.nextInt();
			a = b = c = k = input;

			a = a % 19;
			b = b % 4;
			c = c % 7;
			k = k / 100;
			p = (8 * k + 13) / 25;
			q = k / 4;
			m = (15 + k - p - q) % 30;
			n = (4 + k - q) % 7;
			d = (19 * a + m) % 30;
			e = (2 * b + 4 * c + +6 * d + n) % 7;

			int ostern = (22 + d + e);

			if (ostern > 31) {
				ostern -= 31;
				System.out.printf("|%25s|", "Ostern: " + ostern + ". April " + input);
			} else {
				System.out.printf("|%25s|", "Ostern: " + ostern + ". März " + input);
			}
		}
	}

}
