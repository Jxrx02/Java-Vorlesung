package A_20_UI.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JColorChooserDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b = new JButton("Change color");
        f.add(b);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComponent comp = (JComponent) e.getSource();
                Color newColor = JColorChooser.showDialog(
                        null, "Choose a new color", comp.getBackground());
                comp.setBackground(newColor);
            }
        });
        f.pack();
        f.setVisible(true);
    }
}
