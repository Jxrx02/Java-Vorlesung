package A_25_Datenstrukturen_Comperator_;

import java.util.ArrayList;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        //Kovarianz
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(42);
        List<? extends Number> list = intList;
        Integer i = (Integer) list.get(0); // nicht erlaubt
        Number n = list.get(0); // erlaubt
       // list.add(n); // nicht erlaubt
       // list.add(i); // nicht erlaubt
        list.add(null); // erlaubt
    }

}

class Example3 {

    public static void main(String[] args) {

        //Kontravarianz
        List<Number> numList = new ArrayList<Number>();
        numList.add(42);
        List<? super Integer> list = numList;
        Integer i = (Integer) list.get(0); // nicht erlaubt
        //Number num = list.get(0); // nicht erlaubt
        //list.add(obj); // nicht erlaubt
        //list.add(num); // nicht erlaubt
        Object obj = list.get(0); // erlaubt
        list.add(i); // erlaubt
    }
}