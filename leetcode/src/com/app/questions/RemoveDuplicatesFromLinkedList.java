package com.app.questions;

import com.app.questions.LinkedList.Node;

public class RemoveDuplicatesFromLinkedList {
	private static Node removeDups(Node head) {
		if (head == null || head.next == null)
			return head;
		Node curr = head;
		Node next = head;

		while (curr != null && next != null && curr.next != null) {
			next = curr.next;

			while (next != null && curr.data == next.data) {
				next = next.next;
			}

			if (curr.next != next) {
				curr.next = next;
			}
			curr = next;
		}

		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(3);
		
		ll.head = removeDups(ll.head);
		
		ll.display();

	}

}
