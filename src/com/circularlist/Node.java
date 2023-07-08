package com.circularlist;

public class Node <DataType> {

	private Node <DataType> next;
	private Node <DataType> previous;
	private DataType data;
	
	// Constructor
	public Node(DataType data) {
		
		this.data = data;
	}
	
	public void setNext(Node<DataType> next) {
		
		this.next = next;
	}
	
	public Node<DataType> getNext() {
		
		return this.next;
	}
	
	public void setPrevious(Node<DataType> previous) {
		
		this.previous = previous;
	}
	
	public Node<DataType> getPrevious() {
		
		return this.previous;
	}
	
	public DataType getData() {
		
		return this.data;
	}
}
