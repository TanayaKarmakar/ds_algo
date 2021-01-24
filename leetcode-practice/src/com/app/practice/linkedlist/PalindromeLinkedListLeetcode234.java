package com.app.practice.linkedlist;

import com.app.practice.LinkedList.ListNode;

public class PalindromeLinkedListLeetcode234 {
	private static ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	private static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null)
			return true;
		
		
		ListNode mid = findMid(head);
		ListNode midNext = mid.next;
		mid.next = null;
		
		midNext = reverseList(midNext);
		
		ListNode temp1 = head;
		ListNode temp2 = midNext;
		
		while(temp1 != null && temp2 != null) {
			if(temp1.val != temp2.val)
				return false;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		
		return (temp1 == null || temp1.next == null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
