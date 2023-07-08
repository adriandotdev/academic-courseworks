package com.recursion;

import java.util.*;

public class Recursion {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int[] arr = { 3, 41, 53 ,12, 543, 12, 545, 12 };
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println(binarySearch(arr, 0, arr.length, arr.length/2, 12));
	}
	/**
	 * @param num
	 * @return sum of numbers from num.*/
	static int sum(int num) {
		
		if (num == 1) 
			return 1;
		else
			return num + sum(num - 1);
	}
	
	static double pow(double num, double exp) {
		
		if (exp == 1)
			return num;
		else
			return num * pow(num, exp - 1);
	}
	
	static int fact(int num) {
		
		if (num == 1)
			return 1;
		else
			return num * fact(num - 1);
	}
	
	/**
	 * Returns the sum of all elements in
	 * the array.
	 * @param index
	 * @param arr
	 * @return */
	static int sumOfArray(int index, int[] arr) {
		
		if (index == arr.length - 1)
			return arr[index];
		else {
			return arr[index] + sumOfArray(index + 1, arr);
		}
	}
	
	/**
	 * Copies the element of arr1 to arr2.
	 * @param index
	 * - index of the starting point of copying.
	 * @param arr1
	 * - array to be copied.
	 * @param arr2 
	 * - array that copying. */
	static void copyArray(int index, int[] arr1, int[] arr2) {
		
		if (index == arr1.length - 1)
			arr2[index] = arr1[index];
		else {
			arr2[index] = arr1[index];
			copyArray(index + 1, arr1, arr2);
		}
	}
	
	static void removeOddNumbers(int index, int indexTwo, int[] arr1, int[] arr2) {
		
		if (index == arr1.length - 1 ||  arr1[index] % 2 == 0)
			arr2[indexTwo] = arr1[index];
		else {

			if (arr1[index] % 2 == 0) {
				arr2[indexTwo] = arr1[index];
				removeOddNumbers(index + 1, indexTwo + 1, arr1, arr2);
			}
			else if (arr1[index] % 2 != 0)
				removeOddNumbers(index + 1, indexTwo, arr1, arr2);
		}
	}
	
	static boolean binarySearch(int[] arr, int left, int right, int mid, int find) {
		
		if (left > right || mid > arr.length - 1)
			return false;
		else {
			
			if (arr[mid] == find)
				return true;
			else if (arr[mid] > find)
				return binarySearch(arr, left, mid - 1, (right - left) / 2 - left, find);
			else
				return binarySearch(arr, mid + 1, right, (right - left) / 2 + left, find);
		}
	}
	/**
	 * Prints the elements in the array.
	 * @param index
	 * @param arr
	 * @return */
	static String printArray(int index, int[] arr) {
		
		if (index == arr.length - 1)
			return arr[index] + "";
		else 
			return arr[index] + ", " + printArray(index + 1, arr);
	}
	
	/**
	 * Converts the Binary (0's or 1's) into its corresponding Decimal value.
	 * @param bin
	 * @param index
	 * @param pow
	 * @return */
	static int toDecimal(String bin, int index, int pow) {
		
		if (index == 0) {
			
			if (bin.charAt(index) == '1')
				return (int)Math.pow(2, pow);
			else
				return 0;
		}
		else if (bin.charAt(index) == '1')
			return (int)Math.pow(2, pow) + toDecimal(bin, index - 1, pow + 1);
		else
			return toDecimal(bin, index - 1, pow + 1);
	}
	
	static String toBin(int num) {
		
		if (num == 0)
			return "";
		else
			return (num % 2) + "" + toBin(num / 2);
	}
	
	/**
	 * Counts the number of vowels in the given string.
	 * @param str
	 * @param index
	 * @return */
	static int countVowels(String str, int index) {
		
		String vowels = "aeiou";
		
		if (index == str.length() - 1) {
			if (vowels.contains(str.charAt(index) + ""))
				return 1;
			else
				return 0;
		}
		else if (index <= str.length() - 1 && vowels.contains(str.charAt(index) + ""))
			return countVowels(str, index + 1) + 1;
		else
			return countVowels(str, index + 1);
	}

	static int temp = 0;
	static String edabit(int num) {
		
		if (temp == 0) {
			temp = -1;
			return "bit" + edabit(num - 1);
		}
		else if (num == 0)
			return "Eda";
		else {
			 return edabit(num - 1) + "a";	
		}
	}
}