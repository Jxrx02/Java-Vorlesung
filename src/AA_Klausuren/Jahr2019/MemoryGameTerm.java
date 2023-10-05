package AA_Klausuren.Jahr2019;

import AA_Klausuren.Klausur.IOControll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.*;
import java.util.List;

public class MemoryGameTerm implements Runnable {
  private Random r = new Random();
  private int opendCards = 0;
  JToggleCard opendCard;
  private int rounds;
  private String title = "Soeder Memory";
  JFrame frame;

  public MemoryGameTerm(MemoryGame game) {

    // put these objects in a class scope if there are problems
    frame = new JFrame();
    JPanel topPane = new JPanel();
    JPanel centerPane = new JPanel();
    JPanel bottomPane = new JPanel();
    List<JLabel> labels = new ArrayList<>();
    topPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    for (int i = 0; i < game.getPlayerList().size(); i++) {
      JLabel label_player = new JLabel(game.getPlayerList().get(i).getName() + " (" + game.getPlayerList().get(i).getPoints() + ") ");
      label_player.setForeground(game.getPlayerList().get(i).getStatus().getColor());
      labels.add(label_player);
      topPane.add(label_player);
    }
    Thread thread = new Thread(this);
    thread.start();

    List<JToggleCard> cards = new LinkedList<>();
    for (int i = 0; i < game.getCols() - 1; i++) {
      for (int j = 0; j < game.getRows() - 1; j++) {
        int iconNmbr = r.nextInt(game.getMemoryImages().size());
        for (int k = 0; k < 2; k++) {
          var card = new JToggleCard(game.getMemoryImages().get(iconNmbr).getImage());
          card.setIcon(MemoryImages.getBackside());

          card.addItemListener(ev -> {
            if (ev.getStateChange() == ItemEvent.SELECTED) {
              card.setIcon(card.getCardIcon());
              if (opendCards == 0) {
                opendCards++;
                opendCard = card;

                return;
              }
              if (opendCards == 1) {
                rounds++;
                if (opendCard.getCardIcon() == card.getCardIcon()) {
                  game.getCurrentPlayer().addPoint();
                  for (int a = 0; a < labels.size(); a++) {
                    if (labels.get(a).getText().contains(game.getCurrentPlayer().getName()))
                      labels.get(a).setText(game.getPlayerList().get(a).getName() + " (" + game.getPlayerList().get(a).getPoints() + ") ");

                  }
                  opendCards = 0;
                  opendCard.setSelected(false);
                  card.setSelected(false);
                  opendCard.setEnabled(false);
                  card.setEnabled(false);

                  opendCard.setArchived(true);
                  card.setArchived(true);
                  boolean finishedGame = true;
                  for (JToggleCard _card : cards) {
                    if (!_card.isArchived()) {
                      finishedGame = false;
                    }
                  }
                  if (finishedGame) {
                    thread.interrupt();
                    for (Player player : game.getPlayerList()) {
                      player.setStatus(PlayerStatus.FINISHED);
                    }
                    for (int a = 0; a < labels.size(); a++) {
                      labels.get(a).setForeground(game.getPlayerList().get(a).getStatus().getColor());
                    }
                    rounds /= game.getPlayerList().size();

                    String players = "";
                    for (int o = 0; o < game.getPlayerList().size(); o++) {
                      players += game.getPlayerList().get(o).getName() + " (" + game.getPlayerList().get(o).getPoints() + ")";
                      if (o < game.getPlayerList().size()) players += ", ";

                    }

                    IOControll.path = "src/AA_Klausuren/Jahr2019/";
                    IOControll.filename = "memory.txt";


                    //Load lines just for fun
                    String[] lines = IOControll.getAllLinesAsStringArray();
                    String allLines = "";
                    for (String line : lines)
                      allLines += line + "\n";

                    System.out.println(IOControll.isInFile("LM"));
                    JOptionPane.showMessageDialog(null, "Game ends after " + rounds + " rounds, scores: " + players + "\n\n" +
                            "Last games: \n" + allLines);


                    //Write line
                    IOControll.saveString("Game ends after " + rounds + " rounds, scores: " + players + "\n", true);
                  }
                } else {//matchen nicht
                  rounds++;
                  opendCards = 0;
                  game.nextPlayer();

                  for (int a = 0; a < labels.size(); a++) {
                    labels.get(a).setForeground(game.getPlayerList().get(a).getStatus().getColor());
                  }

                  JOptionPane.showMessageDialog(null, "Sorry, those dont match");
                  opendCard.setSelected(false);
                  card.setSelected(false);
                  opendCard.setIcon(MemoryImages.getBackside());
                  card.setIcon(MemoryImages.getBackside());
                }
              }

            } else if (ev.getStateChange() == ItemEvent.DESELECTED) {
              card.setIcon(MemoryImages.getBackside());

            }
          });
          cards.add(card);
        }
        game.getMemoryImages().remove(iconNmbr);

      }
    }
    Collections.shuffle(cards);
    for (JToggleCard card : cards) {
      centerPane.add(card);
    }

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

    frame.setTitle(title);
    // frame.setSize(1000, 500);
    frame.pack(); // auto sizing
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  @Override
  public void run() {
    int i = 0;
    while (true) {
      try {
        //Do some other things
        title = "Soeder Memory (" + i + ")";
        frame.setTitle(title);
        Thread.sleep(1000); // 100 Millisekunden warten
        i++;
      } catch (InterruptedException e) {
        System.out.println(e);
      }

    }
  }
}