package AA_Klausuren.Jahr2016;

import java.util.List;
import java.util.Random;

public enum ColumnType {

  CITY("Stadt"),
  COUNTRY("Land"),
  RIVER("Fluss"),
  PROFESSION("Beruf"),
  ANIMAL("TIER"),
  NAME("Vorname"),
  SPORT("Sportart"),
  FOOD("Lebensmittel"),
  BEVERAGE("Getränk"),
  GAME("Spiel")
  ;

  private final String name;

  ColumnType(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("%s", name);

  }

  public static ColumnType getRandomElement(){
    Random r  = new Random();
    List<ColumnType> allElements= List.of(ColumnType.values());
    return allElements.get(r.nextInt(0,allElements.size()));
  }

}
