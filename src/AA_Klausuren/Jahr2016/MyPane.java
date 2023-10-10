package AA_Klausuren.Jahr2016;

import javax.swing.*;
import java.awt.*;

public class MyPane extends JPanel{
  public ColumnType getType() {
    return type;
  }

  private ColumnType type;
  private JTextField textField;
  private JLabel label_points;
  public String getTextField(){
    return textField.getText();
  }

  public void setLabel_points(String label_points) {
    this.label_points.setText(label_points);
  }

  public MyPane(String labelText, ColumnType type) {
    this.type = type;
    this.setLayout(new GridLayout(1,3,2,2));
    JLabel label_title = new JLabel (labelText);
    textField = new JTextField("");
    textField.setColumns(8);

    label_points = new JLabel ("0");
    this.add(label_title);
    this.add(textField);
    this.add(label_points);
  }
}
