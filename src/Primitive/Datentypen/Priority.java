package Primitive.Datentypen;

public class Priority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1: " + (5 / 2 * 2));			//5/2 = 2 *2 = 4
		System.out.println("2: " + (9. / 2 * 5));			//22.5
		boolean a = true, b = false, c = false;				
		System.out.println("3: " + (a && b || c));			//false
		char ch = 'c';										
		System.out.println("4: " + ('a' + 1 < ch));			//true
		int i = 1, j = 2, k = 3;							
		System.out.println("5: " + (-i - 5 * j >= k + 1));	//-11 >= 3+1 - false
		i = 1;
		if (a || (++i == 2)) {
		System.out.println("6: " + i);						//1, da || nur das erste zulässt
		}
		i = 1;
		if (a | (++i == 2)) {
		System.out.println("7: " + i);						//2
		}
	}

}
