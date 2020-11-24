package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class ReverseLinkedListIILeetcode92 {
	private static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		dummy.next = head;

		ListNode sublistHead = dummy;
		int k = 1;

		while (k++ < m) {
			sublistHead = sublistHead.next;
		}

		ListNode sublistIter = sublistHead.next;

		while (m++ < n) {
			ListNode temp = sublistIter.next;
			sublistIter.next = temp.next;
			temp.next = sublistHead.next;
			sublistHead.next = temp;
		}

		dummy = dummy.next;
		return dummy;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);

		int m = 2;
		int n = 4;

		ll.head = reverseBetween(ll.head, m, n);

		ListNode temp = ll.head;
		
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

	}

}
