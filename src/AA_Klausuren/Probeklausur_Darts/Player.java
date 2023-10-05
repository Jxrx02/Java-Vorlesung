package AA_Klausuren.Probeklausur_Darts;

public class Player {

  Visit[] visit = new Visit[10];
  private String name;
  private int countDartsThrown;

  Player(String pName) {
    this.name = pName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCountDartsThrown() {
    return countDartsThrown;
  }

  public void setCountDartsThrown(int countDartsThrown) {
    this.countDartsThrown = countDartsThrown;
  }

  public Visit[] getVisit() {
    return visit;
  }

  public void setVisit(Visit[] visit) {
    this.visit = visit;
  }

  public int getRemainingPoints() {
    int y = 0;
    for (int i = 0; i < visit.length; i++) y += visit[i].getValue();
    return 501 - y;
  }

  public boolean addVisit(Visit pvisit) {

    if ((getRemainingPoints() - pvisit.getValue() > 0) || ((pvisit.getLastField().getValue() == 2) && (getRemainingPoints() - pvisit.getValue() > 0))) {

      countDartsThrown += getVisit().length;
      return true;
    } else return false;
  }
}
