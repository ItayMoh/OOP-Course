package library;

public class Book {
	private String title;
	private Author auth;
	
	public Book(String title, Author auth) {
		this.title = title;
		this.auth = auth;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthorName() {
		return this.auth.getName();
	}
	
	public int getAuthorBirthYear() {
		return this.auth.getBirthYear();
	}
	
	public String toString() {
		return title + " written by " + getAuthorName() + "(" + getAuthorBirthYear() + ")";
	}

}
