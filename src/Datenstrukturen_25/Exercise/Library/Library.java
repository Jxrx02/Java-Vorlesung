package Datenstrukturen_25.Exercise.Library;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Library {

    static String path = "src/Datenstrukturen_25/Exercise/Library/entries.txt";
    static List<Book> books = new LinkedList<>();
    static List<String> lines = new ArrayList<>();


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
            Book book = new Book(authorField.getText(), titleField.getText(), yearField.getText(), publisherField.getText());
            books.add(book);
            writeToFile(path, book.getEntry());
        });
        mid.add(save);
        jf.add(mid, BorderLayout.CENTER);



        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());
        bot.add(new JLabel("Output sorted by:"));
        JButton author = new JButton("author");
        author.addActionListener(e -> {
            System.out.println("Sort by author");
            Comparator comparator = new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Book book1 = (Book)o1;
                    Book book2 = (Book)o2;
                    Collections.sort(words);

                    return book1.getAuthor().compareTo(book2.getAuthor());

                }


            };

        });
        bot.add(author);
        bot.add(new JButton("Title"));
        bot.add(new JButton("Year"));
        jf.add(bot, BorderLayout.SOUTH);

        jf.pack();
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        ReadFromFileToUI (path,500,300);
        new Library();
        System.out.println("BooksSize:"+ books.size());
        for(int i =0; i<books.size();i++){
            System.out.println("Entry"+i +": " +books.get(i).getEntry());

        }



    }

    public void writeToFile(String path, String text){
        //path = dir/testFile.txt
        //Filewriter(path,append?)
        try (FileWriter fWriter = new FileWriter(path, true)){     // öffnen des FileWriters mit Anweisung append
            fWriter.write(text + System.lineSeparator());          // Schreiben des Strings in die Datei
            System.out.println("Ergebnis in der Datei gespeichert.");
        }
        catch (IOException e) {
            e.printStackTrace();                                                // Ausgeben des Fehlers, wenn einer auftritt
        }
    }

    public static void ReadFromFileToUI(String dateiname, int breite, int höhe){
        JFrame f = new JFrame();
        JTextArea jTextArea = new JTextArea();

        try ( BufferedReader br =
                      new BufferedReader(new FileReader(dateiname)) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line); // String-Daten an Liste anhängen

            }
            //System.out.print(lines);
        } catch ( IOException e ) {
            e.printStackTrace();
        }




        //füge Text der TextArea hinzu
        for(int i =0; i < lines.size();i++){
            jTextArea.append(lines.get(i)+"\n");

        }
        System.out.println(lines);

        //add to books
        Book entry = new Book();
        for(int i = 0; i< lines.size();i++) {
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


        f.add(jTextArea);

        //scrollpanel
        JScrollPane scrPane = new JScrollPane(jTextArea);
        f.add(scrPane);

        f.setSize(breite, höhe);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle(dateiname);
    }
}
