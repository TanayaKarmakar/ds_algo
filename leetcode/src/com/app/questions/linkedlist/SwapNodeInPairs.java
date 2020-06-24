package com.app.questions.linkedlist;

import com.app.questions.linkedlist.LinkedList.Node;

public class SwapNodeInPairs {
	private static Node swapNodes(Node head) {
		if(head == null || head.next == null)
			return head;
		Node prev = head;
		Node curr;
		Node next;
		Node prevPrev = null;
		while(prev != null && prev.next != null) {
			curr = prev.next;
			next = curr.next;
			curr.next = prev;
			prev.next = next;
			if(prevPrev != null) {
				prevPrev.next = curr;
			}
			if(prev == head)
				head = curr;
			prevPrev = prev;
			prev = next;
		}
		
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		ll.head = swapNodes(ll.head);
		ll.display();
		
		ll = new LinkedList();
		ll.head = new Node(1);
		
		ll.head = swapNodes(ll.head);
		ll.display();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		
		ll.head = swapNodes(ll.head);
		ll.display();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		
		ll.head = swapNodes(ll.head);
		ll.display();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		
		ll.head = swapNodes(ll.head);
		ll.display();
		
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		
		ll.head = swapNodes(ll.head);
		ll.display();
	}

}
