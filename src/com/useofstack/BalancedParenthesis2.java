package com.useofstack;

import java.util.Scanner;

import com.stack.*;

/**
 * My second solution to the problem Balanced Brackets.
 * @author NADS-PC
 * @since December 10, 2020 */
public class BalancedParenthesis2 {

	static Scanner console = new Scanner(System.in);
	// An array containing brackets.
	static final int[] arr = { '(', '[', '{', '}', ']', ')' };
	
	public static void main(String[] args) {

		Stack<Character> stack = new Stack<>();
		String openBrackets = "";
		
		System.out.print("Enter a parenthesis: ");
		String input = console.nextLine();
		
		for (int arrayIndex = 0; arrayIndex < arr.length; arrayIndex++) {
			
			for (int stringIndex = 0; stringIndex < input.length(); stringIndex++) {
				
				if (input.charAt(stringIndex) == arr[arrayIndex]) {
					/**
					 * This will determine if the bracket is open or close. */
					if (arrayIndex <= 2) 
						openBrackets += input.charAt(stringIndex) + "";
					else
						stack.push(input.charAt(stringIndex));
				}
			}
		}
		
		if (isBalanced(openBrackets, stack))
			System.out.printf("OUTPUT: %s is balance", input);
		else
			System.out.printf("OUTPUT: %s is NOT balance", input);
	}
	
	/**
	 * A function that determines if the given string is a balanced brackets
	 * where opBrack is a string contains opening brackets and a stack that
	 * contains closing brackets or parenthesis. This function returns true if
	 * the givven expression are balanced, otherwise, it returns false.
	 * @param opBrack
	 * @param stack
	 * @return */
	static boolean isBalanced(String opBrack, Stack<Character> stack) {
		
		if (opBrack.length() != stack.size())
			return false;
		
		for (int i = 0; i < opBrack.length(); i++) {
			/**
			 * This determine the collating sequence of brackets in the UNICODE. */
			if (stack.peek() - 1 != opBrack.charAt(i) && stack.peek() - 2 != opBrack.charAt(i))
				return false;
			stack.pop();
		}
		return true;
	}
}