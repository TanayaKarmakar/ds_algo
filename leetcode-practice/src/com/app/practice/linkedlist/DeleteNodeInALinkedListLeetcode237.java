package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class DeleteNodeInALinkedListLeetcode237 {
	private static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(4);
		ll.head.next = new ListNode(5);
		ll.head.next.next = new ListNode(1);
		ll.head.next.next.next = new ListNode(9);
		
		deleteNode(ll.head.next);
		
		ListNode tmp = ll.head;
		
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
	}

}
