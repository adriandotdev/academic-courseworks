package stack.problems;

import java.util.Scanner;
import my.stack.*;

public class HighestNumber {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		System.out.print("Enter the size of stack: ");
		int size = console.nextInt();
		
		for (int counter = 1; counter <= size; counter++) {
			
			System.out.print("Enter a number: ");
			int number = console.nextInt();
			
			if (stack.isEmpty())
				stack.push(number);
			else {
				
				if (stack.peek() < number) {
					
					stack.pop();
					stack.push(number);
				}
			}
		}
		System.out.println("Highest Number: " + stack.pop());
	}
}
