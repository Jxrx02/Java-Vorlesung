package A_19_IO_Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSystem {

  public static String path;
  public static String fileName;

  public static void createFileIfDoesntExist(String path, String filename) {
    try {
      Files.createFile(Path.of(path + filename));
    } catch (FileAlreadyExistsException ignored) {
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void deleteFileIfExist(String path, String fileName){
    try {
      Files.deleteIfExists(Path.of(path + fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void writeToFile(String filePath, Map<String, List<String>> keyValueMap) {
    try (FileWriter writer = new FileWriter(filePath)) {
      for (Map.Entry<String, List<String>> entry : keyValueMap.entrySet()) {
        String key = entry.getKey();
        List<String> values = entry.getValue();
        StringBuilder line = new StringBuilder(key);
        for (String value : values) {
          line.append(",").append(value);
        }
        line.append(";\n");
        writer.write(line.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * @return Map with key and values:  <String, List<String>>
   */
  public static Map<String, List<String>> readFromFile(String filePath) {
    Map<String, List<String>> keyValueMap = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length >= 2) {
          String key = parts[0];
          for (int i = 1; i < parts.length; i++) {
            String value = parts[i].replace(";", "");
            keyValueMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return keyValueMap;
  }
  public static void clearFile(String path) {
    try {
      Files.writeString(Path.of(path), "");
    } catch (IOException e) {
      e.printStackTrace();
    }
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

    /**
     * WriteToFile
     */
    // Pfad und Dateiname
    path = "src/A_19_IO_Files/";
    fileName = "test.txt";
    String fullPath = path + fileName;

    // Beispielaufruf der Funktion
    Map<String, List<String>> keyValueMap = Map.of(
            "Person3", List.of("Jürgen Hans","60","Bäcker"),
            "Person1", List.of("Max Mustermann", "26", "Langzeitstudent"),
            "Person2", List.of("Erika Musterfrau", "35", "Landwirt")
    );
    writeToFile(fullPath, keyValueMap);


    /**
     * ReadFromFile
     */
    Map<String, List<String>> readkeyValueMap = readFromFile(fullPath);

    for (Map.Entry<String, List<String>> entry : readkeyValueMap.entrySet()) {
      String key = entry.getKey();
      List<String> values = entry.getValue();
      System.out.println("Key: " + key);
      System.out.println("Values: " + values);
    }

    //apply to Class
    IOSystem ioSystem = new IOSystem();
    List<Person> personList = ioSystem.readToclass();
    System.out.println(personList);


  }

  List<Person> readToclass(){
    Map<String, List<String>> readkeyValueMap = readFromFile(path+ fileName);

    List<Person> personList = new ArrayList<>();

    for (Map.Entry<String, List<String>> entry : readkeyValueMap.entrySet()) {
      String key = entry.getKey();
      List<String> values = entry.getValue();
      Person p = new Person(values.get(0), Integer.parseInt(values.get(1)), values.get(2));
      personList.add(p);

    }
    return personList;
  }


  public class Person {
    private String name;
    private int age;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getOccupation() {
      return occupation;
    }

    public void setOccupation(String occupation) {
      this.occupation = occupation;
    }

    private String occupation;

    public Person(String name, int age, String occupation) {
      this.name = name;
      this.age = age;
      this.occupation = occupation;
    }
    public Person() {
    }
  }
}