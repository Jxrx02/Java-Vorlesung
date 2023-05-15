package classes;

import java.util.Scanner;

public class Nimmspiel {

	public int kugelnA;
	public int kugelnB;
	public String s1,s2;
	public boolean nextTurn = false; //false = spieler1; true = spieler2 
	
	
	public int getkugelA() {
		return kugelnA;
	}
	public int getkugelB() {
		return kugelnB;
	}
	
	public String getS1() {
		return s1;
	}
	public String getS2() {
		return s2;
	}
	public Nimmspiel(String spieler1,String spieler2){
		this.s1 = spieler1;
		this.s2 = spieler2;
		
		this.kugelnA = (int) (Math.random()*10);
		this.kugelnB = (int) (Math.random()*10);
	}
	
	
	
	


	public void nimmKugel(int stapel, int anzahl) {
		if(stapel == 0) {
			if(kugelnA-anzahl>=0)
				this.kugelnA-=anzahl;
			else System.out.println("Etwas ist fehlgeschlagen");

		}
		else {
			if(this.kugelnB-anzahl>=0)
				this.kugelnB-=anzahl;
			else System.out.println("Etwas ist fehlgeschlagen");
			
		}

			
	}
	

	@Override
	public String toString() {
		return "Nimmspiel [Haufen0: " + this.kugelnA +" Kugeln"+ ", Haufen1: " + this.kugelnB + "Kugeln]";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Spieler1, wie heißt du?");
		String s1 = scan.next();
		System.out.println("Spieler2, wie heißt du?");
		String s2 = scan.next();
		
		Nimmspiel ns = new Nimmspiel(s1,s2);
		System.out.println(ns.toString());

		while(ns.getkugelA()>=0 && ns.getkugelB()>=0) {
			if(ns.kugelnA ==0 &&ns.kugelnB==0)
				{
					if(!ns.nextTurn)
						System.out.println(ns.s1 + " hat gewonnen.");
					else
						System.out.println(ns.s2 + " hat gewonnen.");

					return;
				}
			if(ns.nextTurn) {
				System.out.println(ns.getS1()+": Haufen?");
				int haufen = scan.nextInt();
					while(haufen>1) {
						System.out.println("Zu groß! Mach nochmal:");
						haufen=scan.nextInt();
					}
				System.out.println(ns.getS1()+": Anzahl der Kugeln?");
				int anzahl = scan.nextInt();
				ns.nimmKugel(haufen, anzahl);
				ns.nextTurn = !ns.nextTurn;
				System.out.println(ns.toString());
			}
			else
			{
				System.out.println(ns.getS2()+": Haufen?");
				int haufen = scan.nextInt();
				while(haufen>1) {
					System.out.println("Zu groß! Mach nochmal:");
					haufen=scan.nextInt();
				}
				System.out.println(ns.getS2()+": Anzahl der Kugeln?");
				int anzahl = scan.nextInt();
				ns.nimmKugel(haufen, anzahl);
				ns.nextTurn = !ns.nextTurn;
				System.out.println(ns.toString());

			}
			
		}
		

		
	
	}






}
