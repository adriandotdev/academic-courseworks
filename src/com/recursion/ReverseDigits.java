package com.recursion;

import java.util.*;

public class ReverseDigits {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int num = -1;
		
		while (num != 0) {
			
			System.out.print("\nEnter a number: ");
			num = console.nextInt();
			
			System.out.println("REVERSED DIGITS: " + reverseDigits(num));
		}
	}
	
	static String reverseDigits(int num) {
		
		if (num < 10)
			return num + "";
		else
			return num % 10 + "" + reverseDigits(num / 10);
	}
}
