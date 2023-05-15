package hello.world;

import java.util.Scanner;

public class hello_world {
	
	public static Scanner scan = new Scanner(System.in);
	
	static int j;
	public static void main(String[] args) {
		System.out.println('a'+0);
		System.out.println("Gib Zahl ein");
		j = scan.nextInt();
		System.out.println("Die Fakultät ist: " + fakultät(j));
	}
	
	public static int fakultät(int n) {
	
        if (n <= 1) {
            return 1;
        } else {
            return fakultät(n - 1) * n;
        }
		   
	}
	
	
	
	
	
	
	
	
	
	
	
}
