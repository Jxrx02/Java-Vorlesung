package Draw.Examples;

import java.awt.*;
import javax.swing.*;
public class FirstShapes extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.drawRect(30, 30, 80, 40);
        g.drawOval(120, 30, 50, 50);
        g.setColor(Color.BLACK);
        g.fillRect(30, 100, 80, 40);
        g.fillOval(120, 100, 50, 50);
        g.drawLine(30, 160, 130, 170);
        g.drawArc(30, 180, 50, 50, 60, 40);
        g.fillArc(120, 180, 50, 50, 60, 40);
    }
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new FirstShapes());
        f.setTitle("First Shapes");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300); f.setVisible(true);
    }
}