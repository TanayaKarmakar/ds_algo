package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class CheckIfPalindrome {
	private static ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
		return head;
	}

	private static boolean checkIfPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode mid = findMid(head);
		ListNode midNext = mid.next;
		mid.next = null;
		midNext = reverseList(midNext);

		ListNode tmp1 = head;
		ListNode tmp2 = midNext;
		while (tmp1 != null && tmp2 != null) {
			if (tmp1.val != tmp2.val) {
				return false;
			}
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		return true;

	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(1);

		boolean ans = checkIfPalindrome(ll.head);

		System.out.println(ans);

	}

}
