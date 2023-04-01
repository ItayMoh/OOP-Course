package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s;

	// Initializing new game with new two players
	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		this.players = new Player[2];
		this.players[0] = p1;
		this.players[1] = p2;

		s = new Scanner(System.in);
	}

	// Checks if the longest mark sequence is in the length of the board conditions
	// and return if the player has won
	protected boolean doesWin(int i, int j) {
		if (this.board[0][0] != null)
			return true;

		return false;
	}

	//Ask for coordination from a player and checks if the spot is already marked
	protected boolean onePlay(Player p) {
		System.out.println(p.getName() + " please enter x and y");
		int i = this.s.nextInt();

		int j = this.s.nextInt();

		if (!set(i, j, p)) {
			System.out.println("The board location is already taken");
			onePlay(p);
		}

		board[i][j] = p;
		if (doesWin(i, j)) {
			System.out.println("Congrats " + p.getName() + " you win!");
			return true;
		}

		return false;

	}

	//Passing turnes between two players
	public Player play() {

		while (true) {
			for (Player p : players) {
				if (onePlay(p))
					return p;
				System.out.println(this);
			}

			if (isFull()) {
				System.out.println("The game is tied!");
				return null;
			}
		}

	}
}
