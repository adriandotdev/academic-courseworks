package com.numbersystem;

public class Octal {
	
	/**
	 * This recursive method converts the octal value to its corresponding 
	 * binary value. */
	public static String toBinary(String octal, int index) {

		/**
		 * Since, the octal value is ranging from 0 to 7, we just declare it to array to be able to easily access
		 * by the character digit of the octal value. */
		final String[] octalValue = { "000", "001", "010", "011", "100", "101", "110", "111" };
		
		// This variable is for the index of the array to access the corresponding binary value of the character digit.
		int arrayIndex = Integer.parseInt(Character.toString(octal.charAt(index)));
		
		if (index == octal.length() - 1)
			return octalValue[arrayIndex];
		else
			return octalValue[arrayIndex] + toBinary(octal, index + 1);
	}
	
	/**
	 * This recursive method converts the octal value
	 * to its corresponding decimal value. */
	public static long toDecimal(String octal, int index, int pow) {
	
		int digit = Integer.parseInt(Character.toString(octal.charAt(index)));
		
		if (index == 0) 
			return digit * (long)Math.pow(8, pow);
		else
			return digit * (long)Math.pow(8, pow) + toDecimal(octal, index - 1, pow + 1);
	}
	
	/**
	 * This method converts the octal value
	 * to its corresponding hexadecimal value. */
	public static String toHexadecimal(String octal) {
		/**
		 * This method reuse the method of other class, since
		 * it is the same process for conversion.
		 * 
		 * The algorithm of this method is we need to convert first
		 * the octal value to its corresponding binary value then pass it to 
		 * the method toHexadecimal to divide the string into subtring with length 4
		 * and determine the hexadecimal value. */
		return Binary.toHexadecimal(toBinary(octal, 0));
	}
	
	public static boolean isValidOctal(String input) {
		
		for (int i = 0; i < input.length(); i++) {
			
			if (input.charAt(i) < '1' || input.charAt(i) > '7')
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		
		System.out.println((int)'1');
		System.out.println((int)'7');
	}
}