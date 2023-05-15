package Primitive.Datentypen;

public class ShortValue {

	static short s = 32767;
	public static void main(String[] args) {
		// Überlauf
		System.out.println(s);
		s++;
		System.out.println(s);
	}

}
