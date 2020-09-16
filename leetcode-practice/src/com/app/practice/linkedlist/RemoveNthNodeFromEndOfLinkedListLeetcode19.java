package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class RemoveNthNodeFromEndOfLinkedListLeetcode19 {
	private static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null)
			return null;

		int count = 0;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && count < n) {
			count++;
			fast = fast.next;
		}

		ListNode prev = head;
		while (fast != null) {
			prev = slow;
			fast = fast.next;
			slow = slow.next;
		}

		if(slow == head)
			head = head.next;
		else
			prev.next = slow.next;
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
		
		ll.head = removeNthFromEnd(ll.head, 2);
		
		display(ll.head);
	}

}
