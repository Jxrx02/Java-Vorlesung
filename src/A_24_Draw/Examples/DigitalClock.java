package A_24_Draw.Examples;

import java.awt.*;
import java.util.Date;
import javax.swing.*;
public class DigitalClock extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.setFont(new Font("Consolas", Font.BOLD, 24));
        Date theDate = new Date();
        g.drawString(theDate.toString(), 50, 50);
    }
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new DigitalClock());
        f.setTitle("Date and Time");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 120);
        f.setVisible(true);
    }
}