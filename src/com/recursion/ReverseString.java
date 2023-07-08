package com.recursion;

import java.util.*;

public class ReverseString {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Enter a string: ");
		String str = console.nextLine();
		
		System.out.println("REVERSED: " + reverseString(str, 0));
	}
	
	static String reverseString(String str, int index) {
		
		if (index == str.length() - 1)
			return str.charAt(index) + "";
		else
			return reverseString(str, index + 1) + str.charAt(index);
	}
}