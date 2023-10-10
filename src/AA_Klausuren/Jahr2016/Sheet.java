package AA_Klausuren.Jahr2016;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;



public class Sheet implements Runnable{

  public Player getPlayer() {
    return player;
  }

  private Player player;
  private Game game;

  JLabel label_Punkte_count = new JLabel ("0");
  JLabel label_secs_count = new JLabel ("");
  JLabel label_letter_text = new JLabel ("");

  JButton button = new JButton("Start");
  JButton button_2 = new JButton("Stop");
  JPanel centerPane = new JPanel();
  private LinkedList<MyPane> panes = new LinkedList<>();

  public LinkedList<MyPane> getPanes() {
    return panes;
  }

  public Sheet(Player player, Game game) {
    this.player = player;
    this.game = game;
    label_letter_text.setText(String.valueOf(game.getAnfangsbuchstabe()));
    label_secs_count.setText(String.valueOf(game.getSpieldauer()));

    if(!game.isRunning()){
      button.setEnabled(true);
      button_2.setEnabled(false);
      label_Punkte_count.setText("0");
    }
    else {
      button.setEnabled(false);
      button_2.setEnabled(true);
    }

    // put these objects in a class scope if there are problems
    JFrame frame = new JFrame();
    JPanel topPane = new JPanel();
    topPane.setLayout(new GridLayout(3, 2, 2, 2));
    JLabel label_Punkte = new JLabel ("Punkte");
    JLabel label_secs = new JLabel ("Verbleibende Sekunden");
    JLabel label_letter = new JLabel ("Anfangsbuchstabe");

    topPane.add(label_Punkte);
    topPane.add(label_Punkte_count);
    topPane.add(label_secs);
    topPane.add(label_secs_count);
    topPane.add(label_letter);
    topPane.add(label_letter_text);

    //cols
    centerPane = new JPanel();








    JPanel bottomPane = new JPanel();
    ActionListener actionListener = e -> {
      //start
      game.startGame();

    };
    button.addActionListener(actionListener);
    bottomPane.add(button);

    button_2.setEnabled(false);
    button_2.addActionListener(e -> {
      //end
      game.stopGame();

      label_Punkte_count.setText(String.valueOf(player.getPunktzahl()));

    });
    bottomPane.add(button_2);

    topPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
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

    frame.setTitle(this.player.getName());
    // frame.setSize(1000, 500);
    frame.pack(); // auto sizing
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }
  Thread thread = new Thread(this);
  public void gameEnds(){
    label_Punkte_count.setText(String.valueOf(player.getPunktzahl()));
    button.setEnabled(true);
    button_2.setEnabled(false);
    thread.stop();
  }
  public void gameStart(){
    button.setEnabled(false);
    button_2.setEnabled(true);
    for (int i = 0; i < game.getColumnType().length; i++) {
      MyPane p = new MyPane(String.valueOf(game.getColumnType()[i]), game.getColumnType()[i]);
      panes.add(p);
      centerPane.add(p);
    }
    label_letter_text.setText(String.valueOf(game.getAnfangsbuchstabe()));

    thread.start();
  }

  @Override
  public void run() {
    for (int i = 0; i <game.getSpieldauer(); i++) {
      try {
        //Do some other things
        label_secs_count.setText(String.valueOf(game.getSpieldauer()-i));

        Thread.sleep(1000); // 100 Millisekunden warten
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
    game.stopGame();
    System.out.println("End of thread " + this.toString());
  }

}
