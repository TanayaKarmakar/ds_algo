package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class PartitionListLeetcode86 {
	private static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode lt = new ListNode(Integer.MAX_VALUE);
		ListNode ge = new ListNode(Integer.MAX_VALUE);
		ListNode ltTmp = lt;
		ListNode geTmp = ge;
		ListNode tmp = head;

		while (tmp != null) {
			ListNode curr = tmp;
			tmp = tmp.next;
			curr.next = null;

			if (curr.val < x) {
				ltTmp.next = curr;
				ltTmp = ltTmp.next;
			} else {
				geTmp.next = curr;
				geTmp = geTmp.next;
			}
		}

		lt = lt.next;
		ge = ge.next;
		
		if(lt == null)
			return ge;

		ltTmp.next = ge;
		return lt;
	}

	private static void displayList(ListNode head) {
		ListNode tmp = head;
		while (tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(4);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(2);
		ll.head.next.next.next.next = new ListNode(5);
		ll.head.next.next.next.next.next = new ListNode(2);

		ll.head = partition(ll.head, 3);
		displayList(ll.head);

	}

}
