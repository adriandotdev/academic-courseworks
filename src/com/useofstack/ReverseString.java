package com.useofstack;

import java.util.Scanner;

import com.stack.*;

public class ReverseString {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Stack<Character> stack = new Stack<>();
		
		System.out.print("Enter a string: ");
		String string = console.nextLine();
		
		for (int i = 0; i < string.length(); i++) {
			
			stack.push(string.charAt(i));
		}
		
		System.out.print("Reversed String: ");
		while (!stack.isEmpty()) {
			
			System.out.print(stack.pop() + " ");
		}
	}
}