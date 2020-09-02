package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class ReverseListInKGroupLeetcode25 {
	private static ListNode reverseKGroup(ListNode head, int k) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		
		int count = 0;
		while(curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next != null) {
			ListNode rest = reverseKGroup(next, k);
			head.next = rest;
		}
		
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		
		head = reverseKGroup(head, 3);
		
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

		System.out.println();
	}

}
