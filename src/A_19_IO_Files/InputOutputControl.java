package A_19_IO_Files;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InputOutputControl {

  /**
   * src/.../path/to/file<b>/<b/>
   */
  public static String path;
  /**
   * [FILENAME].txt
   */
  public static String filename; //filename .txt
  /**
   * if append = true: <b>append</b> to file <p>
   * if append = false: <b>overwrite</b> file
   */
  public static boolean append = true;

  /**
   * Deletes all the file-content but not the file itself.
   */
  public static void deleteCompleteFileContentButNotFile() {
    try (Writer out = new FileWriter(path + filename, false)) {
      out.write(""); //

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * @return return each line as String into String[]. The function does <b>NOT</b> split the string by , or ;
   * <p>Example: <p>
   * 0 = "A,B,C;" <p>
   * 1 = "D,E,F,G,H;"
   */
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

  /**
   * Each method-call inserts the whole list in one single line
   *
   * @param objects <p>
   *                Example list: <p>
   *                [0] = A, [1] = B, [2] = C;  -- call saveContent() <p>
   *                [0] = D ...                 -- call saveContent()
   *                <p>
   *                ... generates output in file: <p>
   *                A,B,C;  <p>
   *                D,E,F,G,H;
   * @implSpec Creates new file if File doesn't exist
   */
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

  /**
   * Use:  LinkedList < String[] > l = loadContent();
   *
   * @return LinkedList < String[] >
   */
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

  /**
   * @param path        - path + filename
   * @param regex       - char or String which should be replaced
   * @param replacement - String that replaces the regex
   *                    <p>
   *                    replaceRegexWithString(<p>InputOutputControl.path + InputOutputControl.filename,
   *                    <p>"Hans", "Jürgen");
   *                    <p>ersetzt alle "Hans" mit "Jürgen"</p>
   */
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
