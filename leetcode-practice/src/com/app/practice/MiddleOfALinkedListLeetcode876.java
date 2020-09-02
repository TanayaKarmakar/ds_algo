package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class MiddleOfALinkedListLeetcode876 {
	private static ListNode middle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		
		ListNode mid = middle(ll.head);
		
		System.out.println(mid.val);
		
		ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		ll.head.next.next.next.next.next = new ListNode(6);
		
		mid = middle(ll.head);
		
		System.out.println(mid.val);

	}

}
