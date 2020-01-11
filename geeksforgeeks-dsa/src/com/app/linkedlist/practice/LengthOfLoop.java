package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class LengthOfLoop {
	private static int lengthOfLoop(Node head) {
		if(head == null || head.next == null)
			return 0;
		Node slow = head;
		Node fast = head;
		
		while(fast!= null && fast.next != null) {
			fast = fast.next.next;
			if(slow == fast)
				break;
			slow = slow.next;
		}
		if(slow != fast)
			return 0;
		int count = 0;
		
		while(slow.next != fast) {
			++count;
			slow = slow.next;
		}
		
		return count + 1;
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
