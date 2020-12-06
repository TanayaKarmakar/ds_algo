package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class MergeTwoSortedLists {
	private static ListNode mergeLists(ListNode a, ListNode b) {
		if(a == null)
			return b;
		if(b == null)
			return a;
		ListNode tmp1 = a;
		ListNode tmp2 = b;
		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode tmp3 = res;
		
		while(tmp1 != null && tmp2 != null) {
			if(tmp1.val < tmp2.val) {
				tmp3.next = tmp1;
				tmp1 = tmp1.next;
			} else {
				tmp3.next = tmp2;
				tmp2 = tmp2.next;
			}
			tmp3 = tmp3.next;
		}
		
		while(tmp1 != null) {
			tmp3.next = tmp1;
			tmp1 = tmp1.next;
			tmp3 = tmp3.next;
		}
		
		while(tmp2 != null) {
			tmp3.next = tmp2;
			tmp2 = tmp2.next;
			tmp3 = tmp3.next;
		}
		
		tmp3.next = null;
		res  = res.next;
		return res;
		
	}
	
	private static void displayList(ListNode head) {
		ListNode tmp = head;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.head = new ListNode(2);
		ll1.head.next = new ListNode(5);
		ll1.head.next.next = new ListNode(7);
		
		LinkedList ll2 = new LinkedList();
		ll2.head = new ListNode(3);
		ll2.head.next = new ListNode(11);
		
		ll1.head = mergeLists(ll1.head, ll2.head);
		
		displayList(ll1.head);

	}

}
