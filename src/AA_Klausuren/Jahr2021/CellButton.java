package AA_Klausuren.Jahr2021;

import javax.swing.*;
import java.awt.*;

class CellButton extends JButton {

  private double dose = 0;
  private boolean polluter;

  CellButton(double dose, boolean polluter) {
    this.dose = dose;
    this.setText(String.valueOf(dose));
    Chorona.updateButtonForDose(this, dose);

    this.polluter = polluter;
    if (polluter) this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

  }

  double getDose() {
    return dose;
  }

  public void setDose(double dose) {
    this.dose = dose;
    Chorona.updateButtonForDose(this, dose);

    this.setText(String.valueOf(dose));
    setBackground(Chorona.getColorForDose(dose));
    Chorona.updateButtonForDose(this, dose);
  }
}
