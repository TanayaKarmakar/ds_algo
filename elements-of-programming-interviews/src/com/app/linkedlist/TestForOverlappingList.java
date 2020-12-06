package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class TestForOverlappingList {
	private static int length(ListNode head) {
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		return len;
	}

	private static ListNode findOverlappingPoint(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return null;
		int m = length(l1);
		int n = length(l2);

		if (m < n) {
			ListNode tmp = l1;
			l1 = l2;
			l2 = tmp;

			int tmpLen = m;
			m = n;
			n = tmpLen;
		}

		int diff = (m - n);
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;

		while (tmp1 != null && diff-- > 0) {
			tmp1 = tmp1.next;
		}

		while (tmp1 != tmp2) {
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}

		return tmp1;
	}

	public static void main(String[] args) {
		
	}

}
