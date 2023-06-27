package A_24_Draw.Examples;

import java.awt.Graphics;
import javax.swing.JFrame;
public class FirstPaint3 extends JFrame {
    public FirstPaint3() {
        this.setTitle("First Paint 3"); this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    // Zeichnen direkt in JFrame (nicht in hinzugefügte Komponente)
// daher direktes Überschreiben der Methode paint!
    @Override
    public void paint(Graphics g) {
// super.paint(g); // Darstellung enthaltener Komponenten
        g.clearRect(0,0,this.getWidth(),this.getHeight());
        g.drawString("Hello World", 25, 50);
    }
    public static void main(String[] args) {
        new FirstPaint3();
    }
}