package com.binarysearchtree;

public class Node <DataType>{

	Node<DataType> left;
	Node<DataType> right;
	DataType data;

	
	public Node(DataType data) {
		
		this.data = data;
	}
}
