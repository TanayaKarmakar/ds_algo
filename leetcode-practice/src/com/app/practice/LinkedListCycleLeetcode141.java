package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class LinkedListCycleLeetcode141 {
	private static boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
				break;
		}
		if(slow == fast)
			return true;
		return false;
	}

	public static void main(String[] args) {
		

	}

}
