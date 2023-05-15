package Probeklausur;

import java.util.Scanner;

public class Game {
	
	public static int leg=0;
	private	Board board;
	private Player player[];
	
	
	public Game(Board board, Player[] player) {
		this.board = board;
		this.player = player;
		leg = 0;
	}
	
	public void start() throws IllegalArgumentException {
		Scanner scan = new Scanner(System.in);
		boolean x;
		int _player= 0;

		boolean playerreachedCero = false;
		for(int i =0;i<=_player;i++) {
			if(player[_player].getRemainingPoints()<=0)
				playerreachedCero = true;
			
		}
		
		while(leg<10 && !playerreachedCero) {
			
			System.out.println("Player: " + player[_player].getName() + ", " + player[_player].getRemainingPoints());
			System.out.println("Enter visit: ");
			
			
			
			
			Field[] thrownFields = new Field[20];			
			
			String foo = scan.next();
			String _foo[]=  foo.split(" ");
			
			for(int i = 0; i < thrownFields.length;i++) {
				thrownFields[i] = board.parseField(_foo[i]);
			}
			
			Visit visit = new Visit(thrownFields);
			player[_player].addVisit(visit);			
			player[_player].setCountDartsThrown(_foo.length);

			
			System.out.println("Scored: " + player[_player].getVisit());
			System.out.println("====================");


			
			
			
			
		}
	}
	
	

	
	
}
