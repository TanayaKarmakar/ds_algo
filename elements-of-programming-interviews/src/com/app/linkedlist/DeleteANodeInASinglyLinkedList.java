package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class DeleteANodeInASinglyLinkedList {
	private static void deleteNode(ListNode target) {
		target.val = target.next.val;
		target.next = target.next.next;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		
		ListNode target = ll.head;
		
		deleteNode(target);
		
		ll.displayList(ll.head);

	}

}
