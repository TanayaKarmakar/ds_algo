package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class NthNodeFromLast {
	private static int getNthNodeFromLast(Node head, int n) {
		if (head == null)
			return -1;
		Node fastPtr = head;
		Node slowPtr = head;

		int count = 0;
		while (count != n && fastPtr != null) {
			fastPtr = fastPtr.next;
			count++;
		}

		if (fastPtr == null)
			return -1;

		while (fastPtr != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}

		return slowPtr.data;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		for (int i = 1; i <= 9; i++) {
			ll.insertAtEnd(i);
		}

		System.out.println(getNthNodeFromLast(ll.head, 2));
		
		ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.insertAtEnd(5);
		ll.insertAtEnd(100);
		ll.insertAtEnd(5);
		
		System.out.println(getNthNodeFromLast(ll.head, 5));

	}

}
