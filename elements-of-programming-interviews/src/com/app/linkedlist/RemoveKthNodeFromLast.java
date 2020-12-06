package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class RemoveKthNodeFromLast {
	private static ListNode removeKthElementFromLast(ListNode head, int k) {
		if(head == null)
			return null;
		if(head.next == null) {
			if(k == 1)
				return null;
			else
				return head;
		}
		
		ListNode fast = head;
		int i = k;
		while(fast != null && i-- > 0) {
			fast = fast.next;
		}
		
		if(i > 0) //value of k is more than length of linked list
			return head;
		
		ListNode slow = head;
		ListNode prev = null;
		while(fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		
		if(prev == null) // its the first node
			head = head.next;
		else if(slow.next == null) // its the last node
			prev.next = null;
		else
			prev.next = slow.next;
		return head;
		
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		
		ll.head = removeKthElementFromLast(ll.head, 3);
		
		ll.displayList(ll.head);

	}

}
