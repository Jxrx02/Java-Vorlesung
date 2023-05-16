package UI;

import javax.swing.*;

public class Components_Frame extends JFrame {
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
        JToggleButton btn_toogle= new JToggleButton("JToggleButton");
        panel.add(btn_toogle);

        //check-box
        JCheckBox checkbox = new JCheckBox("JCheckBox");
        panel.add(checkbox);

        //combo-box-dropdown
        String comboBoxListe[] = new String[100];/* = {"Baden-Württemberg", "Bayern",
                "Berlin", "Brandenburg", "Bremen",
                "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
                "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
                "Saarland", "Sachsen", "Sachsen-Anhalt",
                "Schleswig-Holstein", "Thüringen"};*/
        for(int i = 0;i <100;i++){
            comboBoxListe[i] = "item" + i;
        }
        JComboBox comboBox = new JComboBox(comboBoxListe);
        panel.add(comboBox);


        //radiobutton
        ButtonGroup buttonGroup = new ButtonGroup();            //für 1 anklickbaren button
        for(int i =0;i<3;i++){
            JRadioButton radio = new JRadioButton("Radio-Button-"+(i+1));
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
}