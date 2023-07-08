package com.recursion;

import java.util.*;

public class PrintPatterns {

	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Enter a number: ");
		int num = console.nextInt();
		
		printPattern(num * 2, num + 1, num);
	}

	static void printPattern(int num, int start, int div) {

		if (num < 1)
			return;
		else if (num > div) {
			for (int i = start; i <= num; i++)
				System.out.print("*");
			System.out.println();
			printPattern(num - 1, start, div);
		}
		else {
			
			for (int i = start - 1; i >= num; i--)
				System.out.print("*");
			System.out.println();
			printPattern(num - 1, start, div);
		}
	}
}