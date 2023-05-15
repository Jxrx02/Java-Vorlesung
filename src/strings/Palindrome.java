package strings;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Wort eingeben: ");
		String s = scan.next();
		System.out.println("Reversed with method: " + revertString(s));
		
		StringBuffer k = new StringBuffer(s);
		k.reverse();
		System.out.println("Reversed with buffer: " + k);	
		
		
		//if(isPalindrom(s,k))
		if(isPalindrom(s,k.toString()))

			System.out.println("Hinweis: Es handelt sich um ein Palindrom: " + s);
	}
	
	public static boolean isPalindrom(String s, String rs) {
		return s.equalsIgnoreCase(rs);
	}
	
	public static boolean isPalindrom(String s, StringBuffer k) {
		
		if(s.length() != k.length()) {
			return false;
		}
		for(int i = 0; i < s.length();i++) {
			if(s.charAt(i) == k.charAt(i)) {
				System.out.println(s.charAt(i) + " - " + k.charAt(i));
			}
			else return false;
		}
		
		return true;
	}
	


	public static String revertString(String s) {
		
		String _s = "";
		for(int i = 0; i < s.length();i++) {
			_s += s.charAt(s.length()-i-1);
		}
		
		return _s;
	}

}
