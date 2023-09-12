package AA_Klausuren.Jahr2021;

import java.util.Random;

public class RoomSetting {
  private int width, height;

  private Point[] pollutants;

  public RoomSetting(int width, int height, int pollutantsamount) throws AHAException {
    this.width = width;
    this.height = height;
    Random random = new Random();
    random.nextInt(10);
    if (width * height < pollutantsamount) throw new AHAException("Insufficient singers");
    else {
      this.pollutants = new Point[pollutantsamount];
      for (int i = 0; i < pollutantsamount; i++) pollutants[i] = new Point(random.nextInt(7), random.nextInt(7));
    }


  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public Point[] getPolluters() {
    return pollutants;
  }

  public void setPolluters(Point[] pollutants) {
    this.pollutants = pollutants;
  }


}
