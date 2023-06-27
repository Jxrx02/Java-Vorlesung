package A_27_Threads.Excercises;

import A_24_Draw.Examples.FirstPaint4;

import javax.swing.*;
import java.awt.*;


public class DancingText extends JComponent implements Runnable {

    Thread runner;

    public DancingText() {
        this.runner = new Thread(this);
        this.runner.start();

    }
    @Override
    protected void paintComponent(Graphics g) {
        // The text
        g.setColor(Color.BLACK);
        g.setFont(new Font("Helvetica", Font.BOLD, 40));

        String text = "Dancing Text :-)";

        for(int i=0; i < text.length();i++){
            g.drawString(String.valueOf(text.charAt(i)), 20*i,(int) (Math.random()*40) + 30);
        }
    }
    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(100);
                //System.out.println("Repaint");
            } catch (InterruptedException ex) { }
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Dancing Text");
        f.add(new DancingText());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(370, 160);
        f.setVisible(true);
    }
}


