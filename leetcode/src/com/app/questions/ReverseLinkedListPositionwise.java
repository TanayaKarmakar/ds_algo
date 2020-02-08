package com.app.questions;

import com.app.questions.LinkedList.Node;

//problem statement -
//Reverse a linked list from position m to n. Do it in one-pass.

// Note: 1 ≤ m ≤ n ≤ length of list.
public class ReverseLinkedListPositionwise {
	//TBD
	private static Node reverseList(Node head, int m, int n) {
		return null;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);

		ll.head = reverseList(ll.head, 3, 5);
		ll.display();

	}

}
