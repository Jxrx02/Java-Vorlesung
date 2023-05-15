package Primitive.Datentypen;

public class IncrementDecrement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		 int j=0;
		 j = ++i;								// j=1 i=1
		 int k = j++ + ++i;						// k = 3; j=2, i=3
		 System.out.println("k: " + k);
		 System.out.println("*: " + j++ + ++i);	//j=2 i=3
		 System.out.println(j++ + ++i); 		//j=3 i=4 = 7
		 										//j=4
		 int m = j++ * ++i;						//i=5 m =20	//j=5
		 System.out.println("m: " + m);
		 int n = --j * --i;						//i=4 j=4 Ausgabe=16
		 System.out.println("n: " + n);			//n=16
		 System.out.println("i: " + i);			//i=4
		 System.out.println("j: " + j);			//j=4
	}

}
