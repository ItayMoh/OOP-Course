package tree;

public class Node {
	private int count;
	private Node[] children;

	public Node() {
		this.children = new Node['z' - 'a' + 1];
		this.count = 0;
	}

	//Recursively returning the count of a string s
	public int num(String s) {
		if(s == "") 
			return this.count;
	
		int index = 'z' - s.charAt(0);
		if(children[index] == null)
			return 0;
		
		return children[index].num(s.substring(1));
		
	}

	//Adding to a count of a string s
	public void add(String s) {
		if (s == "") {
			count++;
			return;
		}
		

		int index = 'z' - s.charAt(0);

		if (children[index] == null) 
			children[index] = new Node();

		children[index].add(s.substring(1));
	}

}
