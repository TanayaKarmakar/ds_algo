package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class ReverseLinkedListLeetcode206 {
	private static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		// ll.head.next.next.next.next = new ListNode(5);

		ll.head = reverseList(ll.head);
		ListNode tmp = ll.head;
		while (tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}

		System.out.println();

	}

}
