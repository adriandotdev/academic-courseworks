package stack.problems;

import java.util.Scanner;
import my.stack.*;

public class DecodingSequence {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		String output = "";
		int count = 1;
		
		System.out.print("Enter a sequence: ");
		String sequence = console.next();
		
		for (int i = 0; i < sequence.length(); i++) { 
			
			if (sequence.charAt(i) == 'I') {
				
				output += (count++) + "";
				
				if (!stack.isEmpty()) 
					output += getStack(stack);
			}
			else 
				stack.push(count++);
		}
		
		if (sequence.charAt(sequence.length() - 1) == 'I')
		 System.out.println("DECODED SEQUENCE: " + output + count);
		else
			System.out.println("DECODED SEQUENCE: " + output + count + getStack(stack));
	}
	
	static String getStack(Stack<Integer> stack) {
		
		String output = "";
		
		while (!stack.isEmpty()) {
			
			output += stack.pop();
		}
		return output;
	}
}