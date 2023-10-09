package AA_Klausuren.Probeklausr_SnatChat;

public interface SnatChatFrontend {
  public void receiveMessage(Message msg);
  public void recieveMessage(String text);
  public Account getAccount();
}
