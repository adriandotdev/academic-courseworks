package my.stack;

public class Node <T>{

	private Node<T> next;
	private T data;
	
	public Node(T data) {
		
		this.data = data;
	}
	
	public Node<T> getNext() {
		
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		
		this.next = next;
	}
	
	public T getData() {
		
		return this.data;
	}
}