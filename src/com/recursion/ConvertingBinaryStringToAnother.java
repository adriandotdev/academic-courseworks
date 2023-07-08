package com.recursion;

import java.util.*;

public class ConvertingBinaryStringToAnother {

	static Scanner console = new Scanner(System.in);
			
	public static void main(String[] args) {
		
		System.out.print("Enter binary to be converted: ");
		String binary1 = console.nextLine();
		
		System.out.print("Enter binary to be copied: ");
		String binary2 = console.nextLine();
		
		System.out.printf("The number of minimum swaps is %d", minimumSwaps(binary1, binary2, 0) / 2);
	}
	
	static int minimumSwaps(String bin1, String bin2, int index) {
		
		if (index == bin1.length() - 1) {
			
			if (bin1.charAt(index) != bin2.charAt(index))
				return 1;
			else
				return 0;
		}
		else {
			
			if (bin1.charAt(index) != bin2.charAt(index))
				return 1 + minimumSwaps(bin1, bin2, index + 1);
			else
				return minimumSwaps(bin1, bin2, index + 1);
		}
	}
}