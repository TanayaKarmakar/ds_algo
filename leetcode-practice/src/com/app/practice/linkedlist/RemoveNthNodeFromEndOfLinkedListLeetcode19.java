package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class RemoveNthNodeFromEndOfLinkedListLeetcode19 {
	private static ListNode removeNthNode(ListNode head, int n) {
		if(head == null)
			return null;
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		ListNode prev = head;
		
		int count = n;
		while(count > 0) {
			fastPtr = fastPtr.next;
			count--;
		}
		
		
		while(fastPtr!= null) {
			prev = slowPtr;
			fastPtr = fastPtr.next;
			slowPtr = slowPtr.next;
		}
		
		if(slowPtr == head) {
			head = head.next;
			return head;
		}
		
		prev.next = slowPtr.next;
		return head;
		
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		
		ll.head = removeNthNode(ll.head, 2);
		
		ListNode tmp = ll.head;
		
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		
		System.out.println();

	}

}
