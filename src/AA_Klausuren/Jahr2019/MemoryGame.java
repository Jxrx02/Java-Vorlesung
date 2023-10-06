package AA_Klausuren.Jahr2019;


import java.util.ArrayList;
import java.util.List;

public class MemoryGame {
  private int rows, cols;
  private List<Player> playerList;

  private List<MemoryImages.MemoryImage> memoryImages = new ArrayList<>();
  private int playerTurn;
  private boolean isBlank = false;

  public MemoryGame(List<Player> players, List<MemoryImages.MemoryImage> images, int rows, int cols) throws MemoryException {
    this.rows = rows;
    this.cols = cols;
    this.playerList = players;
    this.playerList.get(0).setStatus(PlayerStatus.ACTIVE);

    if (playerList.size() < 2) throw new MemoryException("At least two players required");

    float x = ((rows * cols) / 2);
    if (x % 2 != 0) {
      x++;
      isBlank = true;
    }
    int y = (int) x;

    if ((images.size() < y)) throw new MemoryException("Too few images available");
    else for (int i = 0; i < y; i++) memoryImages.add(images.get(i));
  }

  public Player getCurrentPlayer() {
    return playerList.get(playerTurn);
  }

  public void nextPlayer() {
    if (playerTurn < playerList.size() - 1) {
      playerList.get(playerTurn).setStatus(PlayerStatus.WAITING);
      playerTurn++;
      playerList.get(playerTurn).setStatus(PlayerStatus.ACTIVE);
    } else {
      playerList.get(playerTurn).setStatus(PlayerStatus.WAITING);
      playerTurn = 0;
      playerList.get(playerTurn).setStatus(PlayerStatus.ACTIVE);

    }
  }

  public boolean isBlankRequired() {
    return isBlank;
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }

  public int getCols() {
    return cols;
  }

  public void setCols(int cols) {
    this.cols = cols;
  }

  public List<Player> getPlayerList() {
    return playerList;
  }

  public void setPlayerList(List<Player> playerList) {
    this.playerList = playerList;
  }

  public List<MemoryImages.MemoryImage> getMemoryImages() {
    return memoryImages;
  }

  public void setMemoryImages(List<MemoryImages.MemoryImage> memoryImages) {
    this.memoryImages = memoryImages;
  }
}