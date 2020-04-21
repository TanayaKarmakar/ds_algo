package com.app.questions.practice;

import com.app.questions.practice.LinkedList.ListNode;

public class ReverseLinkedListLeetcode206 {
	private static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = head;
		ListNode next = prev.next;
		ListNode nextNext = null;

		while (next != null) {
			nextNext = next.next;
			next.next = prev;
			if(prev == head)
				prev.next = null;
			prev = next;
			next = nextNext;
		}
		return prev;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		
		ll.head = reverseList(ll.head);
		
		ListNode tmp = ll.head;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

}
