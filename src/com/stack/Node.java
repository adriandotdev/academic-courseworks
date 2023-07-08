package com.stack;

/**
 * @since November 22, 2020
 * @author NADS-PC */
public class Node <DataType>{

	private Node<DataType> next;
	private DataType data;
	
	public Node(DataType data) {
		
		this.data = data;
	}
	
	public void setNext(Node<DataType> next) {
		
		this.next = next;
	}
	
	public Node<DataType> getNext() {
		
		return next;
	}
	
	public DataType getData() {
		
		return this.data;
	}
}