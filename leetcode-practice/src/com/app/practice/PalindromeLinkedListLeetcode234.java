package com.app.practice;

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
	
	private static ListNode reverse(ListNode head) {
		if(head == null || head.next == null)
			return head;
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
		midNext = reverse(midNext);
		
		ListNode tmp1 = head;
		ListNode tmp2 = midNext;
		
		while(tmp1 != null && tmp2 != null) {
			if(tmp1.val != tmp2.val)
				return false;
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		
		if((tmp1 == null && tmp2 == null) || (tmp1.next == null && tmp2 == null))
			return true;
		return false;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		
		System.out.println(isPalindrome(head));
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		
		System.out.println(isPalindrome(head));

	}

}
