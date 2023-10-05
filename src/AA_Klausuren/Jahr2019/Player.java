package AA_Klausuren.Jahr2019;

public class Player {
  private String name;
  private int points;
  private PlayerStatus status;

  public Player(String name) {
    this.name = name;
    points = 0;
    status = PlayerStatus.WAITING;
  }

  public void addPoint() {
    points++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public PlayerStatus getStatus() {
    return status;
  }

  public void setStatus(PlayerStatus status) {
    this.status = status;
  }
}