package classes;

public class Polynomial {

	//ax²+bc+c
	public double a,b,c;
	
	
	
	public Polynomial(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Polynomial() {
		this(1,1,1);
	}
	

	@Override
	public String toString() {
		if(b>0)
			return a + "x² + " + b + "x " + c  ;
		else return a + "x² " + b + "x " + c  ;

	}

	public double getfVonX(double x) {
		return this.a * x*x + this.b * x + this.c;
	}
	
	public static Polynomial add(Polynomial p1, Polynomial p2) {
		Polynomial p = new Polynomial(p1.a + p2.a , p1.b+p2.b, p1.c+p2.c);
		return p;
	}

	public void add(Polynomial p1) {
		this.a += p1.a;
		this.b += p1.b;
		this.c += p1.c;
	}

	public static void main(String[] args) {

		Polynomial poly1 = new Polynomial(2,-2,3);
		System.out.println("Poly 1:");
		System.out.println(poly1);
		
		Polynomial poly2 = new Polynomial(5,22,-83);
		System.out.println("Poly 2:");
		System.out.println(poly2);
		
		System.out.println("New Poly3 by adding Poly 1 and Poly 2:");
		Polynomial p = add(poly1,poly2);
		System.out.println(p);
		

		System.out.println("Add Poly 1 to poly 2:");
		poly2.add(poly1);
		System.out.println(poly2);

	}

}
