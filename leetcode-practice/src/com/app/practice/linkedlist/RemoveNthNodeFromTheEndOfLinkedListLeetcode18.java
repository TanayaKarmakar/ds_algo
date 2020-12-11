package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class RemoveNthNodeFromTheEndOfLinkedListLeetcode18 {
	private static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null)
			return head;
		if(head.next == null) {
			if(n == 1)
				return null;
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		
		int i = 0;
		while(i < n) {
			fast = fast.next;
			i++;
		}
		
		ListNode prev = head;
		while(fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		
		if(slow == head)
			head = head.next;
		else
			prev.next = slow.next;
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
//		ll.head.next.next = new ListNode(3);
//		ll.head.next.next.next = new ListNode(4);
//		ll.head.next.next.next.next = new ListNode(5);
		
		int n = 1;
		ll.head = removeNthFromEnd(ll.head, n);
		
		ListNode tmp = ll.head;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		
		System.out.println();
	}

}
