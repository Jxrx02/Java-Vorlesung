package methods;

public class Quicksort {

    public static int[] intArr = { 16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19 };
    public static int[] _intArr = { 16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = sort(intArr, 0, intArr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ": " + arr[i] + "\t"  + _intArr[i]);
        }
	}



	public static int[] sort(int arr[], int l, int r) {
	    int i, j, w, pivot;
	    i = l;
	    j = r;
	    pivot = arr[(l + r) / 2]; 					//starte in der Mitte
	    do {
	        while (arr[i] < pivot && i < r)
	            i++;
	        while (pivot < arr[j] && j > l)
	            j--;
	        
	        if (i <= j) {
	            w = arr[i];
	            arr[i] = arr[j];
	            arr[j] = w;
	            i++;
	            j--;
	        }
	    } while (i < j);
	    if (l < j)
	    	sort(arr, l, j);
	    if (i < r)
	    	sort(arr, i, r);
	    
		return arr;
	}

}
