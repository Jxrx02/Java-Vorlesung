package AA_Klausuren.Probeklausur_Darts;

public class Field {
  private String label;
  private int value;
  private boolean doubleField;

  public Field(String label, int value, boolean doubleField) {
    super();
    this.label = label;
    this.value = value;
    this.doubleField = doubleField;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public boolean isDoubleField() {
    return doubleField;
  }

  public void setDoubleField(boolean doubleField) {
    this.doubleField = doubleField;
  }


}
