package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

public class FirstNodeOfTheLoop {
	private static Node firstNodeOfLoop(Node head) {
		Node slowPtr = head;
		Node fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr)
				break;
		}
		
		if(slowPtr != fastPtr)
			return null;
		
		slowPtr = head;
		
		while(slowPtr.next != fastPtr.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		
		return fastPtr.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		Node tmp = firstNodeOfLoop(ll.head);
		System.out.println("First Node of cycle - " + ((tmp == null)? 0:tmp.data));
	}

}
