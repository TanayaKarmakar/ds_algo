package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class PalindromeLinkedListLeetcode234 {
	private static ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
		return head;
	}

	private static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode mid = findMid(head);

		ListNode midNext = mid.next;
		mid.next = null;

		ListNode revHead = reverseList(midNext);
		ListNode tmp1 = head;
		ListNode tmp2 = revHead;

		while (tmp1 != null && tmp2 != null) {
			if (tmp1.val != tmp2.val)
				return false;
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}

		if (tmp2 == null || tmp2.next == null)
			return true;
		return false;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(2);
		ll.head.next.next.next = new ListNode(1);

		boolean isPalindrome = isPalindrome(ll.head);

		System.out.println(isPalindrome);

		ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(2);
		ll.head.next.next.next.next = new ListNode(1);

		isPalindrome = isPalindrome(ll.head);

		System.out.println(isPalindrome);
	}

}
