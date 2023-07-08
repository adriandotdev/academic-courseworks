package com.circularlist;

public class Main {

	public static void main(String[] args) {
		
		CircularDoublyList<Integer> list = new CircularDoublyList<>();
		
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
		
		System.out.println("My Circular List: " + list);
		
		list.addToFirst(99);
		
		System.out.println("My Circular List: " + list);
		
		list.addToFirst(88);
		
		System.out.println("My Circular List: " + list);
		
		list.addToLast(828);
		
		System.out.println("My Circular List: " + list);
		
		list.addToLast(8238);
		
		System.out.println("My Circular List: " + list);
		
		list.insertAt(0, 9999);
		
		System.out.println("My Circular List: " + list);
	}
}
