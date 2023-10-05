package A_26_Aufzählungstypen_Enum;

public enum Test {

  DIAMONDS("A");

  private final String name;

  private Test(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

}
