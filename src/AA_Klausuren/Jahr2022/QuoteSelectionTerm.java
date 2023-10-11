package AA_Klausuren.Jahr2022;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuoteSelectionTerm implements Runnable {
  private List <Quote> quotes = new ArrayList<>();
  private int rows= 0, cols =0;
  private JLabel label_aufforderung = new JLabel ("Pick a quote: ");
  private int points = 10;
  private JLabel label_points = new JLabel (points + " Points");

  private int turn = 0;
  boolean isRunning = false;
  private List<QuoteButton> btns = new ArrayList<>();

  private QuoteButton cur_btn = new QuoteButton();

  public QuoteSelectionTerm(List<Quote> p_quotes, int rows, int cols) throws FakeNewsException {
    this.rows = rows;
    this.cols = cols;

    if(p_quotes.size() < rows*cols){
      throw new FakeNewsException();
    }
    Random r = new Random();
    for (int i = 0; i < p_quotes.size(); i++) {
      int randInt = r.nextInt(0,p_quotes.size());
      Quote q = p_quotes.get(randInt);
      quotes.add(q);
      p_quotes.remove(r.nextInt(0,p_quotes.size()));
    }


    // put these objects in a class scope if there are problems
    JFrame frame = new JFrame();
    JPanel topPane = new JPanel();
    topPane.add(label_aufforderung);

    JPanel centerPane = new JPanel();
    for (int i = 0; i < rows; i++) {
      for(int k = 0; k <cols; k++) {
        var btn = new QuoteButton();
        btn.addActionListener(e -> {
          cur_btn = btn;
          clients.get(turn).setQoute(quotes.get(0));
          quotes.remove(0);
          if(turn < clients.size()-1) turn++;
          else turn = 0;
        });
        btns.add(btn);
        centerPane.add(btn);
      }
    }



    JPanel bottomPane = new JPanel();
    bottomPane.add(label_points);

    centerPane.setLayout(new GridLayout(3, 4, 2, 2));
    frame.setLayout(new BorderLayout());
            /* other Layouts:
                - BorderLayout
                - BoxLayout
                - CardLayout
                - FlowLayout
                - GridBagLayout
                - GridLayout      new GridLayout(4, 2, 2, 2)
                - GroupLayout
             */

    frame.add(topPane, BorderLayout.PAGE_START);
    frame.add(centerPane, BorderLayout.CENTER);
    frame.add(bottomPane, BorderLayout.PAGE_END);

    frame.setTitle("FakeTalk");
     //frame.setSize(1000, 500);
    frame.pack(); // auto sizing
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
  private List<FakeTalkClient> clients = new ArrayList<>();
  void register(FakeTalkClient client) throws FakeNewsException {
    if(!isRunning)
      clients.add(client);
    else throw new FakeNewsException("Game is already running");
  }

  void start() throws FakeNewsException {

    if(clients.size()<2){
      throw new FakeNewsException("Not enough players");
    }else{
      if(!isRunning){
        isRunning = true;
        label_aufforderung.setText("Pick a quote: " + clients.get(turn).getPlayerName());
      }
    }

    //Thread
    thread= new Thread(this);
    thread.start();
  }

  void answerSelected(FakeTalkClient client, Quote q, QuoteType selectedType){
    String msg = "This quote is" + selectedType.getLabel() + "!\n" + q.getCitation();
    JOptionPane.showMessageDialog(null, msg);

    isRunningThread = false; // Beende den aktuellen Thread

    IOControll.path = "src/AA_Klausuren/Jahr2022/";
    IOControll.filename = "fake-score.txt";

    //Write line
    IOControll.saveString(msg+"\n", true);

    cur_btn.setType(selectedType);
    label_aufforderung.setText("Pick a quote: " + clients.get(turn).getPlayerName());


    if(selectedType == q.getQuoteType()){
      client.addPoints(points);

    }
    else{
      client.addPoints(-points);
    }
    points = 10;
    thread = new Thread(this);
    isRunningThread = true;
    thread.start();

  }

  /*TODO: implements Runnable
//How to start thread:
    thread = new Thread(this);
    isRunningThread = true;
    thread.start();
// Beende den aktuellen Thread
  isRunningThread = false;
  ..setze Standardwerte

   */
  Thread thread;

  private volatile boolean isRunningThread = true;

  @Override
  public void run() {
    int times = points;
    for (int i = 0; i < times; i++) {
      try {
        if (!isRunningThread) {
          System.out.println("Thread beendet.");
          return;
        }

        //Do some other things
        System.out.println(times - i);

        label_points.setText(points+ " Points");

        Thread.sleep(1000); // 1000 Millisekunden warten
        if(points == 1){
          break;
        }
        points--;
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }

    System.out.println("End of thread " + this.toString());
  }

}
