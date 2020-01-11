package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class ReverseNodes {
	private static Node reverseList(Node head) {
		if(head == null || head.next == null)
			return head;
		Node prev = head;
		Node curr = prev.next;
		
		while(curr!= null) {
			Node next = curr.next;
			curr.next = prev;
			
			if(prev == head)
				prev.next = null;
			prev = curr;
			curr = next;
		}
		
		head = prev;
		
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		
		ll.head = reverseList(ll.head);
		
		ll.displayList();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		
		ll.head = reverseList(ll.head);
		
		ll.displayList();
	}

}
