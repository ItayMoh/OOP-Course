package game;

public class Player {
	private String name;
	private char mark;
	
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getMark() {
		return this.mark;
	}
	
	public String toString() {
		return this.name + "(" + this.mark + ")";
	}
}
