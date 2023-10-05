package AA_Klausuren.Jahr2019;

import java.awt.*;

public enum PlayerStatus {

  ACTIVE(Color.ORANGE),
  WAITING(Color.BLACK),
  FINISHED(Color.GRAY);

  private final Color color;

  PlayerStatus(Color color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return String.format("%s", color);
  }

}
