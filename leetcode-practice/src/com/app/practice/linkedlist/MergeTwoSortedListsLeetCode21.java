package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class MergeTwoSortedListsLeetCode21 {
	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode result = new ListNode(Integer.MAX_VALUE);
		ListNode temp = result;

		ListNode temp1 = l1;
		ListNode temp2 = l2;

		while (temp1 != null && temp2 != null) {
			ListNode curr = null;
			if (temp1.val < temp2.val) {
				curr = temp1;
				temp1 = temp1.next;
			} else {
				curr = temp2;
				temp2 = temp2.next;
			}
			curr.next = null;
			temp.next = curr;
			temp = temp.next;
		}

		if (temp1 != null) {
			temp.next = temp1;
		}
		if (temp2 != null) {
			temp.next = temp2;
		}

		result = result.next;
		return result;
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.head = new ListNode(1);
		ll1.head.next = new ListNode(2);
		ll1.head.next.next = new ListNode(4);
		
		LinkedList ll2 = new LinkedList();
		ll2.head = new ListNode(1);
		ll2.head.next = new ListNode(3);
		ll2.head.next.next = new ListNode(4);
		
		ListNode result = mergeTwoLists(ll1.head, ll2.head);
		ListNode temp = result;
		
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();

	}

}
