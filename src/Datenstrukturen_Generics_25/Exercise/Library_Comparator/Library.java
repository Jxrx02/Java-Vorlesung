package Datenstrukturen_Generics_25.Exercise.Library_Comparator;

import IO_Files.testing_main;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Library {

    static String path = "src/Datenstrukturen_25/Exercise/Library_Comparator/entries.txt";
    static List<Book> books = new ArrayList<>();



    public Library() {
        JFrame jf = new JFrame("Book Management");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout(5, 5));


        JPanel top = new JPanel();
        top.setLayout(new GridLayout(4, 2, 2, 2));
        //top.setLayout(new GridLayout(2, 2, 2, 2));
        top.add(new JLabel("Title"));
        JTextField titleField =  new JTextField("");
        top.add(titleField);

        top.add(new JLabel("Author"));
        JTextField authorField =  new JTextField("");
        top.add(authorField);

        top.add(new JLabel("Year"));
        JTextField yearField =  new JTextField("");
        top.add(yearField);

        top.add(new JLabel("Publisher"));
        JTextField publisherField =  new JTextField("");
        top.add(publisherField);
        jf.add(top, BorderLayout.NORTH);


        JPanel mid = new JPanel();
        JButton save = new JButton("Save Entry");
        save.addActionListener(e -> {
            Book book = new Book(titleField.getText(), authorField.getText(), yearField.getText(), publisherField.getText());
            books.add(book);
            writeToFile(path, book.getEntryAsStringToSave(), true);
        });
        mid.add(save);

        JButton delete = new JButton("delete Entry");
        delete.addActionListener(e -> {
            Book bookToDelete = new Book(titleField.getText(), authorField.getText(), yearField.getText(), publisherField.getText());
            System.out.println("delete entry: " + bookToDelete.getEntryAsStringToSave());
            testing_main.deleteStringFromFile(path, titleField.getText());
            testing_main.deleteStringFromFile(path, authorField.getText());
            testing_main.deleteStringFromFile(path, yearField.getText());
            testing_main.deleteStringFromFile(path, publisherField.getText());


        });
        mid.add(delete);

        jf.add(mid, BorderLayout.CENTER);



        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());
        bot.add(new JLabel("Output sorted by:"));
        //Sort by Author using a comparator
        JButton btn_sort_author = new JButton("Author");
        btn_sort_author.addActionListener(e -> {
            System.out.println("Sort by author");
            books.sort(new Comparator<Book>(){
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getAuthor().compareTo(o2.getAuthor());
                }
            });

            String sortedBooks = "";
            for (Book book : books) {
                sortedBooks += book.getTitle() + " by " + book.getAuthor() + " in " + book.getYear() + "\n";
            }
            JOptionPane.showMessageDialog(null, sortedBooks);
        });
        bot.add(btn_sort_author);

        //Sort by Title using a comparator
        JButton btn_sort_title = new JButton("Title");
        btn_sort_title.setActionCommand("Title");               //Kann Parameter an Button übergeben
        btn_sort_title.getActionCommand();                      //Ausgabe:  ---> "Title"
        btn_sort_title.addActionListener(e -> {
            System.out.println("Sort by " + btn_sort_title.getActionCommand());
            books.sort(new Comparator<Book>(){
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            });

            String sortedBooks = "";
            for (Book book : books) {
                sortedBooks += book.getTitle() + " by " + book.getAuthor() + " in " + book.getYear() + "\n";
            }
            JOptionPane.showMessageDialog(null, sortedBooks);
        });
        bot.add(btn_sort_title);




        JButton btn_sort_year = new JButton("Year");
        btn_sort_year.addActionListener(e -> {

            System.out.println("Sort by Year");
            books.sort((o1, o2) -> o1.getYear().compareTo(o2.getYear()));

            String sortedBooks = "";
            for (Book book : books) {
                sortedBooks += book.getTitle() + " by " + book.getAuthor() + " in " + book.getYear() + "\n";
            }
            JOptionPane.showMessageDialog(null, sortedBooks);
        });
        bot.add(btn_sort_year);
        jf.add(bot, BorderLayout.SOUTH);

        // Ändern des Standard-Look and Feel
        try {
            // Ändern der Designvorlage auf Nimbus
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(jf);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jf.pack();
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        ReadFromFileToUI (path,500,300);
        new Library();
        System.out.println("BooksSize: "+ books.size());
        /*for(int i =0; i<books.size();i++){
            System.out.println("Entry"+i +": " +books.get(i).getEntryAsStringToSave());
        }*/


    }

    public void writeToFile(String path, String text, boolean append){
        //path = dir/testFile.txt
        //Filewriter(path,append?)
        try (FileWriter fWriter = new FileWriter(path, append)){     // öffnen des FileWriters mit Anweisung append
            fWriter.write("\n"+text /*+ System.lineSeparator()*/);          // Schreiben des Strings in die Datei
            System.out.println("Ergebnis in der Datei gespeichert.");
        }
        catch (IOException e) {
            e.printStackTrace();                                                // Ausgeben des Fehlers, wenn einer auftritt
        }
    }

    public static void ReadFromFileToUI(String path, int breite, int höhe){
        List<String> lines = new ArrayList<>();

        try ( BufferedReader br = new BufferedReader(new FileReader(path)) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line); // String-Daten an Liste anhängen

            }
            //System.out.print(lines);
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        JFrame f = new JFrame();
        JTextArea jTextArea = new JTextArea();
        f.setLayout(new BorderLayout(5, 5));

        Button btn_refresh =new Button("Refresh");
        btn_refresh.addActionListener(e -> {

            //f.dispose(); // JFrame schließen
            //ReadFromFileToUI(path,breite,höhe);
            jTextArea.setText("");
            try ( BufferedReader br = new BufferedReader(new FileReader(path)) ) {
                lines.clear();
                while (br.ready()) {
                    String line = br.readLine();
                    lines.add(line); // String-Daten an Liste anhängen
                }
                //System.out.print(lines);
            } catch ( IOException ex ) {
                ex.printStackTrace();
            }

            //füge Text der TextArea hinzu
            int k = 0;
            for(int i =0; i < lines.size();i++){
                if(k%4==0){
                    jTextArea.append(i/4 +1+":"); k = 0;
                }
                k++;
                jTextArea.append("\t" + lines.get(i)+"\n");
            }

        });

        //füge Text der TextArea hinzu
        int k = 0;
        for(int i =0; i < lines.size();i++){
            if(k%4==0){
                jTextArea.append(i/4 +1+":"); k = 0;
            }
            k++;
            jTextArea.append("\t" + lines.get(i)+"\n");
        }

        System.out.println(lines);

        //add to books
        Book entry = new Book();
        for(int i = 0; i< lines.size()-1;i++) {
            entry.setTitle(lines.get(i));
            i++;
            entry.setAuthor(lines.get(i));
            i++;
            entry.setYear(lines.get(i));
            i++;
            entry.setPublisher(lines.get(i));

            books.add(entry);
            entry = new Book();
        }

        JPanel area = new JPanel();
        area.add(jTextArea);



        //scrollpanel
        JScrollPane scrPane = new JScrollPane(jTextArea);

        f.add(btn_refresh, BorderLayout.NORTH);
        f.add(area, BorderLayout.CENTER);
        f.add(scrPane,BorderLayout.CENTER);

        f.setSize(breite, höhe);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle(path);
    }
}
