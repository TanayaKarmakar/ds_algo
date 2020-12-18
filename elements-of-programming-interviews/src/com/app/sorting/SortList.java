package com.app.sorting;

import com.app.linkedlist.LinkedList;
import com.app.linkedlist.LinkedList.ListNode;

public class SortList {
	private static ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	private static ListNode merge(ListNode part1, ListNode part2) {
		if(part1 == null)
			return part2;
		if(part2 == null)
			return part1;
		
		ListNode result;
		if(part1.val < part2.val) {
			result = part1;
			result.next = merge(part1.next, part2);
		} else {
			result = part2;
			result.next = merge(part1, part2.next);
		}
		return result;
	}
	
	private static ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode mid = findMid(head);
		ListNode midNext = mid.next;
		mid.next = null;
		ListNode part1 = sortList(head);
		ListNode part2 = sortList(midNext);
		return merge(part1, part2);
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(45);
		ll.head.next.next = new ListNode(22);
		ll.head.next.next.next = new ListNode(21);
		ll.head.next.next.next.next = new ListNode(2);
		ll.head.next.next.next.next.next = new ListNode(3);
		
		ll.head = sortList(ll.head);
		
		ListNode temp = ll.head;
		
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();

	}

}
