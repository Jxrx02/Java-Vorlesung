package AA_Klausuren.Jahr2019;

import javax.swing.*;

public class JToggleCard extends JToggleButton {

  private Icon icon;
  private boolean archived;

  public JToggleCard(Icon icon) {
    super(icon);
    this.icon = icon;
  }

  public Icon getCardIcon() {
    return icon;
  }

  public boolean isArchived() {
    return archived;
  }

  public void setArchived(boolean archived) {
    this.archived = archived;
  }

  public void setCardIcon(Icon icon) {
    this.icon = icon;
  }
}
