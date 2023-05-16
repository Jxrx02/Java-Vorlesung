package UI.menubar;

import javax.swing.*;

public class MenuBar extends JFrame {

    private JMenuItem newMenu, quit, info;

    public MenuBar(String title) {
        super(title);
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        menubar.add(file);
        menubar.add(help);

        this.newMenu = new JMenuItem("New");
        file.add(this.newMenu);
        this.quit = new JMenuItem("Quit");
        file.add(this.quit);
        this.info = new JMenuItem("Info");
        help.add(this.info);
        this.setSize(300, 200);
        this.setVisible(true);
    }


    public static void main(String[] args) { new MenuBar("Example menu"); }
}
