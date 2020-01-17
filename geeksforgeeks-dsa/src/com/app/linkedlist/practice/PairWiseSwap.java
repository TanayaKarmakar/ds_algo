package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class PairWiseSwap {
	private static Node pairWiseSwap(Node head) {
		if(head == null || head.next == null)
			return head;
		Node prev = head;
		Node curr = prev.next;
		Node tmp = null;
		Node next = null;
		
		while(curr!= null) {
			next = curr.next;
			
			curr.next = prev;
			prev.next = next;
			
			if(tmp != null)
				tmp.next = curr;
			
			if(prev == head)
				head = curr;
			
			tmp = prev;
			if(next != null) {
				prev = next;
				curr = prev.next;
			} else {
				break;
			}		
		}	
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		
		ll.head = pairWiseSwap(ll.head);
		
		ll.displayList();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		
		ll.head = pairWiseSwap(ll.head);
		
		ll.displayList();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		
		ll.head = pairWiseSwap(ll.head);
		
		ll.displayList();

	}

}
