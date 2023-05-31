package Theo;

public class Sort {
    public static void main(String[] args) {
        int elemente = 100;
        int range = 1000;

        int[] arr = new int[elemente];
        for(int i=0;i<elemente; i++){
            arr[i] = elemente-i;
        }

        // Startzeit erfassen
        long startTime = System.nanoTime();
        bubbleSort(arr);
        // Endzeit erfassen
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Sortierte Array-Elemente:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nAusführungszeit: " + duration / Math.pow(10,9) + " Sekunden");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Tausche die Elemente arr[j] und arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
