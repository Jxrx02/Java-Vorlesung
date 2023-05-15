package Kontrollstrukturen;

public class Hirsche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int d=200;
		int i=0;
		while (d<300) {
		
			d *= 1.1;
			d-=15;
			System.out.println(++i + ": "+ d  +" Hirsche");
		
		}
	}

}
