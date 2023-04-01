package game;

public class Board {
	protected Player[][] board;
	protected int n, m;

	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		this.board = new Player[n][m];
	}

	protected boolean set(int i, int j, Player p) {

		// Checks if player already marked the spot and putting mark accordingly
		if (board[i][j] == null) {
			this.board[i][j] = p;
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty(int i, int j) {
		if (this.board[i][j] == null)
			return true;
		return false;
	}

	// Get the player that has the holding at i,j coordination
	public Player get(int i, int j) {
		if (isEmpty(i, j))
			return null;

		return this.board[i][j];
	}

	// Checks if the board is full
	public boolean isFull() {
		int counter = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (board[i][j] != null)
					counter++;
		}

		if (counter == n * m)
			return true;

		return false;
	}

	public String toString() {
		// Default printing for a board
		String printBoard = new String();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isEmpty(i, j)) {
					printBoard += ".";
				} else {
					printBoard += this.get(i, j).getName().charAt(0);
				}
			}
			printBoard += "\n";
		}

		return printBoard;
	}

	//Checks the sequence of marks in the board staring from provided i and j representing
	//x and y coordinations
	protected int maxLineContaining(int i, int j) {
	    Player player = board[i][j];
	    int maxLine = 0;

	    // Check horizontal line
	    int count = 0;
	    for (int k = 0; k < m; k++) {
	        if (board[i][k] == player) {
	            count++;
	        } else {
	            maxLine = Math.max(maxLine, count);
	            count = 0;
	        }
	    }
	    maxLine = Math.max(maxLine, count);

	    // Check vertical line
	    count = 0;
	    for (int k = 0; k < n; k++) {
	        if (board[k][j] == player) {
	            count++;
	        } else {
	            maxLine = Math.max(maxLine, count);
	            count = 0;
	        }
	    }
	    maxLine = Math.max(maxLine, count);

	    // Check diagonal line 1 (top left to bottom right)
	    count = 0;
	    int k = i, l = j;
	    while (k >= 0 && l >= 0 && board[k][l] == player) {
	        count++;
	        k--;
	        l--;
	    }
	    k = i + 1;
	    l = j + 1;
	    while (k < n && l < m && board[k][l] == player) {
	        count++;
	        k++;
	        l++;
	    }
	    maxLine = Math.max(maxLine, count);

	    // Check diagonal line 2 (top right to bottom left)
	    count = 0;
	    k = i;
	    l = j;
	    while (k >= 0 && l < m && board[k][l] == player) {
	        count++;
	        k--;
	        l++;
	    }
	    k = i + 1;
	    l = j - 1;
	    while (k < n && l >= 0 && board[k][l] == player) {
	        count++;
	        k++;
	        l--;
	    }
	    maxLine = Math.max(maxLine, count);

	    return maxLine;
	}

}