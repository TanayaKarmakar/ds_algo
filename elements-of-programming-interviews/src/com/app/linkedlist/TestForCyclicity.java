package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class TestForCyclicity {
	private static ListNode findCycle(ListNode head) {
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
		
		ListNode ans = findCycle(ll.head);
		
		System.out.println(ans.val);

	}

}
