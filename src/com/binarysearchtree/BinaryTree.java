package com.binarysearchtree;

import com.queue.Queue;
import com.stack.Stack;

public class BinaryTree <T> {

	private Node<T> root;
	private Queue<Node<T>> queue = new Queue<>();

	// Inserts a new node to a tree.
	public void insert(T data) {

		Node<T> treeNode = new Node<>(data);
		/*
		 * If the tree root is null, we set the first tree node entry to it. */
		if (root == null) {

			root = new Node<>(data);	
			// Enqueue the root to the queue to check if its left and right child is null.
			queue.enqueue(root);
		}
		else {

			if (queue.peek().left == null) {

				queue.peek().left = treeNode;
				// Enqueue the left child of the currentNode at the peek of the queue to become a next node to be checked.
				queue.enqueue(treeNode);
			}
			else if (queue.peek().right == null) {

				queue.peek().right = treeNode;
				queue.enqueue(treeNode);
				// since the node at the peek of the queue has left and right child, we dequeue it to be able to check the next node.
				queue.dequeue(); 
			}
		}
	}

	/**
	 * A method that prints all the nodes in the trees
	 * in a pre-ordered manner. */
	public String preTraversal() {

		/**
		 * Traversing the tree will need a stack to store and checked the latter nodes to be printed. */
		Stack<Node<T>> stack = new Stack<>();
		String nodes = "";

		return preTrav(root, nodes, stack);
	}

	private String preTrav(Node<T> root, String data, Stack<Node<T>> stack) {
		
		/**
		 * This will become the base case. If the two conditions are not evaluated to true
		 * then the traversal will stop. */
		if (root != null || !stack.isEmpty()) {
			
			if (root != null) {
				
				/**
				 * If the tree node are visited, then the value inside of it will be store to data. */
				data += root.data + " ";
				
				/**
				 * @NOTE: ALL NODES IN THE TREE CAN BE CONSIDERED AS A ROOT NODE.
				 * Since after printing the root, we must check if its left child are not empty or null. */
				if (root.left != null) {
					
					// We push the root to the stack for later checking if it has a right node.
					stack.push(root);
					// Sets the left root as a current root.
					root = root.left;
				}
				/**
				 * On the other hand, if the left child of current tree root is null or empty, we need to check also
				 * its right child. If it is NOT empty we need only to set the right child as a CURRENT ROOT because a stack is
				 * for evaluation only for the root that not already checked its right child. */
				else if (root.right != null) 
					root = root.right;
				/**
				 * If the left and right child are empty. We set the root as null to check the stack. */
				else
					root = null;
			}
			else {
				/**
				 * This will check the node at the peek of the stack if it has a right child.
				 * If the condition is true, we set the right child of the tree node at the stack
				 * as a current root. */
				if (stack.peek().right != null) 
					root = stack.peek().right;
				/** 
				 * We pop (remove) the peek of the stack to check the other tree node
				 * inside of it. */
				stack.pop();
			}
			/*
			 * Recursive call for another traversal. */
			return preTrav(root, data, stack);
		}
		return data;
	}
	

	public void postTraversal() {

		Stack<Node<T>> stack = new Stack<>();
		Node<T> prev = null;
		
		postTrav(root, stack, prev);
	}

	private void postTrav(Node<T> root, Stack<Node<T>> stack, Node<T> prev) {

		if (stack.isEmpty() && root == null)
			return;
		else {

			if (root != null) {

				if (root.left == null && root.right == null) {

					System.out.print(root.data + " ");
					root = null;
				}
				else {

					if (root.right != null) {

						stack.push(root);
						stack.push(root.right);
					}

					if (root.left != null && root.right == null) {

						stack.push(root);
						stack.push(root.left);
						root = null;
					}
					else if (root.left != null)
						root = root.left;
					else
						root = null;
				}
				postTrav(root, stack, prev);
			}
			// FOR STACK
			else {

				if ((stack.peek().left == prev || stack.peek().right == prev) || (stack.peek().left == null && stack.peek().right == null)) {

					System.out.print(stack.peek().data + " ");
					prev = stack.pop();
				}
				else {

					if (stack.peek().left != null && stack.peek().right == null) {
						stack.push(stack.peek().left);
						root = null;
					}
					else if (stack.peek().left != null)
						root = stack.peek().left;
					else
						root = null;
					
					if (stack.peek().right != null)
						stack.push(stack.peek().right);

				}
				postTrav(root, stack, prev);
			}
		}
	}
	
	/**
	 * Prints the data inside the tree
	 * in an in-ordered manner. */
	public String inOrderTraversal() {
		
		Stack<Node<T>> stack = new Stack<>();
		String elements = "";
		
		return inOrder(this.root, stack, elements);
	}
	
	private String inOrder(Node<T> root, Stack<Node<T>> stack, String elements) {
		
		/**
		 * This will become the base case. If the two conditions are not evaluated to true
		 * then the traversal will stop. */
		if (root != null || !stack.isEmpty()) {
			
			if (root != null) {
				
				/**
				 * First, we check the right child of the current root.
				 * If this is evaluated to true, then we push the current root to the stack
				 * for the later checking of its right child. */
				if (root.left != null) {
					
					stack.push(root);
					/**
					 * We set the left child of the current root as a new root to be checked. */
					root = root.left;
					
					// We call again because the left child is not null.
					return inOrder(root, stack, elements);
				}
				/*
				 * If the above statement is not evaluated to true. It means the current root has no left child
				 * so we can print its values. */
				else
					elements += root.data + " ";
				
				/**
				 * If the left child of the root is null and after printing its value, we also need to check
				 * its right child to check and push it to the stack. */
				if (root.right != null) {
					
					stack.push(root);
					/*
					 * We set the right child of the current root as a new root. */
					root = root.right;
				}
				/**
				 * If the above conditions are evaluated to false, the we set the root as null
				 * to check the other nodes in the stack. */
				else
					root = null;
				
				return inOrder(root, stack, elements);
			}
			else {
				
				/**
				 * Since node to the stack only check to know if it has a right child. We print the 
				 * node because its left child is visited. */
				elements += stack.peek().data + " ";
				
				/**
				 * If this is evaluated to true, then the right child of the node at the peek of the stack
				 * will become a current root. */
				if (stack.peek().right != null)
					root = stack.pop().right;
				/*
				 * Otherwise, we only need to pop or remove it for the next node to be checked. */
				else
					stack.pop();
				
				return inOrder(root, stack, elements);
			}
		} 
		return elements;
	}
}