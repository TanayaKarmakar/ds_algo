package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class RemoveNthNodeFromEndLeetcode19 {
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
		
		while(fastPtr != null) {
			prev = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		
		if(slowPtr == head)
			head = head.next;
		else
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
		
		ListNode temp = ll.head;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();

	}

}
