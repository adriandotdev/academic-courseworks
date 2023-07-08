package com.recursion;

import java.util.*;

public class BinaryToDecimal {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String binary = "";
		
		while (!binary.equals("0")) {
			
			System.out.print("\nEnter a binary value: ");
			binary = console.next();
			
			System.out.printf("Result: %s equivalent to %d%n",binary, binaryToDeci(binary, binary.length() - 1, 0));
		}
	}
	
	static int binaryToDeci(String binary, int index, int pow) {
		
		// base case
		if (index == 0) {
			
			if (binary.charAt(index) == '1')
				return (int)Math.pow(2, pow);
			else
				return 0;
		}
		else if (binary.charAt(index) == '1') 
			return binaryToDeci(binary, index - 1, pow + 1) + (int)Math.pow(2, pow);
		else
			return binaryToDeci(binary, index - 1, pow + 1);
	}
}
