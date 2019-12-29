package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

public class ReverseLinkedListRecurison {
	private static Node reverseListAnotherApproach(Node curr, Node prev) {
		if(curr == null)
			return prev;
		Node next = curr.next;
		curr.next = prev;
		return reverseListAnotherApproach(next, curr);
	}
	
	private static Node reverseList(Node head) {
		if(head == null || head.next == null)
			return head;
		Node rest = reverseList(head.next);
		Node restLast = head.next;
		restLast.next = head;
		head.next = null;
		return rest;
	}
	
	private static void displayList(Node head) {
		Node tmp = head;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.insertAtEnd(15);
		ll.insertAtEnd(20);
		ll.insertAtEnd(25);
		
		ll.head = reverseList(ll.head);
		
		displayList(ll.head);
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		
		ll.head = reverseListAnotherApproach(ll.head, null);
		
		displayList(ll.head);
	}

}
