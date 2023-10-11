package AA_Klausuren.Jahr2016;

import AA_Klausuren.Klausur.IOControll;

import javax.swing.*;
import java.util.*;



public class Game {

  private int spieldauer;
  private boolean running;
  private char Anfangsbuchstabe;


  private ColumnType[] columnType;
  private int min, max;
  List<Sheet> playerSheets = new LinkedList<>();

  public Game(int min, int max, int seconds) {
    this.spieldauer = seconds;
    this.max = max;
    this.min = min;
    if(min >=3 || max>= min){
      columnType = new ColumnType[3];
    }


  }

  public void register(Sheet sheet) {
    playerSheets.add(sheet);
  }

  public void startGame(){
    if(!running){
      running = true;
      setAnfangsbuchstabe(createFirstCharacter());
      columnType = createColumns();
      for (Sheet sheet: playerSheets) {
        sheet.gameStart();
      }
    }
  }

  public void stopGame(){
    if(running)
    {
      running = false;
      auswertung();
      for (Sheet sheet: playerSheets) {
        sheet.gameEnds();
      }

    }
  }

  public void auswertung(){
    boolean hasSingleValue = true;
    for (int i = 0; i < playerSheets.size(); i++) {

      LinkedList<MyPane> panes= playerSheets.get(i).getPanes();
      for(int j = 0; j < panes.size(); j++) {
        for (int k = 0; k < playerSheets.size(); k++) {
          if(panes.get(j).getTextField() == playerSheets.get(k).getPanes().get(j).getTextField()){
            hasSingleValue = false;
          }
        }

        if(hasSingleValue){
          //add 20
          if(isCorrect(panes.get(i).getTextField(), String.valueOf(panes.get(i).getType()))){
            playerSheets.get(i).getPlayer().setPunktzahl(playerSheets.get(i).getPlayer().getPunktzahl() + 20);
            playerSheets.get(i).getPanes().get(i).setLabel_points(String.valueOf(playerSheets.get(i).getPlayer().getPunktzahl()));

          }
          else {
            //add 10
            playerSheets.get(i).getPlayer().setPunktzahl(playerSheets.get(i).getPlayer().getPunktzahl() + 10);
            playerSheets.get(i).getPanes().get(i).setLabel_points(String.valueOf(playerSheets.get(i).getPlayer().getPunktzahl()));

          }
        }
        else{
          if(isCorrect(panes.get(i).getTextField(), String.valueOf(panes.get(i).getType()))){
            //add 5
            playerSheets.get(i).getPlayer().setPunktzahl(playerSheets.get(i).getPlayer().getPunktzahl() + 5);
            playerSheets.get(i).getPanes().get(i).setLabel_points(String.valueOf(playerSheets.get(i).getPlayer().getPunktzahl()));
    
          }
        }
      }

      hasSingleValue = true;
    }
  }
  
  private boolean isCorrect(String text, String cat){
    if(text.length()<1)
      return false;

    if(text.toCharArray()[0] != getAnfangsbuchstabe())
      return false;

    IOControll.path = "src/AA_Klausuren/Jahr2016/";
    IOControll.filename = "validwords.txt";
    LinkedList<String[]> l = IOControll.loadFileAsList();
    if(l.contains(text))
      return true;
    else {

      //Yes No Cancel
      int result = JOptionPane.showConfirmDialog(null, String.format("Ist '%s' korrekt für Kategorie '%s'", text,cat));
      if (result == JOptionPane.YES_OPTION) {
        //yes
        IOControll.saveString(text+"\n", true);
        return true;
      } else if (result == JOptionPane.NO_OPTION) {
        //no
        return false;

      } else {
        //cancel
        return false;
      }
    }

  }


  private char createFirstCharacter(){
    Random r = new Random();
    char x = (char) r.nextInt(65,91);
    return x;
  }
  private ColumnType[] createColumns(){
    Random r = new Random();
    LinkedList<ColumnType> cols = new LinkedList<>();
    cols.add(ColumnType.CITY);
    cols.add(ColumnType.COUNTRY);
    cols.add(ColumnType.RIVER);
    if(min-3>0){
      for (int i = 0; i < r.nextInt(min-1,max-1); i++) {
        ColumnType ct = ColumnType.getRandomElement();
        if(!cols.contains(ct))
          cols.add(ct);
      }
    }


    return cols.toArray(new ColumnType[0]);
  }



  public int getSpieldauer() {
    return spieldauer;
  }

  public void setSpieldauer(int spieldauer) {
    this.spieldauer = spieldauer;
  }

  public boolean isRunning() {
    return running;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }

  public char getAnfangsbuchstabe() {
    return Anfangsbuchstabe;
  }

  public void setAnfangsbuchstabe(char anfangsbuchstabe) {
    Anfangsbuchstabe = anfangsbuchstabe;
  }
  public ColumnType[] getColumnType() {
    return columnType;
  }


}
