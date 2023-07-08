package my.linkedlist.problems;

import my.linkedlist.*;
import java.util.Scanner;

public class RemoveDuplicate {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(123);
		list.add(1234);
		list.add(125);
		list.add(2345);
		list.add(123);
		list.add(125);
		list.add(123);
		list.add(2345);
		list.add(2345);	
		list.sort();
		list.printLinkedList();
		
		list.removeDuplicate();
		
		list.printLinkedList();
	}
}
