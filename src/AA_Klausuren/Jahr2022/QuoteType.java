package AA_Klausuren.Jahr2022;

import javax.swing.*;
import java.awt.*;

public enum QuoteType {

  UNKNOWN("Unknown",FakeTalkIcons.ICON_UNKNOWN,Color.LIGHT_GRAY),
  HOT_SHIT("Hot shit",FakeTalkIcons.ICON_HOT_SHIT, Color.GREEN),
  BULLSHIT("Bullshit", FakeTalkIcons.ICON_BULLSHIT, new Color(74,65,42));

  private final String label;
  private final ImageIcon icon;
  private final Color color;



  QuoteType(String label, ImageIcon iconUnknown, Color color) {
    this.label = label;
    this.icon = iconUnknown;
    this.color = color;
  }

  public String getLabel() {
    return label;
  }

  public ImageIcon getIcon() {
    return icon;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public String toString() {
    return "QuoteType{" +
            "label='" + label + '\'' +
            ", icon=" + icon +
            ", color=" + color +
            '}';
  }
}
