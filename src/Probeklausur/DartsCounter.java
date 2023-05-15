package Probeklausur;

public class DartsCounter {


	public static void main( String[] args ) throws IllegalArgumentException {

		final Board b = new Board();

		final Player[] players = new Player[] { new Player( "Michael van Gerwen" ), new Player( "Rob Cross" )
		};

		final Game g = new Game( b, players );
		g.start();

	}

}
