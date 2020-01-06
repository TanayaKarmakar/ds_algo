package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import static com.app.linkedlist.classroom.LinkedList.Node;

public class CountNodes {
	private static int countNodes(Node head) {
		int count = 0;
		Node tmp = head;
		while(tmp != null) {
			count++;
			tmp = tmp.next;
		}
		
		return count;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.insertAtEnd(15);
		ll.insertAtEnd(20);
		ll.insertAtEnd(25);
		ll.insertAtEnd(30);
		ll.insertAtEnd(35);
		ll.insertAtEnd(40);

		System.out.println("Count - " + countNodes(ll.head));
	}

}
