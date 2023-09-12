package AA_Klausuren.Jahr2021;

public interface IRoom {
  double getDose(int x, int y);

  void setDose(int x, int y, double dose);

  void addDose(int x , int y, double dose);

  void step();

}
