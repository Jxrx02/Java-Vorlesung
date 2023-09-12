package A_19_IO_Files;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InputOutputControl {

  public static String path;
  public static String filename; //filename .txt
  public static boolean append = true;

  public static void deleteCompleteFileContentButNotFile() {
    try (Writer out = new FileWriter(path + filename, false)) {
      out.write(""); //

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String[] getLines() {
    List<String> zeilenListe = new ArrayList<>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(path + filename));
      String zeile;
      while ((zeile = reader.readLine()) != null) zeilenListe.add(zeile);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return zeilenListe.toArray(new String[0]);
  }

  public static void saveContent(LinkedList<String> objects) {
    //Generate line
    String line = "";
    for (int i = 0; i < objects.size(); i++)
      if (i < objects.size() - 1)
        line += objects.get(i) + ",";
      else line += objects.get(i) + ";";
    //String line = objects.get(0) + ";" + objects.get(1);


    File dir = new File(path);
    //Erzeuge File in dir falls nicht vorhanden
    File file = new File(dir, filename);

    //append to file
    try (Writer out = new FileWriter(file, append)) {
      out.write(line + "\n"); // wird angehängt
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, e);
      e.printStackTrace();
    }
  }

  public static LinkedList<String[]> loadContent() {
    List<String[]> entry = new LinkedList<>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(InputOutputControl.path + InputOutputControl.filename));
      while (reader.ready()) entry.add(parseLine(reader.readLine()));

    } catch (Exception e) {
      System.err.println("Fehler beim lesen!");
      return new LinkedList<String[]>();
    }

    return (LinkedList<String[]>) entry;
  }

  private static String[] parseLine(String line) {
    String[] parts = line.split("[,]");
    //for string
    parts[parts.length - 1] = parts[parts.length - 1].toString().replace(";", "");   //remove semicolon from last part
    return parts;

        /*if ( parts.length == 2 ) {
            try {
               //return new String( parts[0] + parts[1] );

               // so könnten komplexe datentypen geparst werden...
                // return new Token( parts[0],
               //                    new Date( Long.parseLong( parts[1] ) ) );
            } catch ( Exception e ) {
                System.err.println( "Error parsing token line: " + line );
                e.printStackTrace();
            }
        }
        return null;*/
  }

  public static void replaceRegexWithString(String path, String regex, String replacement) {
    try {
      String content = Files.readString(Path.of(path));
      content = content.replaceAll(regex, replacement);
      Files.writeString(Path.of(path), content);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    InputOutputControl.path = "src/A_19_IO_Files/";
    InputOutputControl.filename = "test.txt";

    //Save List
    LinkedList<String> s = new LinkedList<>();
    s.add("ABC");
    s.add("XYZ");
    s.add("LM");
    s.add("{EFG}");
    s.add("{HIJ}");
    s.add("LM");

    //replaceRegexWithString(path + filename, "ABC", "abc");

    //Save List
    InputOutputControl.saveContent(s);

    //Load List
    LinkedList<String[]> l = loadContent();

    //print each element from each StringArray from List
    for (String[] array : l) for (String element : array) System.out.println(element);

    //Load lines just for fun
    String[] lines = getLines();

  }


}
