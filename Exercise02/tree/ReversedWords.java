package tree;

import java.util.Scanner;

public class ReversedWords {
	
	
	//Returning the amount of words that have reversed occurrences inside the string
	public static int checkReversed(){
		Scanner scanner = new Scanner(System.in);
		Node myNode = new Node();
		int count = 0;
		
		String userInput = scanner.nextLine();

		
		for(String word : userInput.split(" ")) {
			if(word.equals("X"))
				break;
			
			String reversedString = reverseString(word);

			//Checks if the string has already been revealed and its reversed occurrence too
			if(myNode.num(word) == 0) {
				myNode.add(word);	
				if(myNode.num(reversedString) == 1) {
					count++;
				}
			}
			
		}
		return count;
		
		
		}
		
		
		
	
	
	//A reverse algorithm for strings
	private static String reverseString(String s) {
		char[] allChars = s.toCharArray();
		int left = 0;
		int right = s.length() - 1;
		
		while(left < right) {
			char temp = allChars[left];
			allChars[left] = allChars[right];
			allChars[right] = temp;
			left++;
			right--;
		}
		
		return new String(allChars);
	}
}
