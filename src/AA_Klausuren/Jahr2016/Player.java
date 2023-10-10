package AA_Klausuren.Jahr2016;

public class Player {
  private String name;
  private int punktzahl;
  private ColumnType columnType;
  public Player(String name) {
    this.punktzahl = 0;
    this.name = name;
  }



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPunktzahl() {
    return punktzahl;
  }

  public void setPunktzahl(int punktzahl) {
    this.punktzahl = punktzahl;
  }

  public ColumnType getColumnType() {
    return columnType;
  }

  public void setColumnType(ColumnType columnType) {
    this.columnType = columnType;
  }
}
