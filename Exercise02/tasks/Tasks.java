package tasks;

public class Tasks {
	private int[][] taskArray;
	private int missions;
	private int[] kshatotIn;

	// The array row - linked from, coloumn - linked to

	public Tasks(int num) {
		this.taskArray = new int[num][num];
		this.missions = num;
		this.kshatotIn = new int[num];
	}

	public boolean dependsOn(int task1, int task2) {
		if (task1 >= this.missions || task1 < 0 || task2 >= this.missions || task2 < 0)
			return false;

		this.taskArray[task2][task1] = 1;
		this.kshatotIn[task1] += 1;
		return true;
	}

	public int[] order() {
		int[] queue = new int[this.missions];
		int[] helpArr = new int[this.missions];
		int countNodes = 0, index = 0, back = 0;

		// Inserting every node that does not has keshet in, means he can be first in
		// queue
		for (int i = 0; i < this.missions; i++) {
			if (this.kshatotIn[i] == 0)
				queue[back++] = i;
		}

		while (index != back) {
			// Starting to check each node in our queue for "backwards" kshatot
			int currently = queue[index++];
			helpArr[countNodes++] = currently;

			// deleting kshatot out on destination nodes and if their kshatot in equals 0
			// afterwards, adds the node to queue
			for (int i = 0; i < this.missions; i++) {
				if (this.taskArray[currently][i] == 1) {
					this.kshatotIn[i]--;
					if (this.kshatotIn[i] == 0)
						queue[back++] = i;
				}
			}
		}

		if (countNodes != this.missions)
			return null;

		return queue;
	}

}
