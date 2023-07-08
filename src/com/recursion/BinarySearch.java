package com.recursion;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { -23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 45};
		System.out.println(binarySearch(arr, 0, arr.length, arr.length / 2, 45));
	}
	/**
	 * @Definition
	 * - == A binary search is an algorithm that search a given element by 
	 * dividing the array into two and compare if the given element is 
	 * greater than equal or less than equal to the middles element of the array.
	 * 
	 * Note: to be able to do a binary search, the array must be sorted.
	 * 
	 * @param array
	 * - array of integers.
	 * @param left
	 * - left part of the sub-array.
	 * @param right
	 * - right part of the sub-array.
	 * @param mid
	 * - middle element of the sub-array.
	 * @param find
	 * - number to be found.
	 * @return
	 * - returns 'true' if the number is found in the array, otherwise, it returns false.
	 * 
	 * static boolean binarySearch(int[] array, int left, int right, int mid, int find) {

		if (left > right || mid > array.length - 1)
			return false;
		else {

			if (array[mid] == find)
				return true;
			else if (array[mid] > find)
				return binarySearch(array, left, mid - 1, Math.abs(left - ((mid - 1) - left) / 2), find);
			else
				return binarySearch(array, mid + 1, right, (mid + 1) + (right - (mid + 1)) / 2, find);
		}
	 }
	 * 
	 * 
	 * */
	
	
	static int binarySearch(int[] arr, int low, int high, int mid, int number) {
		
		if (low > high || mid > arr.length - 1)
			return -1;
		else if (arr[mid] == number)
			return mid;
		else if (arr[mid] < number) 
			return binarySearch(arr, mid + 1, high, Math.abs((high - (mid + 1)) / 2 + mid + 1), number);
		else 
			return binarySearch(arr, low, mid - 1, Math.abs((mid - 1) - low / 2), number);
	}
}