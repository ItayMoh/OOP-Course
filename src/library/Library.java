package library;

public class Library {
	private int size;
	private Book library[];
	

	public Library(int size) {
		this.size = size;
		this.library = new Book[this.size];
		
	}

	public void setBook(int bookNum, String title, Author auth) {
		Book mybook = new Book(title, auth);
		library[bookNum] = mybook;
	}

	public Book getBook(int bookNum) {
		return library[bookNum];
	}

}
