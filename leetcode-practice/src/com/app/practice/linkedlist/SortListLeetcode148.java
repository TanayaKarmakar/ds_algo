package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class SortListLeetcode148 {
	private static ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
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
	
	private static ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode mid = findMid(head);
		ListNode midNext = mid.next;
		mid.next = null;
		ListNode left = sortList(head);
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
		
		ListNode tmp = ll.head;
		
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		
		System.out.println();
		
		ll = new LinkedList();
		ll.head = new ListNode(-1);
		ll.head.next = new ListNode(5);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(0);
		
		ll.head = sortList(ll.head);
		
		tmp = ll.head;
		
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}

		System.out.println();
	}

}
