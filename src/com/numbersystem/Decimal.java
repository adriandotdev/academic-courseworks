package com.numbersystem;

public class Decimal {

	/**
	 * This method is for the conversion into binary
	 * and octal number system.
	 * 
	 * The @param base determines if the method converts the decimal value to
	 * binary or octal. If the @param base is equal to 2, then the method converts
	 * the @param decimal to binary, otherwise, if the @param base is equal to 8, then
	 * the method converts the @param decimal to octal value. */
	static String convert(long decimal, int base) {

		if (decimal == 0)
			return "0";
		else
			return convert(decimal / base, base) + decimal % base;
	}

	public static String toBinary(long number) {

		return convert(number, 2);
	}

	public static String toOctal(long number) {

		return convert(number, 8);
	}

	public static String toHexadecimal(long number) {

		if (number == 0)
			return "";
		else {

			switch ((int)number % 16) {

			case 10: return toHexadecimal(number / 16) + 'A';
			case 11: return toHexadecimal(number / 16) + 'B'; 
			case 12: return toHexadecimal(number / 16) + 'C'; 
			case 13: return toHexadecimal(number / 16) + 'D'; 
			case 14: return toHexadecimal(number / 16) + 'E'; 
			case 15: return toHexadecimal(number / 16) + 'F'; 
			default: return toHexadecimal(number / 16) + number % 16;
			
			}
		}
	}
	
	public static boolean isAllNumber(String input) {
		
		for (int i = 0; i < input.length(); i++) {
			
			if (!Character.isDigit(input.charAt(i)))
				return true;
		}
		return false;
	}
}