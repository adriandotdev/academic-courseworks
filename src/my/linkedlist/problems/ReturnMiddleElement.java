package my.linkedlist.problems;

import my.linkedlist.*;
import java.util.Scanner;

public class ReturnMiddleElement {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		System.out.print("Enter the size of the list: ");
		int size = console.nextInt();
		
		for (int counter = 1; counter <= size; counter++) {
			
			System.out.printf("Enter element no.%d: ", counter);
			list.add(console.nextInt());
		}
		
		System.out.println("Middle Element/s: " + list.getMiddleElement());
	}
}