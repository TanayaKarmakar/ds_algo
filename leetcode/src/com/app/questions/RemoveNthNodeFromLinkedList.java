package com.app.questions;

import com.app.questions.LinkedList.Node;

class LinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void insertAtEnd(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = new Node(data);
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

public class RemoveNthNodeFromLinkedList {
	public static Node removeFromEnd(Node head, int n) {
		Node fastPtr = head;
		Node slowPtr = head;
		Node prev = head;

		int count = n;
		while (count > 0) {
			fastPtr = fastPtr.next;
			count--;
		}

		while (fastPtr != null) {
			prev = slowPtr;
			fastPtr = fastPtr.next;
			slowPtr = slowPtr.next;
		}
		
		if(slowPtr == head)
			head = head.next;
		else
			prev.next = slowPtr.next;
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);

		ll.display();
		
		ll.head = removeFromEnd(ll.head, 2);
		
		ll.display();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		
		ll.head = removeFromEnd(ll.head, 2);
		
		ll.display();

	}

}
