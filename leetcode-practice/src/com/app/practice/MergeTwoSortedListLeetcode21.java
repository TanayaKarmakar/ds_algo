package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class MergeTwoSortedListLeetcode21 {
	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		ListNode tmp3 = dummy;
		
		while(tmp1 != null && tmp2 != null) {
			if(tmp1.val < tmp2.val) {
				ListNode curr = tmp1;
				tmp1 = tmp1.next;
				tmp3.next = curr;
				curr.next = null;
			} else {
				ListNode curr = tmp2;
				tmp2 = tmp2.next;
				tmp3.next = curr;
				curr.next = null;
			}
			tmp3 = tmp3.next;
		}
		if(tmp1 != null) {
			tmp3.next = tmp1;
		}
		
		if(tmp2 != null) {
			tmp3.next = tmp2;
		}
		
		dummy = dummy.next;
		return dummy;
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
		
		ListNode res = mergeTwoLists(ll1.head, ll2.head);
		
		ListNode tmp = res;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

}
