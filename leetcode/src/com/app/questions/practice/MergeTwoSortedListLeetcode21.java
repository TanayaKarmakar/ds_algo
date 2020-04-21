package com.app.questions.practice;

import com.app.questions.practice.LinkedList.ListNode;

public class MergeTwoSortedListLeetcode21 {
	private static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		ListNode res = dummy;
		ListNode curr = null;

		while (tmp1 != null && tmp2 != null) {
			if (tmp1.val <= tmp2.val) {
				curr = tmp1;
				tmp1 = tmp1.next;
			} else {
				curr = tmp2;
				tmp2 = tmp2.next;
			}
			curr.next = null;
			res.next = curr;
			res = res.next;
		}

		if (tmp1 != null) {
			res.next = tmp1;
		}

		if (tmp2 != null) {
			res.next = tmp2;
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
		
		ListNode res = mergeSortedLists(ll1.head, ll2.head);
		
		ListNode tmp = res;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp= tmp.next; 
		}
		
		

	}

}
