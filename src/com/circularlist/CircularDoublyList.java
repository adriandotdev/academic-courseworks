package com.circularlist;

/**
 * @since November 18, 2020
 * @author NADS-PC */
public class CircularDoublyList <DataType> {

	private Node <DataType> head;
	private Node <DataType> tail;
	/**
	 * @Definition
	 * - adds new data to the list. */
	public void add(DataType data) {
		
		if (head == null) {
			
			head = new Node<>(data);
			tail = head;
			tail.setNext(head);
			head.setPrevious(tail);
			return;
		}
		
		Node <DataType> previousTail = tail;
		tail = new Node<>(data);
		previousTail.setNext(tail);
		tail.setPrevious(previousTail);
		tail.setNext(head);
		head.setPrevious(tail);
	}
	
	public void addToFirst(DataType data) {
		
		if (head == null) {
			
			add(data);
			return;
		}
		
		Node <DataType> currentHead = head;
		head = new Node<>(data);
		head.setNext(currentHead);
		currentHead.setPrevious(head);
		head.setPrevious(tail);
		tail.setNext(head);
	}
	
	public void addToLast(DataType data) {
		
		if (head == null) {
			
			add(data);
			return;
		}
		
		Node <DataType> currentTail = tail;
		
		tail = new Node<>(data);
		currentTail.setNext(tail);
		tail.setNext(head);
		head.setPrevious(tail);
	}
	
	public void insertAt(int index, DataType data) {
		
		if (head == null || index == 0) {
			
			addToFirst(data);
			return;
		}
		
		Node <DataType> newNode = new Node<>(data);
		
		Node <DataType> currentNode = head;
		
		for (int counter = 0; counter < index - 1; counter++)
			currentNode = currentNode.getNext();
		
		currentNode.getNext().setPrevious(newNode);
		newNode.setPrevious(currentNode);
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
	}
	
	public String toString() {
		
		Node <DataType> currentNode = head.getNext();
		String elements = "[ " + head.getData() + " ";
		
		while (currentNode != head) {
			
			elements = elements + currentNode.getData() + " ";
			currentNode = currentNode.getNext();
		}
		
		return (elements += "]");
	}
}