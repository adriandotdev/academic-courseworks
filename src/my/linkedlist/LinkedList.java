package my.linkedlist;

/*
 *  @param <T> 
 *  - Type of collection. */
public class LinkedList <T>{

	private Node<T> head;
	private Node<T> tail;

	/**
	 * Adds the data at the end of the list. */
	public void add(T data) {

		if (isEmpty()) {

			this.head = new Node<>(data);
			this.tail = this.head;
		}
		else {

			Node<T> previousTail = this.tail;
			this.tail = new Node<>(data);
			previousTail.setNext(this.tail);
		}
	}

    /*
     * Return the value at the specified index. */
	public T get(int index) {

		// initial value of current node to traverse the list.
		Node<T> currentNode = this.head;

		if (isEmpty())
			throw new IllegalArgumentException("Linked List is empty.");

		if (0 <= index && index <= getSize() - 1) {


			for (int i = 0; i != index; i++) {

				currentNode = currentNode.getNext();
			}

			return currentNode.getData();
		}
		throw new IllegalArgumentException("Index out of bounds for length " + getSize());
	}

	/*
	 * Sets the new value at the specified index. */
	public void set(int index, T newData) {

		if (isEmpty())
			return;
		else {

			if (0 <= index && index <= getSize() - 1) {


				Node<T> currentNode = this.head;

				for (int i = 0; i != index; i++) {

					currentNode = currentNode.getNext();
				}
				currentNode.setData(newData);
			}
			else
				throw new IllegalArgumentException(String.format("Invalid index for length %d", getSize()));
		}
	}

	public void addToFirst(T newData) {

		if (isEmpty()) {

			this.head = new Node<>(newData);
			this.tail = this.head;
		}
		else {

			Node<T> previousHead = this.head;
			this.head = new Node<>(newData);
			this.head = previousHead;
		}
	}

	public void removeAt(int index) {

		if (!isEmpty()) {

			Node<T> currentNode = this.head;
			// 1 2 3 4 5
			for (int counter = 0; counter != (index - 1); counter++) {

				currentNode = currentNode.getNext();
			}

			currentNode.setNext(currentNode.getNext().getNext());
		}
	}

	public void insertAt(int index, T newData) {

		if (isEmpty()) {

			// sets the new head of the list.
			addToFirst(newData);
		}
		else {

			Node<T> currentNode = this.head;
			Node<T> newNode = new Node<>(newData); // new node to be inserted.

			for (int counter = 0; counter != (index - 1); counter++) {

				currentNode = currentNode.getNext();
			}

			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);
		}
	}

	public int getSize() {

		Node<T> currentNode = this.head;
		int size = 0;

		while (currentNode != null) {

			currentNode = currentNode.getNext();
			size++;
		}

		return size;
	}

	public boolean isEmpty() {

		if (this.head == null) 
			return true;

		return false;
	}

	public void printLinkedList() {

		if (isEmpty()) {

			System.out.println("NULL");
			return;
		}
		System.out.print("LINKED LIST: ");
		print(this.head);

		System.out.println();
	}

	private void print(Node<T> currentNode) {

		if (currentNode == null)
			return;

		System.out.print(currentNode.getData() + " ");
		print(currentNode.getNext());
	}

	public String getMiddleElement() {

		Node<T> currentNode = this.head;

		for (int counter = 0; counter != getSize() / 2 - 1; counter++) {

			currentNode = currentNode.getNext();
		}

		// returns two elements if the size of the list is even.
		if (getSize() % 2 == 0)
			return currentNode.getData() + " " + currentNode.getNext().getData();
		else
			return currentNode.getNext().getData() + "";
	}

	public void removeMiddleElement() {

		if (getSize() == 1)
			printLinkedList();
		else {

			Node<T> currentNode = this.head;

			for (int counter = 0; counter != (getSize() / 2 - 1); counter++) {

				currentNode = currentNode.getNext();
			}

			currentNode.setNext(currentNode.getNext().getNext());
		}
	}

	@SuppressWarnings("unchecked")
	public void sort() {

		Node<T> currentNode = this.head;

		boolean isTrue = false;

		while (currentNode != null) {

			if (currentNode.getNext() != null && (Integer)currentNode.getData() > (Integer)currentNode.getNext().getData()) {

				Integer temp = (Integer)currentNode.getData();
				currentNode.setData(currentNode.getNext().getData());
				currentNode.getNext().setData((T)temp);

				isTrue = true;
			}
			currentNode = currentNode.getNext();
		}
		if (isTrue)
			sort();
	}

	public void removeDuplicate() {

		Node<T> currentNode = this.head;

		while(currentNode != null) {

			if (currentNode.getNext() != null && currentNode.getData().equals(currentNode.getNext().getData())) {

				currentNode.setNext(currentNode.getNext().getNext());
			}
			else
				currentNode = currentNode.getNext();
		}
	}
}