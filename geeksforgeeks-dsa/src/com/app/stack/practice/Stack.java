package com.app.stack.practice;

public class Stack {
	Node top;
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	
	public int pop() {
		if(top == null)
			return -1;
		Node tmp = top;
		top = top.next;
		return tmp.data;
	}
	
	public int peek() {
		return top.data;
	}
	
	public void display() {
		Node tmp = top;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		stack.display();
	}

}
