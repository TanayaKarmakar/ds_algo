package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class DeleteDuplicateNodesFromSortedList {
	private static void deleteDuplicateNodes(Node head) {
		if(head == null || head.next == null)
			return;
		Node curr = head;
		Node next = curr.next;
		
		while(next != null) {
			if(curr.data == next.data) {
				if(next.next == null) {
					curr.next = null;
					next = curr.next;
				} else {
					next = next.next;
					curr.next = next;
				}
			} else {
				curr = next;
				next = curr.next;
			}
		}
		
	}

	public static void main(String[] args) {
		LinkedList ll =  new LinkedList();
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		
		deleteDuplicateNodes(ll.head);
		
		ll.displayList();
		
		ll = new LinkedList();
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);
		
		deleteDuplicateNodes(ll.head);
		
		ll.displayList();
		
		ll = new LinkedList();
		ll.insertAtEnd(3);
		ll.insertAtEnd(3);
		ll.insertAtEnd(3);
		ll.insertAtEnd(3);
		
		deleteDuplicateNodes(ll.head);
		
		ll.displayList();

	}

}
