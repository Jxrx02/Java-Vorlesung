package Array;

public class StandardDeviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = new int[100];
		
		for(int i=0; i <100; i++)
		{
			a[i]=(int)(Math.random()*10);
		}
		
		float mittelwert=0;
		
		for(int i = 0; i < a.length;i++) {
			mittelwert += a[i];
		}
		mittelwert /=a.length;
		
		//standardabweichung
		double standardabweichung;
		double s=0;
		for(int i = 0; i< a.length; i++) {
			s += Math.pow((a[i]-mittelwert),2);
		}
		s/=(a.length-1); 
		standardabweichung = Math.sqrt(s);
		
		System.out.println("Mittelwert: " + mittelwert);
		System.out.println("Standardabweichung: " + standardabweichung);

	}

}
