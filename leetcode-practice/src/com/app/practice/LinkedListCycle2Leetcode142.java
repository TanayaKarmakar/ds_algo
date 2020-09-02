package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class LinkedListCycle2Leetcode142 {
	private static int startingPoint(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast!= null && fast.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		
		if(slow != fast)
			return -1;
		
		slow = head;
		int indx = 0;
		while(slow != fast) {
			indx++;
			slow = slow.next;
			fast = fast.next;
		}
		return indx;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(3);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(0);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = ll.head.next;
		
		int indx = startingPoint(ll.head);
		
		System.out.println(indx);

	}

}
