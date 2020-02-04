package com.app.questions;

import com.app.questions.LinkedList.Node;

public class ReverseList {
	private static Node reverse1(Node head) {
		if(head == null || head.next == null)
			return head;
		Node prev = head;
		Node curr = prev.next;
		head.next = null;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
		return prev;	
	}
	
	private static Node reverse(Node head) {
		if(head == null || head.next == null)
			return head;
		
		Node prev = head;
		Node curr = prev.next;
		Node next = null;
		Node last = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			if(prev == head) {
				prev.next = next;
				last = prev;
			} else {
				last.next = next;
			}
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
		
		ll.head = reverse1(ll.head);
		
		ll.display();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		
		ll.head = reverse1(ll.head);
		
		ll.display();

	}

}
