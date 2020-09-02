package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class SwapNodeInPairsLeetcode24 {
	private static ListNode swapNodes(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode prev = head;
		ListNode prevPrev = null;
		ListNode curr;
		ListNode next;
		
		while(prev != null && prev.next != null) {
			curr = prev.next;
			next = curr.next;
			curr.next = prev;
			prev.next = next;
			if(prevPrev != null)
				prevPrev.next = curr;
			if(prev == head)
				head = curr;
			prevPrev = prev;
			prev = next;
		}
		
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		
		ll.head = swapNodes(ll.head);
		
		ListNode res = ll.head;
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		System.out.println();
	}

}
