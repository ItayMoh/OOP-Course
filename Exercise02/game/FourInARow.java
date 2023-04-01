package game;

public class FourInARow extends Game {

	public FourInARow(String player1, String player2) {
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
	}
	
	//Checks for a streak of four in marks using the maxLineContaining method inherited from Board
	protected boolean doesWin(int i, int j) {
		if (super.maxLineContaining(j, i) == 4)
			return true;

		return false;
	}

	
	//Check for the next space in the column and placing the mark if available
	protected boolean onePlay(Player p) {
		System.out.println(p.getName() + " please enter column:");
		int i = this.s.nextInt();
		
		//checks next empty space in column
		for (int j = n-1; j >=0; j--) {
			if (super.set(j, i, p)) {
				board[j][i] = p;
				if (doesWin(i, j)) {
					System.out.println("Congrats " + p.getName() + " you win!");
					return true;
				}
				return false;
			}
		}
		System.out.println("The board location is already taken");
		onePlay(p);
		return false;
	}
}
