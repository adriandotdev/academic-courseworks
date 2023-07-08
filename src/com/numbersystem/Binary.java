package com.numbersystem;

public class Binary {
	
	
	public static long toDecimal(String binary) {
		
		long decimal = 0l;
		int pow = 0;
		
		for (int i = binary.length() - 1; i >= 0; i--) {
			
			if (binary.charAt(i) == '1')
				decimal += (long)Math.pow(2, pow);
			pow++;
		}
		
		return decimal;
	}

	/**
	 * This method converts the @param binary value to
	 * its corresponding octal value. */
	public static String toOctal(String binary) {

		// First, we need to cut the binary into three.
		String[] binaryHolder = cut(binary, 3);
		String octal = "";

		// Second, we need to traverse the array.
		for (int i = 0; i < binaryHolder.length; i++) {

			// Third, we need to append (concatenate) the result to get the octal value.
			octal += toDecimal(binaryHolder[i]);
		}

		return octal;
	}

	/**
	 * This method will convert the @param binary value
	 * to its corresponding hexadecimal value. */
	public static String toHexadecimal(String binary) {

		// Cuts the binary string into 4 places.
		// 1 0011 1111
		String[] binaryHolder = cut(binary, 4);
		String hexadecimalValue = "";
		long decimalValue = 0;

		for (int i = 0; i < binaryHolder.length; i++) {

			// First, we need to convert the binary to its corresponding decimal value.
			decimalValue = toDecimal(binaryHolder[i]);

			// Second, we need to find the corresponding hexadecimal value of the decimal value.
			switch ((int)decimalValue) {

			case 10: hexadecimalValue += 'A'; break;

			case 11: hexadecimalValue += 'B'; break;

			case 12: hexadecimalValue += 'C'; break;

			case 13: hexadecimalValue += 'D'; break;

			case 14: hexadecimalValue += 'E'; break;

			case 15: hexadecimalValue += 'F'; break;

			default: hexadecimalValue += decimalValue;
			}
		}
		return hexadecimalValue;
	}

	/**
	 * This method is for the conversion of binary to octal, and binary to hexadecimal.
	 * 
	 * A @param binary is a binary value to be converted based on the @param noOfDivision.
	 * 
	 * In @param noOfDivision, if the value of @param noOfDivision is 3, this will indicate that the binary value will divide 
	 * the substring to the length 3 to convert to its corresponding octal value. For example if the input is 1001101, this method will 
	 * result to 1 001 101. On the other hand, if the value of @param noOfDivision is 4, this will indicate that the binary value will 
	 * divide the substring to the length 4 to convert to its corresponding hexadecimal value. 
	 **/
	static String[] cut(String binary, int noOfDivision) {

		int indexStr = 0; // index of the binary.
		int indexArray = 0; // index of the array.

		String[] binaryArr = new String[getLength(binary, noOfDivision)];

		if (binary.length() % noOfDivision != 0) {

			binaryArr[0] = binary.substring(0, binary.length() % noOfDivision);
			indexStr = binary.length() % noOfDivision;
			indexArray = 1;
		}

		for (int i = indexStr; i < binary.length(); i += noOfDivision) {

			binaryArr[indexArray] = binary.substring(i, i + noOfDivision);
			indexArray++;
		}
		return binaryArr;
	}

	/**
	 * This method will determine the size of the array
	 * that will hold the substrings of @param binary. */
	static int getLength(String binary, int noOfDivision) {

		if (binary.length() % noOfDivision != 0)
			return binary.length() / noOfDivision + 1;
		else
			return binary.length() / noOfDivision;
	}
	
	/**
	 * Checks if the inputed binary value
	 * does not contain any number or letters except 1 and 0. */
	public static boolean hasInvalidValue(String binary) {
		
		for (int index = 0; index < binary.length(); index++) {
			
			if ('1' != binary.charAt(index) && '0' != binary.charAt(index))
				return true;
		}
		return false;
	}
}