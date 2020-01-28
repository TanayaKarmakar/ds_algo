package com.app.questions;

import com.app.questions.LinkedList.Node;

//TBD
public class RotateList {
	private static int length(Node head) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			++count;
		}
		return count;
	}

	private static Node rotateList(Node head, int k) {
		//if list size 0 or 1 no need to rotate, simply return
		if(head == null || head.next == null)
	        return head;
		int len = length(head);
		
		//in case k value is greater than len, do a modulus
		if (k > len) {
			k = k % len;
		}
		
		//if k value is 0 or same as len, no need to anything
		//simply return
		if(k == 0 || k == len)
			return head;

		//otherwise find the number kth position from the end
		//divide the list into two
		// 1. list before kth number
		// 2. list from kth number
		// now the cut the list from kth number from
		// its previous one
		// and add it to the previous one
		Node fastPtr = head;
		Node slowPtr = head;

		int cnt = k;
		while (cnt > 0) {
			fastPtr = fastPtr.next;
			cnt--;
		}

		Node prevSlowPtr = head;
		Node prevFastPtr = fastPtr;
		while (fastPtr!= null) {
			prevFastPtr = fastPtr;
			prevSlowPtr = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}

		prevSlowPtr.next = null;
		prevFastPtr.next = head;
		head = slowPtr;
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);

		ll.head = rotateList(ll.head, 2);
		ll.display();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		
		ll.head = rotateList(ll.head, 1);
		ll.display();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		
		ll.head = rotateList(ll.head, 6);
		ll.display();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		
		ll.head = rotateList(ll.head, 2);
		ll.display();

	}

}
