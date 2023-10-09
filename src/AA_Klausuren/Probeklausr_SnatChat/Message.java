package AA_Klausuren.Probeklausr_SnatChat;

public class Message {
  private Account account;
  private String text;

  public Message(Account account, String text) {
    this.account = account;
    this.text = text;
  }

  public static String rot13(String message){
    var x = new StringBuilder();
    for (int i = 0; i < message.length(); i++) {
      char c = message.charAt(i);
      if(c>=65 && c< 65+13 || c>=97 && c<97+13)
        c+=13;
      else if(c>=78 && c <= 90|| c>=110 && c<=122 ) {
        c-=13;
      }

      x.append(c);
    }
    return x.toString();
  }



  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
