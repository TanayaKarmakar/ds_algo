package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

public class DetectAndRemoveLoop {
	private static void detectAndRemoveLoop(Node head) {
		Node slowPtr = head;
		Node fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr)
				break;
		}
		
		if(slowPtr != fastPtr)
			return;
		
		slowPtr = head;
		while(slowPtr.next != fastPtr.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		
		fastPtr.next = null;
	}
	
	private static void displayList(Node head) {
		Node tmp = head;
		
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
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
		detectAndRemoveLoop(ll.head);
		displayList(ll.head);
	}

}
