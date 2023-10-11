package AA_Klausuren.Jahr2022;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class QuoteTerm implements FakeTalkClient{
  private QuoteDisplay quoteDisplay;
  private Quote quote;
  private JLabel label_points;
  private JButton button_right = new JButton();
  private JButton button_left = new JButton();
  private int player_points;
  private String name;
  public QuoteTerm(String name, QuoteSelectionTerm selectionTerm) {
    this.name = name;
    // put these objects in a class scope if there are problems
    var frame = new JFrame();
    var topPane = new JPanel();
    quoteDisplay = new QuoteDisplay();

    topPane.add(quoteDisplay);

    JPanel centerPane = new JPanel();

    button_left.setEnabled(false);
    button_left.setIcon(FakeTalkIcons.ICON_HOT_SHIT);
    button_left.addActionListener(e -> {
      button_left.setEnabled(false);
      button_right.setEnabled(false);
      selectionTerm.answerSelected(this,quote,QuoteType.HOT_SHIT);

    });
    centerPane.add(button_left);

    button_right.setEnabled(false);
    button_right.setIcon(FakeTalkIcons.ICON_BULLSHIT);
    button_right.addActionListener(e -> {
      button_right.setEnabled(false);
      button_left.setEnabled(false);
      selectionTerm.answerSelected(this,quote, QuoteType.BULLSHIT);
    });
    centerPane.add(button_right);

    JPanel botPane = new JPanel();
    label_points = new JLabel ("0 Points");
    botPane.add(label_points);

    topPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
    centerPane.setLayout(new GridLayout(1, 2, 2, 2));
    frame.setLayout(new BorderLayout());


    frame.add(topPane, BorderLayout.PAGE_START);
    frame.add(centerPane, BorderLayout.CENTER);
    frame.add(botPane,BorderLayout.PAGE_END);


    frame.setTitle(name);
     frame.setSize(500, 600);
    //frame.pack(); // auto sizing
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }

  @Override
  public String getPlayerName() {
    return name;
  }

  @Override
  public void setQoute(Quote q) {
    this.quote = q;
    button_left.setEnabled(true);
    button_right.setEnabled(true);
    quoteDisplay.setText(q.getText());
  }

  @Override
  public void addPoints(int points) {
    player_points += points;
    label_points.setText(player_points+"");
  }

  @Override
  public int getPoints() {
    return player_points;
  }
}
