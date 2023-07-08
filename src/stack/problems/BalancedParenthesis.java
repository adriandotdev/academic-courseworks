package stack.problems;

import java.util.Scanner;
import my.stack.*;

public class BalancedParenthesis {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Stack<Character> stack = new Stack<>();
		String opens = "([{";
		String balanced = "()[]{}";
		boolean isBalance = true;
		
		System.out.print("Enter brackets/parenthesis: ");
		String input = console.nextLine();
		
		for (int index = 0; index < input.length(); index++) {
			
			if (opens.contains(Character.toString(input.charAt(index)))) {
				
				stack.push(input.charAt(index));
			}
			else {
				
				if (balanced.contains(Character.toString(stack.peek()) + Character.toString(input.charAt(index)))) {

					if (!stack.isEmpty())
					 stack.pop();
				}
				else
					isBalance = false;
				
			}
		}
		
		if (isBalance)
			System.out.println("BALANCED!");
		else
			System.out.println("NOT BALANCED!!!");
	}
}
