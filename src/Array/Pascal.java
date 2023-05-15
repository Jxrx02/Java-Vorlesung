package Array;

public class Pascal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 9;
		int a[][] = new int[row][];
		
 		for(int i =0;i <a.length;i++) {
			a[i] = new int[i+1];
			a[0][0] = 1;

			for(int j =0;j<i+1;j++) {
				if(j==0 || j==a[i].length-1)
					a[i][j] = 1;
				
				else
					a[i][j] = a[i-1][j-1] +a[i-1][j] ;

			
				
					
			}
		}
 		
		System.out.println("\nPascalsche Dreieck:");
		for(int i=0; i <row;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.printf("%4d", a[i][j], ", ");
			}
			System.out.println();
			
		}
		
	}

}
