package AA_Klausuren.Jahr2022;

import javax.swing.*;

public class QuoteButton extends JButton {
  private QuoteType type;

  public QuoteButton() {
    this.type = QuoteType.UNKNOWN;
    setType(type);
  }

  public void setType(QuoteType type) {
    this.type = type;
    setIcon(type.getIcon());
    setBackground(type.getColor());
    switch (type){
      case UNKNOWN -> setBackground(QuoteType.UNKNOWN.getColor());
      case HOT_SHIT -> setBackground(QuoteType.HOT_SHIT.getColor());
      case BULLSHIT -> setBackground(QuoteType.BULLSHIT.getColor());
    }

  }

  public boolean isUnknown(){
    return type==QuoteType.UNKNOWN?true:false;
  }
}
