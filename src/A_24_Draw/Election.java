package A_24_Draw;

import javax.swing.*;
import java.awt.*;

public class Election extends JComponent {

    private double[] data; // Array of data values
    private Color[] data_color; // Array of data values
    private String[] data_name; // Array of data values


    public Election(double[] data, Color[] data_color, String[] data_name) {
        this.data = data;
        this.data_color = data_color;
        this.data_name = data_name;
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0,0,getWidth(),(int)(getHeight()*0.1));
        g.setColor(Color.white);
        g.drawString("Bundestagswahl 2017", 15, 30);
        g.drawString("in %", getWidth()-30, 30);


        int barWidth = getWidth() / data.length;

        // Find the maximum value in the data array
        double maxDataValue = 0;
        for (double value : data) {
            if (value > maxDataValue) {
                maxDataValue = value;
            }
        }

        // Calculate the scale factor for the bars
        double scaleFactorX = (double) getHeight() / maxDataValue;

        // Draw the bars
        for (int i = 0; i < data.length; i++) {
            g.setColor(data_color[i]);
            int barHeight = (int) (data[i] * scaleFactorX);
            int x = i * barWidth;
            int y = getHeight() - barHeight;
            g.fillRect(x, y +(int)(getHeight()*0.1), barWidth, barHeight-90);
        }
            // Draw the bars with 3D effect
            /*for (int i = 0; i < data.length; i++) {
                int barHeight = (int) (data[i] * scaleFactorX);
                int x = i * barWidth;
                int y = getHeight() - barHeight;

                // Draw the front face of the bar
                g.setColor(Color.BLUE);
                g.fillRect(x, y, barWidth, barHeight);

                // Draw the top face of the bar
                g.setColor(Color.CYAN);
                g.fillPolygon(new int[]{x, x + 10, x + 10 + barWidth, x + barWidth}, new int[]{y, y - 10, y - 10, y}, 4);

                // Draw the right side of the bar
                g.setColor(Color.DARK_GRAY);
                g.fillPolygon(new int[]{x + barWidth, x + barWidth + 10, x + barWidth + 10, x + barWidth}, new int[]{y, y - 10, y - 10 + barHeight, y + barHeight}, 4);
            }*/



        // Draw the lines at 10% intervals
        g.setColor(Color.RED);
        for (int i = 0; i <= 3; i++) {
            int y = (int) (getHeight() - (i*10 * scaleFactorX)+20);
            g.drawLine(0, y, getWidth(), y);
        }

        //Write Text
        for(int i = 0; i<data.length;i++){
            int x = i * barWidth;
            g.setColor(Color.BLUE);
            g.drawString(data_name[i] + " (" + data[i] + "%)", x, getHeight()-10);
        }
    }
    public static void main(String[] args) {

        double[] data = {33.0, 20.5, 12.6, 10.7, 9.2, 8.9,5.1};                                                         // Sample data
        Color[] data_color = {Color.BLACK, Color.RED, Color.CYAN, Color.YELLOW, Color.PINK, Color.GREEN,Color.GRAY};    // Sample data
        String[] data_name = {"Union", "SPD", "AfD", "FDP", "Linke", "Grüne","Andere"};                                 // Sample data

        Election chart = new Election(data,data_color,data_name);


        JFrame f = new JFrame();
        f.setLayout(new BorderLayout());
        f.setTitle("Election");

        Panel p = new Panel();
        JLabel t = new JLabel("Balkendiagramm");
        p.add(t);
        f.add(p, BorderLayout.NORTH);
        f.add(chart, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(720, 540);
        f.setVisible(true);
    }
}
