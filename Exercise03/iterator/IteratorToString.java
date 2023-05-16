package iterator;

//This class is used to make a string out of an iterator.
public class IteratorToString {
	public static String toString(MyIterator it) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int temp = 0;
		int flag = 0;
		while (it.hasNext()) {
			flag = it.next();
			if (flag > 9)
				temp += 1;
			sb.append(flag);
			sb.append(" ");
			temp += 2;
		}
		sb.deleteCharAt(temp);
		sb.append("]");
		return sb.toString();
	}

}
