package A_19_IO_Files;

import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class InputOutputControl {

    public static String path;
    public static String filename; //filename .txt

    public static void deleteCompleteFileContent(){
        try ( Writer out = new FileWriter( path+filename , false) ) {
            out.write(""); //

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveContent(LinkedList<String> objects){
        String line = objects.get(0) + ";" + objects.get(1);

        File dir = new File(path);

        //Erzeuge File in dir
        File file = new File(dir, filename);

        //append to file
        try ( Writer out = new FileWriter(file, true) ) {
            out.write(line + "\n"); // wird angehängt
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    /**
     *
     * @ersetzte Object mit Datentyp
     */
    public static List<String> loadContent(){
            List<String> entry = new LinkedList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(path+filename))) {
                while (reader.ready()) {
                    entry.add(parseToken(reader.readLine()));
                }

            } catch (Exception e) {
                System.err.println("Fehler beim lesen!");
                return new LinkedList<String>();
            }

            return entry;
    }

    public static String parseToken( String line ) {
        String[] parts = line.split( "[;]" );
        if ( parts.length == 2 ) {
            try {
                return new String( parts[0] + parts[1] );

                // return new Token( parts[0],
               //         new Date( Long.parseLong( parts[1] ) ) );
            } catch ( Exception e ) {
                System.err.println( "Error parsing token line: " + line );
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        InputOutputControl.path = "src/A_19_IO_Files";
        InputOutputControl.filename = "test";

        LinkedList<String> s = new LinkedList<>();
        s.add("ABC");
        s.add("XYZ");
        InputOutputControl.saveContent(s);

        List<String> l = loadContent();

        System.out.println(l);
    }

}
