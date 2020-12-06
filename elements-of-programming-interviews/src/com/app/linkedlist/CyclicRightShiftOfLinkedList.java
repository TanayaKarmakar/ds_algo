package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class CyclicRightShiftOfLinkedList {
	private static ListNode cyclicRightShift(ListNode head, int k) {
		int n = 1;
		ListNode tail = head;
		while(tail.next != null) {
			tail = tail.next;
			n++;
		}
		
		k = k % n;
		
		if(k == 0)
			return head;
		
		tail.next = head;
		int count = (n - k);
		
		ListNode newTail = tail;
		while(count > 0) {
			newTail = newTail.next;
			count--;
		}
		
		ListNode newHead = newTail.next;
		newTail.next = null;
		
		return newHead;
		
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(2);
		ll.head.next = new ListNode(3);
		ll.head.next.next = new ListNode(5);
		ll.head.next.next.next = new ListNode(3);
		ll.head.next.next.next.next = new ListNode(2);
		
		ll.head = cyclicRightShift(ll.head, 3);
		
		ll.displayList(ll.head);

	}

}
