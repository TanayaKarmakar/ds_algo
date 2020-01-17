package com.app.queue.classroom;

//Queue using linked list
public class Queue {
	Node front, rear;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void enqueue(int data) {
		Node tmp = new Node(data);
		if(front == null) {
			front = tmp;
			rear = tmp;
		} else {
			rear.next = tmp;
			rear = tmp;
		}
	}
	
	public int dequeue() {
		if(front == null)
			return -1;
		int x = front.data;
		front = front.next;
		return x;
	}
	
	public void display() {
		Node tmp = front;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		
		System.out.println("Dequeue - " + q.dequeue());
		
		q.display();

	}

}
