package com.app.stack.classroom;

public class LinkedListStack<T> {
	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node<T> head;

	public LinkedListStack() {
		this.head = null;
	}

	public void push(T data) {
		if (head == null) {
			head = new Node<>(data);
		} else {
			Node<T> temp = new Node<>(data);
			temp.next = head;
			head = temp;
		}
	}

	public T pop() {
		if (head == null)
			throw new StackEmptyException("Stack is empty");
		T data = head.data;
		Node<T> tmp = head;

		head = head.next;
		tmp.next = null;
		return data;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public T peek() {
		return head.data;
	}
}
