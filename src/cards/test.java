package cards;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck d1 = new Deck(3);
		System.out.println(d1);

		Deck d2 = new Deck(d1, 4);
		System.out.println(d2);

		Deck d3 = new Deck(d1, d2);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);

		d3.sort();
		System.out.println(d3);

	}

}
