package A_28_Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();


        Stream.of("Emma","Hannah","Mia","Sophia","Emilia","Lina",
                "Anna","Marie","Mila","Lea").forEach( names::add );

        /** Alle Stream-Elemente ausgeben*/
        //names.stream().forEach( System.out::println );


        /**parallele Abarbeitung*/
        //Stream.of("Emma","Hannah","Mia","Sophia","Emilia","Lina",
        //        "Anna","Marie","Mila","Lea").parallel().forEach( names::add );

        /**sequentielle Abarbeitung */
        //Stream.of("Emma","Hannah","Mia","Sophia","Emilia","Lina",
        //        "Anna","Marie","Mila","Lea").sequential().forEach( names::add );

        /** Funktionen*/
        /**Filter*/
        //names.stream().filter(n->(n.length()<4)).forEach( System.out::println );


        /**in Objekte umwandeln - map*/
        names.stream()
                .map( n -> new Person( n ) )
                .peek(n-> n.setAge(n.getAge()+1))
                .forEach( System.out::println );

        //names.stream().map( Person::new ); // Alternative Schreibweise

        //Primitive Datentypen
        //Stream.of( "1","2","3" ).mapToInt( Integer::parseInt );



        /**.skip*/// überspringt n elemente
        /**.distinct*/// sortiert doppelte werte aus
        /**.peek*/// ruft jedes Element einzeln auf /**Funktionen für jedes Element n ausführen*/
            /*Stream.of("1","2","1","2","1","2")
                    .peek( n -> System.out.println( "Peek: " + n ) )
                    .distinct().forEach(System.out::println); //*/
        /**.flatMap(Stream::of)*/// Elemente auftrennen
            /*String[][] strings = new String[][]{
                    {"Lorem", "ipsum"}, {"dolor", "sit"}, {"amet", "consectetur"} };
            Stream.of( strings )
                    .flatMap( Stream::of )
                    .forEach( System.out::println ); //*/
        /**.sorted*/// für eigenen Comparator


        /**Terminalfunktionen*/
        /**foreach*/
        /**.collect*/
            //ToList
           /* Stream.of("Emma","Hannah","Mia","Sophia","Emilia",
                    "Lina","Anna","Marie","Mila","Lea").forEach( names::add );
            List<String> resNames = names.stream()
                    .skip( 4 ) // 4 Elemente überspringen
                    .collect( Collectors.toList() ); // Elemente als Liste einsammeln
            System.out.println( resNames ); */

            //Joining
            /*String namesCsv = names.stream()
                    .skip( 4 ) // 4 Elemente überspringen
                    .collect( Collectors.joining( ", " ) );
            System.out.println( namesCsv ); */

            //erstes Element
            /* Optional<String> first = names.stream()
                .skip( 4 ) // 4 Elemente überspringen
                .findFirst(); // erstes Element finden //*/
        /**count*/
    }


}


class Person {
    private String name;
    private int age;
    public Person( String name ) {
        this.name = name;
    }
    public Person( String name, int age ) {
        this.name = name;
        this.age = age;
    }
    public String getName() { return this.name; }
    public void setName( String name ) { this.name = name; }
    public int getAge() { return this.age; }
    public void setAge( int age ) { this.age = age; }
    public String toString() {
        return "Person[" + this.name + "," + this.age + "]"; }
}

class Parallel {
    public static void main( String[] args ) {
// Befüllen einer Liste mit Namen - mittels Stream
        List<String> names = new ArrayList<>();
        Stream.of("Emma","Hannah","Mia","Sophia","Emilia",
                "Lina","Anna","Marie","Mila","Lea").forEach( names::add );
        long start = System.currentTimeMillis();
        names.parallelStream().forEach( Parallel::timeConsumingCalculation );
        System.out.println( "Parallel took " +
                ( System.currentTimeMillis() - start ) + "ms" );
        start = System.currentTimeMillis();
        names.stream().forEach( Parallel::timeConsumingCalculation );
        System.out.println( "Sequential took "
                + ( System.currentTimeMillis() - start ) + "ms" );
    }
    public static void timeConsumingCalculation( String name ) {
        try { Thread.sleep( 1000L ); } catch ( Exception e ) { }
    }
}