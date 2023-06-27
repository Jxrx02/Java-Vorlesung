package A_20_UI.examples;

import javax.swing.*;

public class Template extends JFrame {

    public Template(){

        //JPANEL
        JPanel panel = new JPanel();

        //label
        JLabel label = new JLabel("JLabel");
        panel.add(label);


        this.add(panel);

        // Setze die Größe und Sichtbarkeit des JFrame
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Several basic swing components");

    }


    public static void main(String[] args) {
        // Erstelle ein neues JFrame
        Template frame = new Template();
    }
}
