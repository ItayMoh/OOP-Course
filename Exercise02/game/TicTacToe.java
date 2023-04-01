package game;

public class TicTacToe extends Game{
	public TicTacToe(String player1, String player2) {
		super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));

	}
	
	protected boolean doesWin(int x, int y) {
		if (super.maxLineContaining(x, y) == 3)
			return true;

		return false;
	}
}
