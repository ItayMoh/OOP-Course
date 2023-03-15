package cards;

public class Card {
	private int suit, num;
	private String suitString[] = new String[] { "C", "D", "H", "S" };

	public Card(int num, int suit) {
		this.num = num;
		this.suit = suit;
	}

	public int getNum() {
		return this.num;
	}

	public int getSuit() {
		return this.suit;
	}

	public String toString() {
		return this.num + "" + this.suitString[suit];
	}

	public int compareTo(Card other) {
		if (this.num == other.num) {
			if (this.suit == other.suit)
				return 0;

			if (this.suit > other.suit)
				return 1;

			return -1;
		}

		if (this.num > other.num)
			return 1;

		return -1;

	}

}
