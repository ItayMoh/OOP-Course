package bank;

public class Account {
	private String name;
	private int shekels;
	
	public Account(String name) {
		this.name = name;
		this.shekels = 0;
	}
	
	public String getName() {
		return this.name;
	}
	public int getShekels() {
		return this.shekels;
	}
	
	public void add(int amount) {
		this.shekels+=amount;
	}
	
	public String toString() {
		return this.name +" has " + this.shekels + " shekels";
	}

}
