package com.app.questions.linkedlist;

public class LinkedList {
	public Node head;
	
	public static class Node {
		public int data;
		public Node next;
		boolean visited;
		
		public Node(int data) {
			this.data = data;
			this.visited = false;
		}
	}

	public void insertBegin(int data) {

	}

	public void insertAtEnd(int data) {
		Node tmp = new Node(data);
		if (head == null) {
			head = tmp;
		} else {
			Node t = head;
			while (t.next != null) {
				t = t.next;
			}
			t.next = tmp;
		}
	}

	public void display() {
		Node tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
}
