package com.stack;
/**
 * @since November 22, 2020
 * @author NADS-PC
 * @param <DataType>
 * - a wrapper class of a specific primitive type. */
public class Stack <DataType> {

	private Node<DataType> head;
	private Node<DataType> tail;

	/**
	 * Adds data to the peek of the stack.
	 * @param data */
	public void push(DataType data) {

		if (head == null) {

			head = new Node<>(data);
			tail = head;
			return;
		}

		Node<DataType> currentTail = tail;
		tail = new Node<>(data);
		currentTail.setNext(tail);
	}

	/**
	 * Removes the top-most part of the stack.
	 * @return the data at the peek of the stack. */
	public DataType pop() {

		Node <DataType> currentNode = head;
		DataType data;

		if (size() == 1) {

			data = head.getData();
			head = null;
		}
		else {

			while (currentNode.getNext() != tail) {

				currentNode = currentNode.getNext();
			}

			data = currentNode.getNext().getData();
			tail = currentNode;
			tail.setNext(null);
		}
		return data;
	}

	/**
	 * Returns only the data at the peek of the stack
	 * but does not remove it.
	 * @return the data at the peek of the stack.
	 */
	public DataType peek() {

		return tail.getData();
	}

	public int size() {

		Node<DataType> currentNode = head;
		int size = 0;

		while (currentNode != null) {

			currentNode = currentNode.getNext();
			size++;
		}

		return size;
	}

	public boolean isEmpty() {

		if (head == null)
			return true;

		return false;
	}

	public String toString() {

		Node<DataType> currentNode = head;

		String values = "[ ";

		while (currentNode != null)  {

			values += currentNode.getData() + " ";
			currentNode = currentNode.getNext();
		}

		return (values += "]");
	}
}