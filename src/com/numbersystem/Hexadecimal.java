package com.numbersystem;

public class Hexadecimal {

	/**
	 * This method converts the hexadecimal value to binary value. */
	public static String toBinary(String hexa) {

		// This array is for the range of hexadecimal value 0 to 9.
		String[] hexadecimalToBinary = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001" };
		String binary = "";
		int indexArray = 0;

		for (int index = 0; index < hexa.length(); index++) {

			if (Character.isDigit(hexa.charAt(index)))
				indexArray = Integer.parseInt(Character.toString(hexa.charAt(index)));

			switch(hexa.charAt(index)) {

			case 'A': binary += "1010"; break;

			case 'B': binary += "1011"; break;

			case 'C': binary += "1100"; break;

			case 'D': binary += "1101"; break;

			case 'E': binary += "1110"; break;

			case 'F': binary += "1111"; break;

			default: binary += hexadecimalToBinary[indexArray];
			}
		}
		return binary;
	}

	public static long toDecimal(String hexadecimal) {

		long decimal = 0l;
		int pow = 0;

		for (int index = hexadecimal.length() - 1; index >= 0; index--) {

			switch (hexadecimal.charAt(index)) {

			case 'A': decimal += 10 * (long)Math.pow(16, pow); break;

			case 'B': decimal += 11 * (long)Math.pow(16, pow); break;

			case 'C': decimal += 12 * (long)Math.pow(16, pow); break;

			case 'D': decimal += 13 * (long)Math.pow(16, pow); break;

			case 'E': decimal += 14 * (long)Math.pow(16, pow); break;

			case 'F': decimal += 15 * (long)Math.pow(16, pow); break;

			default: decimal += Long.parseLong(Character.toString(hexadecimal.charAt(index))) * (long)Math.pow(16, pow);
			}
			pow++;
		}
		return decimal;
	}

	public static String toOctal(String hexadecimal) {

		return Binary.toOctal(Hexadecimal.toBinary(hexadecimal));
	}
	
	public static boolean isValidHexaValue(String input) {
		
		for (int i = 0; i < input.length(); i++) {
			
			if (!Character.isDigit(input.charAt(i)))
				if (input.charAt(i) < 'A' || input.charAt(i) > 'F')
					return true;
		}
		return false;
	}
	public static void main(String[] args) {
		
		System.out.println((int)'1');
		System.out.println((int)'F');
	}
}