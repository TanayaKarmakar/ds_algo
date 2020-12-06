package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class RemoveDuplicatesFromSortedList {
	private static ListNode removeDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode q = null;

		while (p != null) {
			q = p.next;
			while (q != null && p.val == q.val) {
				q = q.next;
			}

			p.next = q;
			p = q;
		}

		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(2);
		ll.head.next.next.next = new ListNode(3);
		ll.head.next.next.next.next = new ListNode(3);
		ll.head.next.next.next.next.next = new ListNode(3);
		ll.head.next.next.next.next.next.next = new ListNode(4);
		ll.head.next.next.next.next.next.next.next = new ListNode(5);
		ll.head.next.next.next.next.next.next.next.next = new ListNode(5);

		ll.head = removeDuplicates(ll.head);

		ll.displayList(ll.head);

	}

}
