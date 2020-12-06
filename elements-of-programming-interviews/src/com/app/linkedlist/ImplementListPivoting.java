package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class ImplementListPivoting {
	private static ListNode listPivoting(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode lt = new ListNode(Integer.MAX_VALUE);
		ListNode gt = new ListNode(Integer.MAX_VALUE);
		ListNode eq = new ListNode(Integer.MAX_VALUE);

		ListNode ltTmp = lt;
		ListNode gtTmp = gt;
		ListNode eqTmp = eq;

		ListNode tmp = head;
		ListNode curr = null;

		while (tmp != null) {
			curr = tmp;
			tmp = tmp.next;
			curr.next = null;

			if (curr.val < k) {
				ltTmp.next = curr;
				ltTmp = ltTmp.next;
			} else if (curr.val == k) {
				eqTmp.next = curr;
				eqTmp = eqTmp.next;
			} else {
				gtTmp.next = curr;
				gtTmp = gtTmp.next;
			}
		}

		lt = lt.next;
		gt = gt.next;
		eq = eq.next;
		ltTmp.next = eq;
		eqTmp.next = gt;

		return lt;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(3);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(2);
		ll.head.next.next.next = new ListNode(11);
		ll.head.next.next.next.next = new ListNode(7);
		ll.head.next.next.next.next.next = new ListNode(5);
		ll.head.next.next.next.next.next.next = new ListNode(11);

		ll.head = listPivoting(ll.head, 7);

		ll.displayList(ll.head);
	}

}
