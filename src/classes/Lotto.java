package classes;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {

	int zuZiehen;
	int kugelnGesamt;
	
	int[] tipp;
	int[] gezogen;
	boolean hatgezogen = false;
	Scanner scan = new Scanner(System.in);
	
	Lotto(int m, int n){
		tipp = new int[m];
		gezogen = new int[m];
	}
	
	public void tippen() {
		System.out.println("Ihr Tipp:");
		for(int i = 0; i<tipp.length;i++) {
			System.out.println("Zahl"+ (i+1) + ":");
			int x = scan.nextInt();
			if(x>= 1 && 49>=x)
				tipp[i] = x;
			else 
				{
					System.out.println("Ungültig, gib erneut deinen Tipp ein!");
					tippen();
				}
		}
	}

	public void ziehen() {
		for(int i = 0; i<6;i++) {
			gezogen[i] = (int) (Math.random()*49)+1;
		}
		hatgezogen = true;
	}
	
	public int richtige() {		
		int richtig=0;
		for(int i = 0; i<gezogen.length;i++) {
			for(int j =0;j<gezogen.length;j++) {
			if(gezogen[i]==tipp[j]) {
				richtig++;
			}
			}
		}
		return richtig;
	}
	
	@Override
	public String toString() {
		if (hatgezogen)
			return "Gezogen: " + Arrays.toString(gezogen);
		return "Tipp: " + Arrays.toString(tipp);

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lotto deutschesLotto = new Lotto(6,49);
		deutschesLotto.tippen();
		System.out.println(deutschesLotto.toString());
		deutschesLotto.ziehen();
		System.out.println(deutschesLotto);
		System.out.println("Richtige:" + deutschesLotto.richtige());

	}

}
