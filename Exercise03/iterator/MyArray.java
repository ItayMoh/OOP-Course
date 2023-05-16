package iterator;

import java.util.NoSuchElementException;

//This class is implement of MyIterator
public class MyArray implements MyIterator {

	// Class properties:
	private int[] arr;
	private int index = 0; // Index in the array.

	//Cpnstructorf
	public MyArray(int[] arr) {
		this.arr = arr;
	}

	@Override
	public boolean hasNext() {
		return index < arr.length;
	}

	@Override
	public int next() {
		if (!hasNext())
			throw new NoSuchElementException();
		return arr[index++];
	}

}
