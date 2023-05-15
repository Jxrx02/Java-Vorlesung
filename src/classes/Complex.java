package classes;

public class Complex {

	private double real,imag;
	public void setReal(double pReal) {
		this.real = pReal;
	}

	public void setImag(double pImag) {

		this.imag = pImag;
	}
	
	public double getReal() {
		return real;
	}
	public double getImag() {

		return imag;
	}
	
	public void add(Complex comp){
		this.imag += comp.getImag();
		this.real += comp.getReal();
	}
	public void sub(Complex comp){
		this.imag -= comp.getImag();
		this.real -= comp.getReal();
	}
	public void mult(Complex comp){
		this.imag *= comp.getImag();
		this.real *= comp.getReal();
	}
	
	public void div(Complex comp){
		this.imag /= comp.getImag();
		this.real /= comp.getReal();
	}
	
	public double getMagnitude() {
		return Math.sqrt(Math.pow(getReal(), 2)+ Math.pow(getImag(), 2));
	}
	public boolean isLess(Complex comp) {
		return this.getMagnitude() < comp.getMagnitude();
	}
	
	Complex(double real, double imag){
		setImag(imag);
		setReal(real);
	}
	Complex(){
		this(Math.random()*10, Math.random()*10);
	}
	@Override
	public String toString() {
		return "Complex: " + Math.round(real) + (this.getImag() < 0 ? "   " :" + ") + Math.round(imag) + "i" + " \t Betrag: " + getMagnitude();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Complex[] comp = new Complex[10];
		
		for(int i=0;i <10;i++) {
			comp[i] = new Complex();
			
		}
		System.out.println("Unsortiert");
		
		for(int i=0;i <10;i++) {
			System.out.println(comp[i]);
		}
		System.out.println("Sortiert: ");

		
		//Bubblesort		
		int n = 10;
		for(int j=0; j<n-1; j++) {	
			for(int i = 0; i<comp.length-1;i++) {
				if(comp[i].getMagnitude() > comp[i+1].getMagnitude()) { 
					Complex tmp =comp[i]; 
					comp[i] = comp[i+1];  
					comp[i+1] = tmp;   
				}
			
			
			}

		}
		System.out.println("\nSortiert: ");
		for(int k = 0; k<n; k++)
		{
			System.out.println(comp[k] + " ");

		}

	}
	

}
