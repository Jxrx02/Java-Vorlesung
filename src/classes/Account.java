package classes;

public class Account {

	int kontonummer;
	String name;
	double geld;
	
	public double getGeld() {
		return geld;
	}

	public void setGeld(double geld) {
		this.geld = geld;
	}

	@Override
	public String toString() {
		return "Account [kontonummer=" + kontonummer + " (name=" + name + ") Stand=" + geld + "ct]";
	}
	
	public Account(int kontonummer, String name, double geld) {
		super();
		this.kontonummer = kontonummer;
		this.name = name;
		this.geld = geld;
	}
	public Account() {
		this(0001, "bernd", 42);
	}
	

	public void processDeposit(int amount) {
		if(amount > 0)
			this.setGeld(this.getGeld()+amount);
	}
	
	public void processPayment(int amount) {
		if(this.getGeld()-amount>0) {
			this.setGeld(amount);
		}
		else System.out.println("Deckung nicht ausreichend!");

	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc = new Account(4242, "Jere", 500);
		System.out.println(acc);
		acc.processDeposit(200);
		System.out.println(acc);
		acc.processPayment(400);
		System.out.println(acc);
		acc.processPayment(2000);
		System.out.println(acc);
	}

}
