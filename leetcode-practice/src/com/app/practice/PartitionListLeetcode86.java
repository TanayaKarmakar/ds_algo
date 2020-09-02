package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class PartitionListLeetcode86 {
	private static final int DUMMY = Integer.MAX_VALUE;

	private static ListNode partitionList(ListNode head, int target) {
		ListNode lessThan = new ListNode(DUMMY);
		ListNode greaterThanOrEqual = new ListNode(DUMMY);

		ListNode ltTemp = lessThan;
		ListNode gtTemp = greaterThanOrEqual;

		ListNode tmp = head;
		while (tmp != null) {
			ListNode curr = tmp;
			tmp = tmp.next;
			curr.next = null;
			if (curr.val < target) {
				ltTemp.next = curr;
				ltTemp = ltTemp.next;
			} else {
				gtTemp.next = curr;
				gtTemp = gtTemp.next;
			}
		}
		lessThan = lessThan.next;
		greaterThanOrEqual = greaterThanOrEqual.next;
		if(lessThan == null)
            return greaterThanOrEqual;
		ltTemp.next = greaterThanOrEqual;
		return lessThan;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(4);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(2);
		ll.head.next.next.next.next = new ListNode(5);
		ll.head.next.next.next.next.next = new ListNode(2);

		ListNode res = partitionList(ll.head, 0);

		ListNode temp = res;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

		System.out.println();
	}

}
