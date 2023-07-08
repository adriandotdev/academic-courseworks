package my.linkedlist.problems;

import my.linkedlist.*;
import java.util.Scanner;

public class DeleteMiddleElements {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		System.out.print("Enter the size of the list: ");
		int size = console.nextInt();
		
		for (int counter = 1; counter <= size; counter++) {
			
			System.out.printf("Enter element no.%d: ", counter);
			list.add(console.nextInt());
		}
		
		// Prints the previous elements of linked list.
		list.printLinkedList();
		
		list.removeMiddleElement();
		
		// Prints the elements of the linked list after deletion of the middle element/s.
		list.printLinkedList();
	}
}
