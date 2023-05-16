package UI.menubar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar_Complex extends JFrame {


    public MenuBar_Complex(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Erstelle Menüleiste
        JMenuBar menuBar = new JMenuBar();

        // Erstelle Datei-Menü
        JMenu fileMenu = new JMenu("Datei");

        // Erstelle Datei-Menüpunkte
        JMenuItem newMenuItem = new JMenuItem("Neu");
        JMenuItem openMenuItem = new JMenuItem("Öffnen");
        JMenuItem saveMenuItem = new JMenuItem("Speichern");
        JMenuItem saveAtMenuItem = new JMenuItem("Speichern unter...");
        JMenuItem exitMenuItem = new JMenuItem("Beenden");

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
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        this.setSize(700, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) { new MenuBar_Complex("EditorSimple"); }


}
