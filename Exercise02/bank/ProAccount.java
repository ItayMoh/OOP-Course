package bank;

public class ProAccount extends Account {
	private int[] previousAmounts = { 0 };
	private int amountOfTrans = 1;

	public ProAccount(String name) {
		super(name);
	}

	// Adding to total balance and storing transaction in history
	public void add(int amount) {
		super.add(amount);
		this.amountOfTrans++;
		int[] temp = new int[amountOfTrans];
		
		// Copying the smaller array to the bigger
		for (int i = 0; i < amountOfTrans - 1; i++) {
			temp[i] = this.previousAmounts[i];
		}

		this.previousAmounts = temp;

		// Checking if there were more than two transactions
		if (amountOfTrans > 1)
			this.previousAmounts[amountOfTrans - 1] = previousAmounts[amountOfTrans - 2] + amount;
		else
			this.previousAmounts[amountOfTrans - 1] = amount;
	}

	public static void transfer(ProAccount from, ProAccount to, int amount) {
		from.add(-amount);
		to.add(amount);
	}

	public String toString() {
		String transactions = "[";
		
		for (int i = 1; i < this.amountOfTrans; i++) {
			if (i == this.amountOfTrans - 1)
				transactions += this.previousAmounts[i];
			else
				transactions += this.previousAmounts[i] + ",";
		}

		transactions += "]";

		return this.getName() + " has " + this.previousAmounts[amountOfTrans - 1] + " shekels " + transactions;
	}

}
