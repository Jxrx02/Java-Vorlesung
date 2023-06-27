package A_20_UI.layouts;

import java.awt.*;
import javax.swing.*;
public class BorderLayoutDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //        f.setLayout(new BorderLayout(15, 5));
        f.setLayout(new BorderLayout(5, 5));
        f.add(new JButton("Naughty"), BorderLayout.NORTH);
        f.add(new JButton("Elephants"), BorderLayout.EAST);
        f.add(new JButton("Spray"), BorderLayout.SOUTH);
        f.add(new JButton("Water"), BorderLayout.WEST);
        f.add(new JButton("Center"));
        f.setSize(400, 150);
        f.setVisible(true);
    }
}