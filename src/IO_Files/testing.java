package IO_Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class testing {

    public static void main(String[] args) {

        //createFile();
        appendTextToFile("Hallo");
        readFile();
        readFileToDataStructure();
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

    public static void readFileToDataStructure(){
        List<String> lines = new ArrayList<>(); // zweites Semester!
        try ( BufferedReader br =
                      new BufferedReader(new FileReader("dir/testFile.txt")) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line); // String-Daten an Liste anhängen
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
}
