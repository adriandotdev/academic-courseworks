package my.linkedlist;

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
		
		return this.next;
	}
	
	public void setData(DataType data) {
		
		this.data = data;
	}
	
	public DataType getData() {
		
		return this.data;
	}
}
