package cards;

public class Deck {
	private Card myDeck[];
	private int num;

	// First constructor
	public Deck(int num) {
		this.num = num * 4;
		int index = 0;
		this.myDeck = new Card[4 * num];

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 4; j++) {
				myDeck[index] = new Card(i, j);
				index++;
			}
		}
	}

	// Second constructor receiving a deck to take from and the number of cards to
	// take
	public Deck(Deck from, int num) {
		this.num = num;
		this.myDeck = new Card[num];
		int currentIteration;

		currentIteration = from.num < num ? from.num : num;

		for (int i = 0; i < currentIteration; i++) {
			this.myDeck[i] = from.takeOne();
		}
	}

	public int getNumCards() {
		return this.num;
	}

	// Shuffeling two decks together
	public Deck(Deck first, Deck second) {
		this.num = first.num + second.num;
		this.myDeck = new Card[this.num];
		int index = 0;

		for (int i = 0; i < this.num; i++) {
			if (first.num > 0) {
				this.myDeck[index] = first.takeOne();
				index++;
			}

			if (second.num > 0) {
				this.myDeck[index] = second.takeOne();
				index++;
			}

		}
		this.num = index;

	}

	public Card takeOne() {
		if (this.num == 0)
			return null;

		Card tempCard = this.myDeck[this.num - 1];

		this.num--;
		return tempCard;
	}

	// Printing the deck according to specifications, considering different cases
	public String toString() {
		String returnedString = "[";

		if (this.num <= 0)
			return returnedString + "]";

		if (this.num == 1)
			return returnedString + this.myDeck[1].toString() + "]";

		for (int i = 0; i < this.num - 1; i++) {
			returnedString += this.myDeck[i].toString() + ",";
		}
		return returnedString + this.myDeck[this.num - 1].toString() + "]";
	}

	//Bubble sort using the Card method compareTo
	public void sort() {
		int n = this.num;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(this.myDeck[j].compareTo(this.myDeck[j+1])>0) {
					Card temp = this.myDeck[j];
					this.myDeck[j] = this.myDeck[j+1];
					this.myDeck[j+1] = temp;
				}
			}
		}

	}

}
