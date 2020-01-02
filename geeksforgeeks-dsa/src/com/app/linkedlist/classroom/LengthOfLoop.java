package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

public class LengthOfLoop {
	private static int lengthOfLoop(Node head) {
		Node slowPtr = head;
		Node fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr)
				break;
		}
		
		if(slowPtr != fastPtr)
			return 0;
		
		int k = 0;
		while(slowPtr.next != fastPtr) {
			++k;
			slowPtr = slowPtr.next;
		}
		
		return k + 1;
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
		
		System.out.println("Length of loop - " + lengthOfLoop(ll.head));

	}

}
