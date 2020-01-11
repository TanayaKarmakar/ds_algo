package com.app.linkedlist.practice;

import java.util.HashSet;
import java.util.Set;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class DeleteDuplicateNodesFromUnsortedList {
	private static void deleteDuplicateNodes(Node head) {
		if(head == null || head.next == null)
			return;
		Set<Integer> numSet = new HashSet<>();
		Node tmp = head;
		numSet.add(tmp.data);
		
		while(tmp.next!= null) {
			if(numSet.contains(tmp.next.data)) {
				tmp.next = tmp.next.next;
			} else {
				tmp = tmp.next;
				if(tmp != null) {
					numSet.add(tmp.data);
				}
			}
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);
		
		deleteDuplicateNodes(ll.head);
		
		ll.displayList();
		
		ll = new LinkedList();
		ll.insertAtEnd(5);
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);
		ll.insertAtEnd(4);
		
		deleteDuplicateNodes(ll.head);
		
		ll.displayList();
		
		ll = new LinkedList();
		ll.insertAtEnd(5);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(2);
		
		deleteDuplicateNodes(ll.head);
		
		ll.displayList();

	}

}
