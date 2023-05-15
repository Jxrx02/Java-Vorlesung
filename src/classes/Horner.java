package classes;

public class Horner {

	public double a;
	public int k;
	
	public Horner(double a, int k) {
		super();
		this.a = a;
		this.k = k;
	}
	public Horner() {
		this.a = (double)(Math.random()*10);
		this.k = (int) (Math.random()*10);
	}
	public Horner(int k) {
		this.a = (double)(Math.random()*10);
		this.k = k;
	}
	public Horner(double a) {
		this.a = a;
		this.k = (int) (Math.random()*10);
	}
	public static double getValue(double x, Horner poly[]){
		
		double y = 0;
		for(int i = 0;i<poly.length;i++) {
			y += Math.pow(poly[i].a*x,poly[i].k); 
			
		}
		
		return y;
	}
	
	
	@Override
	public String toString() {
		return a + "*x^" + k;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Horner polynom[] = new Horner[11];
		polynom[0] = new Horner(0.5,10);
		polynom[1] = new Horner(-3,9);
		polynom[2] = new Horner(2,8);
		polynom[3] = new Horner(4,7);
		polynom[4] = new Horner(3,6);
		polynom[5] = new Horner(-10,5);
		polynom[6] = new Horner(8,4);
		polynom[7] = new Horner(4.5,3);
		polynom[8] = new Horner(3,2);
		polynom[9] = new Horner(-2,1);
		polynom[10] = new Horner(0.5,0);

		for(int i=0;i < polynom.length;i++) {
			System.out.print(polynom[i] + " + ");

		}
		System.out.println("\nf(1.5) = " + getValue(1.5, polynom));

		
	}
	
	
}
