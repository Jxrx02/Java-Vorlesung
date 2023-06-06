package Draw.Examples;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JComponent;


public class FirstPaint2 extends JFrame {
    public FirstPaint2() {
        this.setTitle("First Paint 2");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new DrawComponent());
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new FirstPaint2();
    }
}

class DrawComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Hello World", 25, 50);
    }
}
