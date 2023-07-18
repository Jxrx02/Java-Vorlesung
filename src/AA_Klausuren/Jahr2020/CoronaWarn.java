package AA_Klausuren.Jahr2020;

import java.io.*;
import java.util.*;

import javax.swing.*;

public class CoronaWarn {

    /**
     * Application entry point for CoronaWarn
     *
     * @param args
     *           command line arguments, not used here
     */
    public static void main( String[] args ) {
        try {
            // Only necessary on MacOS to prevent color issues with standard look
            // and feel.
            // Redundant on other operation systems - they use this look and feel
            // by default.
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch ( final Exception e ) {
        }

        JPhone phone1 = new JPhone( "0123-4567", "Markus" );
        JPhone phone2 = new JPhone( "9876-5432", "Angela" );
        JPhone phone3 = new JPhone( "4711-0815", "Olaf" );

        CoronaWarnTerm client1 = new CoronaWarnTerm( phone1 );
        CoronaWarnTerm client2 = new CoronaWarnTerm( phone2 );
        CoronaWarnTerm client3 = new CoronaWarnTerm( phone3 );

        CoronaWarnAPI.registerClients( client1, client2, client3 );
    }

    /**
     * Clear token store for phone
     *
     * @param phone
     *           phone to clear store for
     */
    public static void clearTokenStore( JPhone phone ) {
        // ADD CODE HERE
        System.out.println( "Clear token store" );

        try ( Writer out = new FileWriter( "src/AA_Klausuren/"+phone.getID() +".txt" , false) ) {
            out.write(""); //

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load tokens for phone
     *
     * @param phone
     *           phone to load tokens for
     *
     * @return loaded tokens
     */
    public static List<Token> loadTokens( JPhone phone ) {
        List<Token> tokens = new LinkedList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader("src/AA_Klausuren/"+phone.getID() +".txt"))) {
            while (reader.ready()) {
                tokens.add(CoronaWarn.parseToken(reader.readLine()));
            }

        } catch (Exception e) {
            System.err.println("Fehler beim lesen!");
            return new LinkedList<Token>();
        }

        return tokens;
    }


    /**
     * Save token for provided phone
     *
     * @param phone
     *           phone to save token for
     * @param token
     *           token to save
     */
    public static void saveToken( JPhone phone, Token token ) {
        String line = token.getValue() + ";" + token.getDate().getTime();

        File dir = new File("src/AA_Klausuren");

        //Erzeuge File in dir
        File file = new File(dir, phone.getID()+ ".txt");


        //append to file
        try ( Writer out = new FileWriter(file, true) ) {
            out.write(line + "\n"); // wird angehängt
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

    }

    /**
     * Parse a token line
     *
     * @param line
     *           token line to parse
     *
     * @return parsed token instance
     */
    public static Token parseToken( String line ) {
        String[] parts = line.split( "[;]" );
        if ( parts.length == 2 ) {
            try {
                return new Token( parts[0],
                        new Date( Long.parseLong( parts[1] ) ) );
            } catch ( Exception e ) {
                System.err.println( "Error parsing token line: " + line );
                e.printStackTrace();
            }
        }
        return null;
    }
}