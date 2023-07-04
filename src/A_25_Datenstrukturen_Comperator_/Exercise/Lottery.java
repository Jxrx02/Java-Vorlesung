package A_25_Datenstrukturen_Comperator_.Exercise;

import java.util.*;

public class Lottery {


    public static void main(String[] args) {

        Set<Integer> numbers = new TreeSet<>(); // TreeSet  sortiert!
        Random rnd = new Random();

        //-----------------TreeSet-----------------
        for(int i =0; i<7; i++) {
            numbers.add(rnd.nextInt(1,50)); //1<=x<50
        }

        //Ausgabe
        System.out.println("\nTreeSet");
        int k = 0;
        for (Integer n : numbers) {
            k++;
            System.out.print( n + " " );
            if (k==6)
                System.out.print("Zusatzzahl: ");
        }



        //-----------------ArrayList-----------------
        List<Integer> num = new ArrayList<>();
        //Fülle ArrayList
        for(int i =0; i<7; i++) {
            num.add(rnd.nextInt(48)+1);
        }
        Collections.sort(num, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("\n\nArrayList");
        //Ausgabe
        for(int i =0; i< num.size(); i++){
            System.out.print( num.get(i) + " " );
            if (i==5)
                System.out.print("Zusatzzahl: ");
        }

    }
}
