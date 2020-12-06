package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class ReverseSublistSinglePass {
	private static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		dummy.next = head;

		ListNode sublistHead = dummy;

		int k = 1;
		while (k++ < m) {
			sublistHead = sublistHead.next;
		}

		ListNode sublistIter = sublistHead.next;
		while (m++ < n) {
			ListNode tmp = sublistIter.next;
			sublistIter.next = tmp.next;
			tmp.next = sublistHead.next;
			sublistHead.next = tmp;
		}
		
		dummy = dummy.next;
		return dummy;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(11);
		ll.head.next = new ListNode(3);
		ll.head.next.next = new ListNode(5);
		ll.head.next.next.next = new ListNode(7);
		ll.head.next.next.next.next = new ListNode(2);
		
		ll.head = reverseBetween(ll.head, 2, 4);
		
		ll.displayList(ll.head);

	}

}
