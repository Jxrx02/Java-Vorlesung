package A_27_Threads.Excercises;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrafficLight extends JComponent implements Runnable {

    Thread runner;
    static ArrayList<LightPhase> phases = new ArrayList<LightPhase>();
    static int currentWaitDuration;
    static int i= 0; //next
    public TrafficLight() {
        this.runner = new Thread(this);
        this.runner.start();

    }
    @Override
    protected void paintComponent(Graphics g) {

        // Draw TrafficLight
        g.setColor(Color.BLACK);
        g.fillRect(10,10,100,300);

        for(int j = 0; j < phases.size(); j++){
            currentWaitDuration = phases.get(i).getDuration();

            //reset
            g.setColor(Color.white);
            g.fillOval(10,10,100,100);
            g.fillOval(10,110,100,100);
            g.fillOval(10,210,100,100);


            if(phases.get(i).isRed()){
                g.setColor(Color.RED);
                g.fillOval(10,10,100,100);
            }
            if(phases.get(i).isYellow()){
                g.setColor(Color.YELLOW);
                g.fillOval(10,110,100,100);
            }
            if(phases.get(i).isGreen()){
                g.setColor(Color.GREEN);
                g.fillOval(10,210,100,100);
            }
        }


    }
    public void run() {
        while (true) {
            try {
                if(i<phases.size()-1)
                    i++;
                else i =0;
                repaint();
                Thread.sleep(currentWaitDuration);

                //System.out.println("Repaint");
            } catch (InterruptedException ex) { }
        }
    }

    public static void main(String[] args) {

        LightPhase red = new LightPhase("red",true,false,false,4000);
        LightPhase rotgelb = new LightPhase("rotgelb",true,true,false,1000);
        LightPhase grün = new LightPhase("grün",false,false,true,2000);
        LightPhase gelb = new LightPhase("gelb",false,true,false,3000);

        phases.add(red);
        phases.add(rotgelb);
        phases.add(grün);
        phases.add(gelb);

        JFrame f = new JFrame();
        f.setTitle("Traffic Light");
        f.add(new TrafficLight());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(320, 400);
        f.setVisible(true);
    }
}


class LightPhase {
    private String name;
    private boolean red;
    private boolean yellow;
    private boolean green;
    private int duration;

    public LightPhase(String name, boolean red, boolean yellow, boolean green, int duration ) {
        this.name = name;
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public boolean isRed() {
        return red;
    }

    public boolean isYellow() {
        return yellow;
    }

    public boolean isGreen() {
        return green;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "LightPhase{" +
                "name='" + name + '\'' +
                ", red=" + red +
                ", yellow=" + yellow +
                ", green=" + green +
                ", duration=" + duration +
                '}';
    }
}

