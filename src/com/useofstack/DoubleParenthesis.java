package com.useofstack;

import java.util.Scanner;

import com.stack.*;
/**
 * @author NADS-PC
 * @since 2020
 * Finds which expression has double (). */
public class DoubleParenthesis {

	static Scanner console = new Scanner(System.in);
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		String duplicateParenthesis = ""; // holds the expression that have a duplicate ().
		int openingParCount = 0; // number of opening parenthesis.
		int closingParCount = 0; // number of closing parenthesis.
		
		// (((a+b))+c)+((d+e))+((f))
		System.out.print("Enter an expression: ");
		String in = console.nextLine();
		
		for (int index = 0; index < in.length(); index++) {
			
			if (openingParCount != 2) {

				if (stack.isEmpty() && in.charAt(index) == '(')
					stack.push(in.charAt(index));
				
				else if (in.charAt(index) == '(' && in.charAt(index + 1) != '(') {
					
					stack.push(in.charAt(index));
					openingParCount = 2;
				}
			}
			else if (closingParCount != 2) {
				
				if (in.charAt(index) == ')') {
					
					if ((index + 1) == in.length() && stack.peek() == ')') {
						stack.push(in.charAt(index));
						closingParCount = 2;
					}
					else if (stack.peek() == ')') {
						
						stack.push(in.charAt(index));
						closingParCount = 2;
					}
					else if (in.charAt(index) == ')' && stack.peek() != ')' && stack.peek() != '(')
						stack.push(in.charAt(index));
				}
				else if (in.charAt(index) != '(' && in.charAt(index) != ')')
					stack.push(in.charAt(index));
			}
			
			if (openingParCount == 2 && closingParCount == 2) {
				
				while (!stack.isEmpty()) {
					
					duplicateParenthesis += stack.pop();
				}
				
				System.out.println("Duplicate () found at " + reverseString(duplicateParenthesis));
				duplicateParenthesis = "";
				openingParCount = 0;
				closingParCount = 0;
			}
		}
	}

	static String reverseString(String expression) {
		
		String str = "";
		
		for (int index = expression.length() - 1; index >= 0; index--) {
			
			str += expression.charAt(index);
		}
		return str;
	}
}