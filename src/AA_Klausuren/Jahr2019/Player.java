package AA_Klausuren.Jahr2019;

public class Player {
  private String name;
  private int points;
  private PlayerStatus status;

  public Player(String name) {
    this.name = name;
    points = 0;
  }

  public void addPoint() {
    points++;
  }
}