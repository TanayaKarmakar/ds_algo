package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class PartitionListLeetcode86 {
	private static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode ltX = new ListNode(Integer.MIN_VALUE);
		ListNode geX = new ListNode(Integer.MIN_VALUE);

		ListNode tmp1 = ltX;
		ListNode tmp2 = geX;

		ListNode tmp = head;

		while (tmp != null) {
			ListNode curr = tmp;
			tmp = tmp.next;
			curr.next = null;

			if (curr.val < x) {
				tmp1.next = curr;
				tmp1 = tmp1.next;
			} else {
				tmp2.next = curr;
				tmp2 = tmp2.next;
			}
		}

		ltX = ltX.next;
		geX = geX.next;

		if(ltX != null)
			tmp1.next = geX;
		else
			ltX = geX;
		return ltX;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(4);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(2);
		ll.head.next.next.next.next = new ListNode(5);
		ll.head.next.next.next.next.next = new ListNode(2);
		
		int x = 3;
		
		ListNode res = partition(ll.head, x);
		
		ListNode tmp = res;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		
		System.out.println();
	}

}
