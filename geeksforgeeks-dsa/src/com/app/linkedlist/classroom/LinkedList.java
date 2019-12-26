package com.app.linkedlist.classroom;

public class LinkedList {
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
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

	public void displayList() {
		Node tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
}
