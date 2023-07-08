package com.useofstack;

import java.util.Scanner;

import com.stack.*;

/**
 * Problem Definition
 * - Check if the giving string is balanced brackets/parentheses.
 * @author NADS-PC
 * @since December 09, 2020 */
public class BalancedParenthesis {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Stack<Character> stack = new Stack<>();
		String right = ")]}";
		String left = "";
		
		System.out.print("Enter a parenthesis: ");
		String input = console.next();
		
		// string is sorted by the character collating sequence.
		input = sort(input);
		
		for (int i = 0; i < input.length(); i++) {
			
			// Put the closing parenthesis in the stack.
			if (right.contains(input.charAt(i) + ""))
				stack.push(input.charAt(i));
			// Put the opening parenthesis on the string left.
			else
				left += input.charAt(i);
		}
		
		if (isBalance(left, stack))
			System.out.println("Balanced!!");
		else
			System.out.println("Not Balanced!!");
	}
	
	static boolean isBalance(String left, Stack<Character> stack) {
		
		if (left.length() != stack.size())
			return false;
		
		for (int i = stack.size() - 1; i >= 0; i--) {
			
			/**
			 * This part is for checking if the opening parenthesis is valid to the
			 * closing parenthesis.
			 * 
			 * Example of this is '(' is 40 while ')' is 41
			 * Each brackets has corresponding collating sequence that can be used
			 * to compare if the two is valid bracket. */
			if ((int)stack.peek() - 2 == left.charAt(i) || (int)stack.peek() - 1 == left.charAt(i))
				stack.pop();
			else
				return false;
		}
		return true;
	}
	
	static String sort(String input) {
		
		char[] ch = input.toCharArray();
		String str = "";
		
		for (int i = 0; i < ch.length; i++) {
			
			// temporary variable for swapping two adjacent elements.
			char temp = ' ';
			
			for (int j = 0; j + 1<= ch.length - 1 - i; j++) {
				
				if (ch[j] > ch[j + 1]) {
					// swap.
					temp = ch[j];
					ch[j] = ch[j + 1];
					ch[j + 1] = temp;
				}
			}
		}
		
		// copy the element from a sorted array of characters.
		for (int i = 0; i < ch.length; i++) {
			
			str += ch[i];
		}
		return str;
	}
}