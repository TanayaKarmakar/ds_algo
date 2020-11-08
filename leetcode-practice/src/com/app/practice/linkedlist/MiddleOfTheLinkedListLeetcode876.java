package com.app.practice.linkedlist;

import com.app.practice.LinkedList.ListNode;

public class MiddleOfTheLinkedListLeetcode876 {
	private static ListNode middleNode(ListNode head) {
		if(head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
