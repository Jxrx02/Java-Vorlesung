package A_20_UI;

import javax.swing.*;
import java.awt.event.ItemEvent;

public class Components_Frame extends JFrame implements Runnable {

  public Components_Frame() {
    //JPANEL
    JPanel panel = new JPanel();

    //label
    JLabel label = new JLabel("JLabel");
    panel.add(label);

    //textfeld
    JTextField textField = new JTextField("JTextField");
    textField.setColumns(8);
    panel.add(textField);

    //password-feld
    JPasswordField pwField = new JPasswordField();
    pwField.setColumns(8);
    panel.add(pwField);

    //button mit tooltip
    JButton btn = new JButton("JButton");
    btn.setToolTipText("Button Example");
    panel.add(btn);


    //toogle-button
    JToggleButton btn_toogle = new JToggleButton("JToggleButton");
    panel.add(btn_toogle);

    //check-box
    JCheckBox checkbox = new JCheckBox("JCheckBox");
    checkbox.addItemListener(e -> {
      if (e.getStateChange() == ItemEvent.SELECTED) System.out.println("button is selected");
      if (e.getStateChange() == ItemEvent.DESELECTED) System.out.println("button deselected");
    });
    panel.add(checkbox);

    //combo-box-dropdown
    String comboBoxListe[] = {
            "Baden-Württemberg", "Bayern",
            "Berlin", "Brandenburg", "Bremen",
            "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
            "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
            "Saarland", "Sachsen", "Sachsen-Anhalt",
            "Schleswig-Holstein", "Thüringen"
    };
    //for (int i = 0; i < 16; i++) comboBoxListe[i] = "item" + comboBoxListe[i];
    JComboBox comboBox = new JComboBox(comboBoxListe);
    panel.add(comboBox);


    //radiobutton
    ButtonGroup buttonGroup = new ButtonGroup();            //für 1 anklickbaren button
    for (int i = 0; i < 3; i++) {
      JRadioButton radio = new JRadioButton("Radio-Button-" + (i + 1));
      buttonGroup.add(radio);
      panel.add(radio);
    }


    this.add(panel);

    // Setze die Größe und Sichtbarkeit des JFrame
    this.setSize(400, 300);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Several basic swing components");
  }

    public static void main(String[] args) {
    // Erstelle ein neues JFrame
    Components_Frame frame = new Components_Frame();
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}