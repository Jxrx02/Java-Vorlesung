package A_19_IO_Files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class testing_main {
    private static final ArrayList<String> textfileLines = new ArrayList<String>();

    public static void main(String[] args) {

        //createFile();
        //appendTextToFile("Hallo");                                    //filewriter
        wirteToFile("ABC ich bin eine Fee hallo");                //filewriter
        readFile();                                                     //filereader
        //readFileWithBufferedReader();                                 //bufferedreader
        readFileToDataStructure();                                      //bufferedreader
        System.out.println("\nIn linie 2 steht: " + getLine(2-1));      //getline from arraylist - setline();

    }



    public static void createFile(){
        //Erzeuge dir
        File dir = new File("dir");
        dir.mkdir();

        //Erzeuge File in dir
        File testFile = new File(dir, "testFile.txt");

        try {
            testFile.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //testFile.delete();


    }

    public static void readFile(){
        System.out.println("Read-Class:");
        String testFile = "dir/testFile.txt";
        try ( Reader fReader = new FileReader(testFile) ) {
            int c;
            while ((c = fReader.read()) != -1) { // nächstes Z. einles.
                System.out.print((char) c); // Wenn -1: Dateiende
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    /** Verwendung von path,file*/
    public static List<String> readFile(String path){
        Path p = Paths.get( path );
        try {
            List<String> lines1 = Files.readAllLines( p );
            return lines1;
        } catch (IOException e) {
        }
        return null;
    }


    /** Datenstrukturen mit Stream auslesen */
    /*public void loadBooks() {
        Path p = Paths.get( this.filename );
        try {
            Files.readAllLines( p ) // alle Zeilen lesen
                    .stream()                       // als Stream weiterverarbeiten
                    .map(l->l.split( ";" ))         // aufsplitten an ";" zu String-Array
                    .filter( l->l.length == 4 )     // alle Arrays rausfiltern, die nicht genau 4 Einträge haben
                    .map( l->new Book( l[0], l[1],  // Array in ein Buch-Objekt umwandeln
                            new Integer( l[2] ), l[3] ) )
                    .forEach( this.books::add );    // jedes Buch in die Liste hinzufügen
        } catch (IOException ex) {
            System.err.println( "Read error: " + ex.getLocalizedMessage() );
        }
    }*/

    /*public void loadBooks() {
        Path p = Paths.get( this.filename );
            try {
            // Ergebnis der Stream-Operationen wird this.books zugewiesen!
              this.books = Files.readAllLines( p ) // alle Zeilen lesen
                .stream() // als Stream weiterverarbeiten
                .map( this::parseBook ) // Zeile in Buch umwandeln
                .filter( Objects::nonNull ) // null-Werte aussortieren
                .collect( Collectors.toList() ); // Stream in Liste umwandeln
                } catch (IOException ex) {
                    System.err.println( "Read error: " + ex.getLocalizedMessage() );
             }
        }
        private Book parseBook(String line) {
            String[] p = line.split( ";" );
            if ( p.length == 4 ) {
            return new Book( p[0], p[1], new Integer( p[2] ), p[3] );
            } else {
            return null;
        }
}*/

    public static void readFileWithBufferedReader(){
        System.out.println("BufferedReader-Class:");

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("dir/testFile.txt"))){ // BufferedReader um einzelne Zeilen lesen zu können
            while (bufferedReader.ready()){
                System.out.println(bufferedReader.readLine());  // jede zeile wird ausgegeben
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileToString(String path) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }


    public static void deleteStringFromFile(String path, String stringToDelete) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Überprüfen, ob die Zeile den zu löschenden String enthält
                if (line.contains(stringToDelete)) {
                    // Wenn ja, überspringen wir diese Zeile
                    continue;
                }

                content.append(line);
                content.append(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Den aktualisierten Inhalt in die Datei zurückschreiben
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileToDataStructure(){
        System.out.println("To Array with buffered Reader:");

        List<String> lines = new ArrayList<>(); // zweites Semester!
        try ( BufferedReader br =
                      new BufferedReader(new FileReader("dir/testFile.txt")) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line); // String-Daten an Liste anhängen
                textfileLines.add(line);
            }
            System.out.print(lines);
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    public static void appendTextToFile(String pText){
        try ( Writer out = new FileWriter("dir/testFile.txt", true) ) {
            String s = pText;
            out.write(s); // wird angehängt

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void wirteToFile(String string){
        try (FileWriter fWriter = new FileWriter("dir/testFile.txt", true)){     // öffnen des FileWriters mit Anweisung append
            fWriter.write(string + System.lineSeparator());          // Schreiben des Strings in die Datei
            System.out.println("Ergebnis in der Datei gespeichert.");
        }
        catch (IOException e) {
            e.printStackTrace();                                                // Ausgeben des Fehlers, wenn einer auftritt
        }
    }


    private static int availableLines(){
        return textfileLines.size();
    }
    public static String getLine(int i){
        try {
            if(i > 0 && i < availableLines()){
                return textfileLines.get(i);
            }
            else{
                throw new LineNumberOutOfBoundsException("Falsche Eingabe bei getLine");
            }
        }
        catch (LineNumberOutOfBoundsException e) {
            System.out.println(e);
        }
        return null;
    }

    public void setLine(int i, String s) throws LineNumberOutOfBoundsException{
        if(i > 0 && i < availableLines()){
            textfileLines.set(i, s);
        }
        else{
            throw new LineNumberOutOfBoundsException("Falsche Eingabe bei setLine");
        }
    }
}
