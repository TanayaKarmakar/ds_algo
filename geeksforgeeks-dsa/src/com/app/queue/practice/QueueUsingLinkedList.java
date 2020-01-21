package com.app.queue.practice;

public class QueueUsingLinkedList {
	Node front;
	Node rear;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public QueueUsingLinkedList() {
		front = rear = null;
	}
	
	public void add(int data) {
		Node tmp = new Node(data);
		if(front == null) {
			front = tmp;
			rear = front;
		} else {
			rear.next = tmp;
			rear = tmp;
		}
	}
	
	public int remove() {
		if(front == null)
			return -1;
		int el = front.data;
		front = front.next;
		return el;
	}

	public static void main(String[] args) {
		QueueUsingLinkedList qll = new QueueUsingLinkedList();
		qll.add(1);
		qll.add(2);
		qll.add(3);
		qll.add(4);
		qll.add(5);
		
		System.out.println("Popped item - " + qll.remove());
		System.out.println("Popped item - " + qll.remove());
	}

}
