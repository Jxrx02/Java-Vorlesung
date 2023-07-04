package A_25_Datenstrukturen_Comperator_;

import java.util.*;

public class Example {

    /** ---------------------------------------Datentypen-----------------------------------------
     Set        - Mengencharakter, Keine Duplikate, keine Indexierung
     HashSet,TreeSet

     Sorted Set - Sortierte Mengen, keine Indexierung
     TreeSet

     List       - über Ints indiziert                                                       shuffle, sort, reverse, min, max, binarySearch
     Vector, ArrayList (Iteration), LinkedList(Hinzufügen,Löschen)

     Map        - Schlüssel zu Werten; Werte können Duplikate haben, Schlüssel nicht        put(), get(), size(); keySet(), values() remove, clear, containsKey/value, isEmpty,
     HashMap, WeakHashMap TreeMap Hashtable

     SortedMap  - Schlüssel sortiert
     TreeMap

     Stack      - Elemente oben drauf;

     Iterator   - Listen durchlaufen; Elemente können gelöscht werden
     */

    /** ----------------------------------Methoden,-die-alle-haben-----------------------------------------
     *  add(), addAll(), remove(), contains(), size()
     */



    public static void main(String[] args) {

        //ArrayList
        System.out.println("\nArrayList");
        ArrayList();

        //Set
        System.out.println("\nSet");
        Set();

        //TreeSet
        System.out.println("\nTreeSet");
        TreeSet();

        //Map
        System.out.println("\nMap");
        Map();

        //Stack
        System.out.println("\nStack");
        Stack();

        //Iterator
        System.out.println("\nIterator");
        Iterator();
        //RandomNumbers();
    }

    public static void ArrayList(){
        List<String> words = new ArrayList<>();
        words.add( "This" );
        words.add( "is" );
        words.add( "an" );
        words.add( "example" );
        Collections.sort(words);

        for(String s : words) {
            System.out.println( s );
        }
    }
    public static void Set(){
        Set<String> mySet = new HashSet<>(); // HashSet  Reihenfolge?
        mySet.add("Mia");
        mySet.add("Uli");
        mySet.add("Peter");
        mySet.add("Mia"); // Duplikat wird nicht hinzugefügt!
        for(String s : mySet) {
            System.out.println(s);
        }
        System.out.println("Element count: " + mySet.size());

    }

    public static void TreeSet(){
        Set<String> mySet2 = new TreeSet<>(); // TreeSet  sortiere!
        mySet2.add("Mia");
        mySet2.add("Uli");
        mySet2.add("Peter");
        mySet2.add("Mia"); // Duplikat wird nicht hinzugefügt!
        for(String s : mySet2) {
            System.out.println(s);
        }
        System.out.println("Element count: " + mySet2.size());
    }

    public static void Map(){
        Map<String, String> bdays = new HashMap<>();

        bdays.put( "Mia", "20.04.1992" );
        bdays.put( "Uli", "10.08.1993" );
        bdays.put( "Karl", "11.08.1993" );

        bdays.put( "Peter", "19.07.1994" );
        bdays.put( "Mia", "31.12.1991" ); // Duplikat überschreibt!
        for(String name : bdays.keySet()) { // Schlüssel als Set
            System.out.println(name + " born on " +
                    bdays.get(name)); // Schlüssel 'name'
           // System.out.println(bdays.values());
        }


    }

    public static void Stack(){
        Stack<Integer> numbers = new Stack<>();
        numbers.push( 42 );
        numbers.push( 4711 );
        numbers.push( 999 );
        System.out.println("Count: " + numbers.size()); // Count
        System.out.println("Peek: " + numbers.peek()); // Peek Element
        do {
            System.out.println("Pop: " + numbers.pop());
        } while ( !numbers.empty() );
    }

    public static void Iterator(){
        List<String> list = new ArrayList<>();
        list.add("Karl");
        list.add("Otto");
        list.add("Hans");
        Iterator<String> iter = list.iterator();
        for (; iter.hasNext();) {
            System.out.println(iter.next());
        }
        //Iterator mit TreeMap
        /*
        TreeMap<String, String> tm = new TreeMap<>();
        // Elemente der Kollektion hinzufügen
        // ...
        Collection<String> col = tm.values();
        Iterator<String> iter = col.iterator();

        // Elemente durchlaufen
        while (iter.hasNext()) {
        String o = iter.next();
        // hier Bearbeiten der Elemente // ...
        }
         */
    }

    public static void RandomNumbers(){
        Set<Integer> numbers = new TreeSet<>(); // TreeSet  sortiert!
        Random rnd = new Random();
        // Erzeuge genau 10 verschiedene Zufallszahlen zwischen 1 und 20
        do {
            numbers.add( rnd.nextInt(20)+1 ); // Keine Duplikate!
        } while ( numbers.size() < 10 ); // Stopp, wenn es 10 sind
        // Ausgabe
        for (Integer n : numbers) {
            System.out.print( n + " " );
        }

    }

}
