package AA_Klausuren.Jahr2021;

import A_19_IO_Files.InputOutputControl;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

class ChoronaTerminal implements Runnable {
  private Point[] points;
  private Variant variant;
  private Room room;
  private int steps;
  private Label label;
  private AtomicReference<JPanel> mid;
  private CellButton[][] cellButtons;

  ChoronaTerminal(Variant variant, Room room) throws ArrayIndexOutOfBoundsException {
    this.variant = variant;
    this.room = room;
    this.steps = room.getSteps();

    JFrame f = new JFrame("Chorona - " + variant.toString() + "(" + variant.getDesignation() + ")");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    f.setLayout(new BorderLayout(5, 5));
    JPanel top = new JPanel();
    label = new Label("Steps: 0");
    label.setText(String.valueOf(steps));
    top.add(label);

    mid = new AtomicReference<>(new JPanel());
    mid.get().setLayout(new GridBagLayout());

    points = room.getSetting().getPolluters();
    room.step();
    cellButtons = new CellButton[room.getSetting().getHeight()][room.getSetting().getWidth()];
    for (int i = 0; i < room.getSetting().getHeight() - 1; i++)
      for (int j = 0; j < room.getSetting().getHeight() - 1; j++) {
        if (points[i].getY() == i && points[j].getX() == j) {
          cellButtons[i][j] = new CellButton(room.getDose(i, j), true);
          cellButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        } else cellButtons[i][j] = new CellButton(room.getDose(i, j), false);
        Chorona.updateButtonForDose(cellButtons[i][j], room.getDose(i, j));

        addComponent(mid.get(), new CellButton(room.getDose(i, j), false), j, i, 1, 1, 1.0, 1.0);

      }


    JPanel bot = new JPanel();
    Button btn0 = new Button("Step");
    btn0.addActionListener(e -> {
      room.step();
      label.setText(String.valueOf(room.getSteps()));

      mid.set(new JPanel());


      cellButtons = new CellButton[room.getSetting().getHeight()][room.getSetting().getWidth()];
      for (int i = 0; i < room.getSetting().getHeight() - 1; i++)
        for (int j = 0; j < room.getSetting().getHeight() - 1; j++) {
          if (points[i].getY() == i && points[j].getX() == j) {
            cellButtons[i][j] = new CellButton(room.getDose(i, j), true);
            cellButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
          } else cellButtons[i][j] = new CellButton(room.getDose(i, j), false);
          Chorona.updateButtonForDose(cellButtons[i][j], room.getDose(i, j));
        }

    });
    Button btn1 = new Button("Play");
    btn1.addActionListener(e -> {
      Thread thread = new Thread(this);
      thread.start();

    });

    Button btn2 = new Button("Save");
    btn2.addActionListener(e -> {
      String filename = variant.toString() + "-" + room.getSetting().getWidth() + "-" + room.getSetting().getHeight() + "-" + room.getSetting().getPolluters().length + "-" + room.getSteps() + ".txt";
      try {
        InputOutputControl.path = "src/AA_Klausuren/Jahr2021/";
        InputOutputControl.filename = filename;
        InputOutputControl.append = true;
        InputOutputControl.deleteCompleteFileContentButNotFile();

        //speicher zellen
        for (int i = 0; i < room.getSetting().getHeight() - 1; i++)
          for (int j = 0; j < room.getSetting().getHeight() - 1; j++) {
            cellButtons[i][j] = new CellButton(room.getDose(i, j), true);
            LinkedList<String> element = new LinkedList<>();
            element.add(i + ";" + j + ";" + cellButtons[i][j].getDose());
            InputOutputControl.saveList(element);
          }
        JOptionPane.showMessageDialog(null, filename + " saved successfully");

      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,
                filename + " not saved successfully",
                "Error",
                JOptionPane.ERROR_MESSAGE);
      }


    });

    bot.add(btn0);
    bot.add(btn1);
    bot.add(btn2);


    f.add((top), BorderLayout.NORTH);
    f.add(mid.get(), BorderLayout.CENTER);
    f.add(bot, BorderLayout.SOUTH);
    f.setSize(600, 600);
    f.setVisible(true);

  }

  private static void addComponent(Container cont, Component c,
                                   int x, int y, int width, int height, double weightx, double weighty) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.gridwidth = width;
    gbc.gridheight = height;
    gbc.weightx = weightx;
    gbc.weighty = weighty;
    cont.add(c, gbc);
  }

  @Override
  public void run() {
    try {

      for (int k = 0; k < 20; k++) {
        //step
        room.step();

        label.setText(String.valueOf(room.getSteps()));

        mid.set(new JPanel());

        for (int i = 0; i < room.getSetting().getHeight() - 1; i++)
          for (int j = 0; j < room.getSetting().getHeight() - 1; j++) {
            if (points[i].getY() == i && points[j].getX() == j) {
              cellButtons[i][j] = new CellButton(room.getDose(i, j), true);
              cellButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
            } else cellButtons[i][j] = new CellButton(room.getDose(i, j), false);
            Chorona.updateButtonForDose(cellButtons[i][j], room.getDose(i, j));
          }
        Thread.sleep(500);
      }


    } catch (InterruptedException ex) {
      throw new RuntimeException(ex);
    }

  }


}
