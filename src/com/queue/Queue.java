package com.queue;

public class Queue<DataType> {

	private Node<DataType> head;
	private Node<DataType> tail;
	
	/**
	 * Adds the data to the end of the queue.
	 * @param data 
	 * - data to be added. */
	public void enqueue(DataType data) {
		
		if (head == null) {
			
			head = new Node<>(data);
			tail = head;
			return;
		}
		
		Node<DataType> previousTail = tail;
		tail = new Node<>(data);
		previousTail.setNext(tail);
	}
	
	/**
	 * Removes and returns the data to the front of the queue. */
	public DataType dequeue() {
		
		DataType firstElement = head.getData();
		head = head.getNext();
		return firstElement;
	}
	
	/**
	 * @return the data to the front of the queue. */
	public DataType peek() {
		
		return head.getData();
	}
	
	/**
	 * Checks if the queue is empty */
	public boolean isEmpty() {
		
		if (head == null)
			return true;
		
		return false;
	}
	
	public String toString() {
		
		Node<DataType> currentNode = head;
		String elements = "";
		
		while (currentNode != null) {
			
			elements += currentNode.getData() + " ";
			currentNode = currentNode.getNext();
		}
		
		return elements;
	}
}
