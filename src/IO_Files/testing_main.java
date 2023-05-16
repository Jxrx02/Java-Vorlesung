package IO_Files;

import java.io.*;
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