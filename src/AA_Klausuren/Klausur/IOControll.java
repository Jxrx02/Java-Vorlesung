package AA_Klausuren.Klausur;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IOControll {

  /**
   * src/.../path/to/file<b>/<b/>
   */
  public static String path;
  /**
   * if append = true: <b>append</b> to file <p>
   * if append = false: <b>overwrite</b> file
   */
  public static boolean append = true;
  /**
   * [FILENAME].txt
   */
  public static String filename; //filename .txt

  /**
   * Deletes all the file-content but not the file itself.
   */
  public static void clearFileContent() {
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
  public static String[] getAllLinesAsStringArray() {
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
   * @return line at index
   */
  public static String getLine(int index) {
    return getAllLinesAsStringArray()[index];
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
  public static void saveList(LinkedList<String> objects) {
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
  public static LinkedList<String[]> loadFileAsList() {
    List<String[]> entry = new LinkedList<>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(IOControll.path + IOControll.filename));
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

  public static void saveString(String content, boolean append) {
    try {
      var fileWriter = new FileWriter(path + filename, append);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      // Schreiben Sie den String in die Datei
      bufferedWriter.write(content);

      // Schließen Sie den BufferedWriter, um Ressourcen freizugeben
      bufferedWriter.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public static void deleteFile() {
    File file = new File(path + filename);
    file.delete();
    if (file.exists() && file.delete()) System.out.println("Deleted successfully");
    else
      System.out.println("Something went wrong when deleting " + file.getAbsolutePath());
  }

  public static Boolean isInFile(String search) {
    var file = new File(path + filename);
    boolean gefunden = false;


    for (int i = 1; i <= List.of(getAllLinesAsStringArray()).size(); i++)
      try {
        if (getLine(i).contains(search)) {
          gefunden = true;
          break;
        }
      } catch (Exception e) {
        return false;
      }
    return gefunden;
  }

  public static void main(String[] args) {
    path = "src/AA_Klausuren/Klausur/";
    filename = "test.txt";

    //Write line
    saveString("hi\n", true);

    //Save List
    LinkedList<String> s = new LinkedList<>();
    s.add("ABC");
    s.add("XYZ");
    s.add("LM");
    s.add("{EFG}");
    s.add("{HIJ}");
    s.add("LM");

    //InputOutputControl.replaceRegexWithString(path + filename, "ABC", "abc");

    //Save List
    //InputOutputControl.saveList(s);

    //Load List
    LinkedList<String[]> l = IOControll.loadFileAsList();

    //print each element from each StringArray from List
    for (String[] array : l) for (String element : array) System.out.println(element);

    //Load lines just for fun
    String[] lines = IOControll.getAllLinesAsStringArray();

  }


}
