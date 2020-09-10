package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class SwapNodesInPairsLeetcode24 {
	private static ListNode swapPairs(ListNode head) {
		ListNode prev = head;
		ListNode curr;
		ListNode next;
		ListNode prevPrev = null;

		while (prev != null && prev.next != null) {
			curr = prev.next;
			next = curr.next;
			curr.next = prev;
			prev.next = next;
			if (prevPrev != null)
				prevPrev.next = curr;

			if (prev == head)
				head = curr;
			prevPrev = prev;
			prev = next;
		}

		return head;
	}
	
	private static void display(ListNode head) {
		ListNode tmp = head;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		
		ll.head = swapPairs(ll.head);
		
		display(ll.head);
	}

}
