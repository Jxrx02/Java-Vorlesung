package AA_Klausuren.Jahr2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FakeTalk {

   public static void main( String[] args ) {
      List<Quote> quotes = FakeTalk.loadQuotes( "corona.csv" );
      try {
         QuoteSelectionTerm selectionTerm = new QuoteSelectionTerm(quotes, 3, 4 );

         QuoteTerm t1 = new QuoteTerm( "Muenchhausen", selectionTerm );
         QuoteTerm t2 = new QuoteTerm( "Pinocchio", selectionTerm );
         selectionTerm.register( t1 );
         selectionTerm.register( t2 );

         selectionTerm.start();
      } catch ( FakeNewsException e ) {
         e.printStackTrace();
      }
   }

   private static List<Quote> loadQuotes( String filename ) {
      List<Quote> quotes = new LinkedList<>();

      IOControll.path = "src/AA_Klausuren/Jahr2022/";
      IOControll.filename = filename;

      //Load List
      LinkedList<String[]> lines = IOControll.loadFileAsList();

      for ( int i = 1; i < lines.size(); i++ ) {
         //quotes.add( FakeTalk.parseQuote( String.format( "%b;Quote Text %d;John Doe;Head of Dummy-Data Department %d;Source Code, 17.10.2022;", i % 2 == 0, i, i ) ) );
         quotes.add( FakeTalk.parseQuote(Arrays.toString(lines.get(i))) );

      }

      return quotes;
   }

   private static Quote parseQuote( String s ) {
      if ( s != null ) {
         String[] parts = s.trim().split( ";" );
         if ( parts.length == 6 || parts.length == 5 ) {
            return new Quote( parts[1], parts[2], parts[3], parts[4], Boolean.parseBoolean( parts[0] ) ? QuoteType.HOT_SHIT : QuoteType.BULLSHIT );
         }
      }
      return null;
   }

}
