package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class ReverseSinglyLinkedList {
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
	
	private static void displayList(ListNode head) {
		ListNode tmp = head;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.head = new ListNode(1);
		ll1.head.next = new ListNode(2);
		ll1.head.next.next = new ListNode(3);
		ll1.head.next.next.next = new ListNode(4);
		
		ll1.head = reverseList(ll1.head);
		
		displayList(ll1.head);

	}

}
