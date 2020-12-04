package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class SwapNodesInPairsLeetcode24 {
	private static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		ListNode nextNext = null;

		while (curr != null && curr.next != null) {
			next = curr.next;
			nextNext = next.next;
			next.next = curr;
			curr.next = nextNext;
			if(curr == head) {
				head = next;
			}
			if (prev != null)
				prev.next = next;
			prev = curr;
			curr = nextNext;
		}
		
		return head;
	}
	
	private static void display(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
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
		ll.head.next.next.next = new ListNode(4);
		//ll.head.next.next.next.next = new ListNode(5);
		
		ll.head = swapPairs(ll.head);
		
		display(ll.head);

	}

}
