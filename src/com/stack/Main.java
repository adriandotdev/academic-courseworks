package com.stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println("My Stack: " + stack);
		System.out.println("Popped: " + stack.pop());
		System.out.println("Peeked: " + stack.peek());
		System.out.println("Popped: " + stack.pop());
		System.out.println("Peeked: " + stack.peek());
	}

}
