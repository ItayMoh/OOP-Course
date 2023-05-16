package iterator;

//This class is implement of MyIterator
public class Fibonacci implements MyIterator {

	// Class properties:
	private int upperBound;
	private int prev = 0; // previous element.
	private int curr = 0; // current element.

	// Constructor
	public Fibonacci(int upperBound) {
		this.upperBound = upperBound;
	}

	@Override
	public boolean hasNext() {
		return prev + curr <= upperBound && upperBound != 0;
		// if upperBound = 0 so it is illegal as another element.
	}

	@Override
	public int next() {
		int temp;
		if (curr == 0)
			return ++curr;
		if (hasNext()) {
			temp = prev + curr;
			prev = curr;
			curr = temp;
		}
		return curr;
	}

}
