package AA_Klausuren.Probeklausr_SnatChat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnatChatRoom {

  private List<SnatChatFrontend> accounts = new LinkedList<>();
  private String roomName;

  public SnatChatRoom(String roomName) {
    this.roomName = roomName;
    IOControll.path = "src/AA_Klausuren/Probeklausr_SnatChat/";
    IOControll.filename = roomName + ".txt";
  }

  public String getRoomName(){
    return roomName;
  }

  public void register(SnatChatFrontend s){
    accounts.add(s);
    String log ="";
    for (int i = 0; i < IOControll.getAllLinesAsStringArray().length; i++) {
      if(i < 10){
        log = Message.rot13(IOControll.getAllLinesAsStringArray()[i]);
        s.recieveMessage(log);
      }
    }
  }
  public void unregister(SnatChatFrontend s){
    accounts.remove(s.getAccount());

  }
  public void sendMessage(Message msg){
    for (SnatChatFrontend client: accounts) {
      client.receiveMessage(msg);
    }
    writeToTextFile(msg.getText());
  }
  public void sendMessage(String text){
    for (SnatChatFrontend client: accounts) {
      client.recieveMessage(text);
    }
    writeToTextFile(text);
  }
  private void writeToTextFile(String text){
    String encodedText = Message.rot13(text);
    IOControll.saveString(encodedText +"\n", true);

  }
}
