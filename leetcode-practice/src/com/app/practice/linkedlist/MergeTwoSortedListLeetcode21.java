package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class MergeTwoSortedListLeetcode21 {
	private static ListNode mergeLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode tmp3 = res;
		
		while(tmp1 != null && tmp2 != null) {
			ListNode curr;
			if(tmp1.val <= tmp2.val) {
				curr = tmp1;
				tmp1 = tmp1.next;
			} else {
				curr = tmp2;
				tmp2 = tmp2.next;
			}
			curr.next = null;
			tmp3.next = curr;
			tmp3 = tmp3.next;
		}
		if(tmp1 != null)
			tmp3.next = tmp1;
		
		if(tmp2 != null)
			tmp3.next = tmp2;
		
		res = res.next;
		return res;
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
		
		ListNode res = mergeLists(ll1.head, ll2.head);
		ListNode temp = res;
		
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

	}

}
