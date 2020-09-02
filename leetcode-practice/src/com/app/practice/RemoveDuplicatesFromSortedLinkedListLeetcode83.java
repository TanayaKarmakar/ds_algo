package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class RemoveDuplicatesFromSortedLinkedListLeetcode83 {
	private static ListNode removeDuplicates(ListNode head) {
		ListNode temp = head;
		while(temp != null && temp.next != null) {
			ListNode next = temp.next;
			while(next != null && temp.val == next.val)
				next = next.next;
			temp.next = next;
			temp = next;
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(1);
		ll.head.next.next = new ListNode(2);
		ll.head.next.next.next = new ListNode(3);
		ll.head.next.next.next.next = new ListNode(3);
		
		ListNode res = removeDuplicates(ll.head);
		
		ListNode tmp = res;
		
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

}
