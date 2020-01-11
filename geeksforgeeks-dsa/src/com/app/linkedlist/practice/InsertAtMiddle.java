package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class InsertAtMiddle {
	private static void insertAtMiddle(Node head, int data) {
		Node slowPtr = head;
		Node fastPtr = head;
		
		while(fastPtr.next != null && fastPtr.next.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		
		Node mid = new Node(data);
		mid.next = slowPtr.next;
		slowPtr.next = mid;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(4);
		
		insertAtMiddle(ll.head, 3);
		
		ll.displayList();
		
		ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.insertAtEnd(20);
		ll.insertAtEnd(40);
		ll.insertAtEnd(50);
		
		insertAtMiddle(ll.head, 30);
		ll.displayList();

	}

}
