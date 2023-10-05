package A_27_Threads.Examples;

import javax.swing.*;
import java.util.Date;

public class ClockApp extends JFrame implements Runnable {
  private Date theDate;
  private Thread runner;
  private JTextField dateField = new JTextField();

  private ClockApp() {
    super("Digital Clock");
    this.add(this.dateField);


    // Aus Runnable ein Thread-Objekt erzeugen
    this.runner = new Thread(this);
    // Keine Abfrage auf runner==null, da in Anweisung zuvor erzeugt
    this.runner.start();
  }

  public static void main(String args[]) {
    ClockApp cap = new ClockApp();
    cap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cap.setSize(220, 70);
    cap.setVisible(true);

    for (long i = 0; ; i++) if (i % 100000000 == 0) System.out.println(i);
  }

  @Override
  public void run() {
    while (true) try {
      this.theDate = new Date();
      this.dateField.setText(this.theDate.toString());
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
    }
  }
}