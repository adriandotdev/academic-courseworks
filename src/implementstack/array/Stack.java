package implementstack.array;

import java.util.Arrays;

public class Stack {

	private int[] array; // 
	private int sizeOfStack1; // size of the left part stack.
	private int sizeOfStack2; // size of the right part stack.
	private int capacity1;
	private int capacity2;

	public Stack(int size) { // 6

		array = new int[size];

		if (size % 2 == 0) {

			sizeOfStack1 = size / 2 - 1;
			capacity2 = sizeOfStack2 = size / 2;
		}
		else {

			sizeOfStack1 = size / 2;
			capacity2 = sizeOfStack2 = size / 2 + 1;
		}
	}
	
	public void push1(int element) {
		
		if (capacity1 <= sizeOfStack1) {
			
			array[capacity1++] = element; // 0 1 2 3
		}
	}
	
	public int pop1() {

		return array[--capacity1]; 
	}
	
	public String displayStack1() {
		
		String data = "";
		
		for (int index = capacity1 - 1; index >= 0; index--) {
			
			data += array[index] + " ";
		}
		
		return data;
	}
	
	public void push2(int element) {
		
		if (capacity2 <= array.length - 1) {
			array[capacity2++] = element; // 3 4 5 6
		}
	}
	
	public String displayStack2() {
		
		String data = "";
		
		for (int i = capacity2 - 1; i >= sizeOfStack2; i--) 
			data += array[i] + " ";
		
		return data;
	}
}
