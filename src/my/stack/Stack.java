package my.stack;

public class Stack <T>{

	private Node<T> head;
	private Node<T> tail;
	
	public void push(T data) {
		
		if (head == null) {
			
			head = new Node<>(data);
			tail = head;
			return;
		}
		
		Node<T> previousTail = tail;
		tail = new Node<>(data);
		previousTail.setNext(tail);
	}
	
	public T pop() {
		
		T data;
		
		if (size() == 1) {
			data = head.getData();
			head = null;
		}
		else {
			
			Node<T> currentNode = head;
			while (currentNode.getNext() != tail) {
				
				currentNode = currentNode.getNext();
			}
			
			data = currentNode.getNext().getData();
			tail = currentNode;
			tail.setNext(null);
		}
		return data;
	}
	
	public T peek() {
		
		return tail.getData();
	}
	
	public boolean isEmpty() {
		
		if (head == null)
			return true;
		
		return false;
	}
	public int size() {
		
		
		Node<T> currentNode = head;
		int size = 0;
		
		while (currentNode != null) {
			
			currentNode = currentNode.getNext();
			size++;
		}
		return size;
	}
}
