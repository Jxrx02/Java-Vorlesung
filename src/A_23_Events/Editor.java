package A_23_Events;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Editor extends JFrame {
    JTextPane editPane = new JTextPane();

    private static String file_path;
    private static final ArrayList<String> lines = new ArrayList<String>();

    public Editor(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextPane editPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(editPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
        editPane.setText("haallloo");

        // Erstelle Menüleiste
        JMenuBar menuBar = new JMenuBar();

        // Erstelle Datei-Menü
        JMenu fileMenu = new JMenu("Datei");

        //Untermenü
        JMenu sendToMenu = new JMenu("Senden an");

        // Erstelle Datei-Menüpunkte
        JMenuItem newMenuItem = new JMenuItem("Neu");
        JMenuItem openMenuItem = new JMenuItem("Öffnen");
        JMenuItem saveMenuItem = new JMenuItem("Speichern");
        saveMenuItem.setEnabled(false); // Aktiviert oder nicht?
        newMenuItem.setMnemonic(42); // Tastenkürzel (char), siehe JavaDoc

        JMenuItem saveAtMenuItem = new JMenuItem("Speichern unter...");
        JMenuItem exitMenuItem = new JMenuItem("Beenden");

        //Untermenü
        JMenuItem sendViaMail = new JMenuItem("Send via Mail");
        sendToMenu.add(sendViaMail);
        fileMenu.add(sendToMenu);



        // Füge Menüpunkte zum Datei-Menü hinzu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.addSeparator(); // Trennlinie
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAtMenuItem);
        fileMenu.addSeparator(); // Trennlinie
        fileMenu.add(exitMenuItem);


        // Erstelle Bearbeiten-Menü
        JMenu editMenu = new JMenu("Bearbeiten");

        // Erstelle Bearbeiten-Menüpunkte
        JMenuItem undoMenuItem = new JMenuItem("Rückgängig");
        JMenuItem redoMenuItem = new JMenuItem("Wiederholen");
        JMenuItem cutMenuItem = new JMenuItem("Ausschneiden");
        JMenuItem copyMenuItem = new JMenuItem("Kopieren");

        // Füge Menüpunkte zum Bearbeiten-Menü hinzu
        editMenu.add(undoMenuItem);
        editMenu.add(redoMenuItem);
        editMenu.addSeparator(); // Trennlinie
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);

        // Erstelle Hilfe-Menü
        JMenu helpMenu = new JMenu("Hilfe");
        JMenuItem aboutMenuItem = new JMenuItem("Über");

        // Füge Menüpunkt zum Hilfe-Menü hinzu
        helpMenu.add(aboutMenuItem);

        // Füge Menüs zur Menüleiste hinzu
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Setze Menüleiste für das JFrame
        setJMenuBar(menuBar);

        // Füge Aktionen für die Menüpunkte hinzu
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPane.setText(null);
                file_path =null;
            }
        });
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file_path = ChoosSingleFile();
                readFileToDataStructure();

                for(int i =0; i < lines.size();i++){
                    editPane.setText(editPane.getText() + lines.get(i)+"\n");

                }
                lines.removeAll(lines);
                saveMenuItem.setEnabled(true); // Aktiviert oder nicht?
            }
        });
        saveMenuItem.addActionListener(e -> {
            writeToFile(file_path,editPane.getText());
        });
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] opts = { "Yes", "No", "Cancel" };
                int n = JOptionPane.showOptionDialog(null, "Es wurden Änderungen gefunden, die nicht gespeichert wurden. Möchtest du diese Speichern bevor du das Programm beendest?","Vorsicht! Nicht gespeichert",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, opts, opts[0]);
                if ( n == JOptionPane.YES_OPTION ) {
                    writeToFile(file_path,editPane.getText());
                    System.exit(0);

                }
                else if (n == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
                else {
                    System.out.println("Schließvorgang abgebrochen");
                }

            }
        });



        this.setSize(700, 600);
        this.setVisible(true);
    }


    public static String ChoosSingleFile(){
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() ||
                        f.getName().toLowerCase().endsWith(".txt");
            }
            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
        int state = fc.showOpenDialog(null); // Varianten öffnen / zeigen
// int state = fc.showSaveDialog(null); // Variante speichern
// int state = fc.showDialog(null, "Delete"); // freie Variante
        if (state == javax.swing.JFileChooser.APPROVE_OPTION){
            System.out.println(fc.getSelectedFile().getAbsolutePath());
            return fc.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("No selection");
            return null;
        }

    }

    public static void readFileToDataStructure(){
        try ( BufferedReader br =
                      new BufferedReader(new FileReader(file_path)) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line); // String-Daten an Liste anhängen
                lines.add(line);
            }
            System.out.print(lines);
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    public void writeToFile(String path, String text){
        //path = dir/testFile.txt
        //Filewriter(path,append?)
        try (FileWriter fWriter = new FileWriter(path, false)){     // öffnen des FileWriters mit Anweisung append
            fWriter.write(text + System.lineSeparator());          // Schreiben des Strings in die Datei
            System.out.println("Ergebnis in der Datei gespeichert.");
        }
        catch (IOException e) {
            e.printStackTrace();                                                // Ausgeben des Fehlers, wenn einer auftritt
        }
    }


    public void copySelectionToClipboard() {
        String content = this.editPane.getSelectedText();
        if (content != null) {
            StringSelection selection = new StringSelection(content);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        }
    }
    public void doPaste() {
        try {
            String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            if (data != null) {
                this.editPane.getDocument().insertString(this.editPane.getCaretPosition(), data, null);
            }
        } catch (Exception e) {
        }
    }





    public static void main(String[] args) { Editor editor = new Editor("Editor"); }

}

