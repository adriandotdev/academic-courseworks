package my.linkedlist;

public class Main {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(3);
		list.add(123);
		list.add(1);
		list.add(1);
		list.add(145);
		list.add(56);
		
		list.printLinkedList();
		
		list.sort();
		
		list.printLinkedList();
		
		list.set(1, 9999);
		
		list.printLinkedList();
	}
}
