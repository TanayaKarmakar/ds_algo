package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

//Loop detection algorithm
public class FloydCycleDetection {
	private static boolean isCycleExists(Node head) {
		Node slowPtr = head;
		Node fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(15);
		ll.insertAtEnd(10);
		ll.insertAtEnd(12);
		ll.insertAtEnd(20);
		
		Node tmp1 = ll.head;
		while(tmp1.next != null) {
			tmp1 = tmp1.next;
		}
		
		tmp1.next = ll.head.next;
		System.out.println("Loop exists - " + isCycleExists(ll.head));
		
		ll = new LinkedList();
		System.out.println("Loop Exists - " + isCycleExists(ll.head));
		
		ll.insertAtEnd(10);
		ll.insertAtEnd(20);
		System.out.println("Loop Exists - " + isCycleExists(ll.head));
	}

}
