package tasks;

import java.util.Arrays;

public class NamedTasks extends Tasks {
	private String[] names;
	private int lengthOfArr;

	public NamedTasks(String[] names) {
		super(names.length);
		this.names = new String[names.length];
		this.names = names;
		this.lengthOfArr = names.length;
	}

	public boolean dependsOn(String task1, String task2) {

		// Checking if task1 or task2 already exists
		if (!Arrays.asList(this.names).contains(task1) && !Arrays.asList(this.names).contains(task2))
			return false;

		return super.dependsOn(Arrays.asList(this.names).indexOf(task1), Arrays.asList(this.names).indexOf(task2));
	}

	public String[] nameOrder() {
		// Using the parent super.order() to receive the new order and using an array to
		// store the according string
		String[] orderedNames = new String[lengthOfArr];
		int[] StringIndexes = new int[100];
		StringIndexes = super.order();

		for (int i = 0; i < this.lengthOfArr; i++) {
			orderedNames[i] = names[StringIndexes[i]];
		}

		return orderedNames;

	}
}
