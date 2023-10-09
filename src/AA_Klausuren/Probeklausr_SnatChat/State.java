package AA_Klausuren.Probeklausr_SnatChat;

public enum State {

  AVAILABLE("Available“"),
  AWAY("Away"),
  DND("Do not disturb");

  private final String name;

  State(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("%s", name);

  }

}
