package AA_Klausuren.Jahr2016;

import AA_Klausuren.Jahr2016.Game;
import AA_Klausuren.Jahr2016.Player;
import AA_Klausuren.Jahr2016.Sheet;

public class StadtLandFluss {
		
	public static void main(String[] args) {
		Game slf = new Game(4,6,60);
		slf.register(new Sheet(new Player("Otto"),slf));
		slf.register(new Sheet(new Player("Anna"),slf));
	}
	
}
