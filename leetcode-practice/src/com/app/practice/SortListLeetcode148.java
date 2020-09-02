package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class SortListLeetcode148 {
	private static ListNode findMiddle(ListNode l) {
		ListNode slow = l;
		ListNode fast = l;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static ListNode merge(ListNode a, ListNode b) {
		if(a == null)
			return b;
		if(b == null)
			return a;
		ListNode result;
		if(a.val <= b.val) {
			result = a;
			result.next = merge(a.next, b);
		} else {
			result = b;
			result.next = merge(a, b.next);
		}
		return result;
	}
	
	private static ListNode sortList(ListNode l1) {
		if(l1 == null || l1.next == null)
			return l1;
		ListNode mid = findMiddle(l1);
		ListNode midNext = mid.next;
		mid.next = null;
		ListNode left = sortList(l1);
		ListNode right = sortList(midNext);
		return merge(left, right);
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(4);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(1);
		ll.head.next.next.next = new ListNode(3);
		
		ll.head = sortList(ll.head);
		
		ListNode res = ll.head;
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		System.out.println();
	}

}
