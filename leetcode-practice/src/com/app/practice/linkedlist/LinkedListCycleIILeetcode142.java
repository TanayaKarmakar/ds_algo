package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class LinkedListCycleIILeetcode142 {
	private static ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
				break;
		}
		
		if(slow != fast)
			return null;
		
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(3);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(0);
		ll.head.next.next.next = new ListNode(-4);
		ll.head.next.next.next.next = ll.head.next;
		
		ListNode ans = detectCycle(ll.head);
		
		System.out.println(ans.val);
		
		
		

	}

}
