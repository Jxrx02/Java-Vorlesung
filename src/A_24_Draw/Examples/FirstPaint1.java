package A_24_Draw.Examples;

import java.awt.Graphics;
import javax.swing.*;

public class FirstPaint1 extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Hello World", 25, 50);
    }
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("First Paint");
        f.add(new FirstPaint1());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}