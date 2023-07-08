package com.binarysearchtree;

public class Main {

	public static void main(String[] args) {
		
		BinaryTree<Integer> bt = new BinaryTree<>();
		
		bt.insert(1);
		bt.insert(2);
		bt.insert(3);
		bt.insert(4);
		bt.insert(5);
		bt.insert(6);
		bt.insert(7);
		bt.insert(8);
		
		System.out.print("PRE ORDER: " + bt.preTraversal());
		System.out.println("\nIN ORDER: " + bt.inOrderTraversal());
	}
}