package A_24_Draw.Examples;

import java.awt.*;
import javax.swing.*;

public class FirstPaint4  extends JComponent{

    @Override
    protected void paintComponent(Graphics g) {
// The pink oval
        g.setColor(Color.PINK);
        g.fillOval(10, 10, 330, 100);
        g.setColor(Color.RED);
        g.drawOval(10, 10, 330, 100);
        g.drawOval(9, 9, 332, 102);
        g.drawOval(8, 8, 334, 104);
        g.drawOval(7, 7, 336, 106);
// The text
        g.setColor(Color.BLACK);
        g.setFont(new Font("Helvetica", Font.BOLD, 40));
        g.drawString("Hello World", 40, 75);
    }
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Second Paint");
        f.add(new FirstPaint4());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(370, 160);
        f.setVisible(true);
    }
}
