package AA_Klausuren.Klausur;


import java.util.LinkedList;

public class Test {
  public static void main(String[] args) {

    IOControll.path = "src/AA_Klausuren/Klausur/";
    IOControll.filename = "test.txt";

    //Write line
    //IOControll.saveString("hi\n", true);

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
    IOControll.saveList(s);

    //Load List
    LinkedList<String[]> l = IOControll.loadFileAsList();

    //print each element from each StringArray from List
    for (String[] array : l) for (String element : array) System.out.println(element);

    //Load lines just for fun
    String[] lines = IOControll.getAllLinesAsStringArray();

    System.out.println(IOControll.isInFile("LM"));
  }
}