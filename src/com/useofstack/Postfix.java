package com.useofstack;

import java.util.Scanner;

import com.stack.*;
public class Postfix {

	static Scanner console = new Scanner(System.in);
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) {

		String postFix = ""; // storage of the evaluated infix expression.
		String operators = "-+/*"; // all valid operators.
		String higherPrec = "*/"; // operators that have higher precedence.
		String lowerPrec = "+-"; // operators that have lower precedence.

		System.out.print("Enter a valid infix expression: ");
		String infix = console.nextLine();

		for (int i = 0; i < infix.length(); i++) {

			// For the characters that are letters or numbers.
			if (Character.isLetter(infix.charAt(i)) || Character.isDigit(infix.charAt(i))) {
				postFix += infix.charAt(i); 
			}
			else {
				// Check if stack is empty.
				if (stack.isEmpty())
					stack.push(infix.charAt(i));
				else {
					
					/**
					 * (This will check if the peek of the stack is an operator,
					 * then it will pop because it cannot cover the operator by ')') */
					if (infix.charAt(i) == ')' && operators.contains(Character.toString(stack.peek()))) {

						//Pop the operator.
						postFix += stack.pop();
						
						if (stack.peek() == '(')
							stack.pop();
					}
					/**
					 * Checks if the current character is an operator. */
					else if (operators.contains(Character.toString(infix.charAt(i)))) {
						/**
						 * if stack is not empty then check if the operator in the stack has higher precedence
						 * than the current operator character. **/
						while (!stack.isEmpty() && indexOf(operators, stack.peek()) >= indexOf(operators, infix.charAt(i))) {
							// add to the postFix.
							postFix += stack.pop();
						}
						
						/**
						 * if the current operator character greater than or equal precedence at the peek
						 * of the stack. */
						while (!stack.isEmpty() && (indexOf(operators, infix.charAt(i)) >= indexOf(operators, stack.peek()))) {
							
							// Checks if the peek of stack is same precedence to the current operator character.
							if (higherPrec.contains(infix.charAt(i) + "") && higherPrec.contains(stack.peek() + ""))
								postFix += stack.pop();
							else if (lowerPrec.contains(infix.charAt(i) + "") && lowerPrec.contains(stack.peek() + ""))
								postFix += stack.pop();
							else 
								break;
								
						}
						stack.push(infix.charAt(i));
					}
					else
						stack.push(infix.charAt(i));
				}
			}
		}
		
		// Get the remaining operators in the stack.
		while (!stack.isEmpty()) {

			if (stack.peek() != ')' && stack.peek() != '(')
				postFix += stack.pop();
			else
				stack.pop();
		}

		System.out.println("POSTFIX: " + postFix);
	}

	static int indexOf(String operation, char ch) {

		int index = -1;

		for (int i = 0; i < operation.length(); i++) {

			if (ch == operation.charAt(i)) {
				index = i;
				break;
			}
		}
		return index;
	}
}