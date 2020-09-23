package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class RemoveDuplicatesFromSortedListIILeetcode82 {
	private static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode curr = head;
		ListNode next = null;
		while (curr != null && curr.next != null) {
			next = curr.next;
			while (next != null && curr.val == next.val) {
				next = next.next;
			}

			if (curr.next != next) {
				prev.next = next;
			} else {
				prev = curr;
			}
			curr = next;
		}

		dummy = dummy.next;
		return dummy;
	}

	private static void displayList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(3);
		ll.head.next.next.next.next = new ListNode(4);
		ll.head.next.next.next.next.next = new ListNode(4);
		ll.head.next.next.next.next.next.next = new ListNode(5);

		ll.head = deleteDuplicates(ll.head);

		displayList(ll.head);

		ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(1);
		ll.head.next.next = new ListNode(1);
		ll.head.next.next.next = new ListNode(3);
		ll.head.next.next.next.next = new ListNode(4);
		ll.head.next.next.next.next.next = new ListNode(4);

		ll.head = deleteDuplicates(ll.head);

		displayList(ll.head);
	}

}
