package com.queue;

public class Node<DataType> {

	private Node<DataType> next;
	private DataType data;
	
	public Node(DataType data) {
		
		this.data = data;
	}
	
	public void setNext(Node<DataType> nextNode) {
		
		this.next = nextNode;
	}
	
	public Node<DataType> getNext() {
		
		return this.next;
	}
	
	public DataType getData() {
		
		return this.data;
	}
}
