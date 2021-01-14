package com.app.janchallenge2021;

import com.app.questions.practice.LinkedList.ListNode;

public class MergeTwoSortedList {
	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode result = new ListNode(Integer.MAX_VALUE);
		ListNode tmp = result;

		ListNode tmp1 = l1;
		ListNode tmp2 = l2;

		while (tmp1 != null && tmp2 != null) {
			ListNode curr = null;
			if (tmp1.val < tmp2.val) {
				curr = tmp1;
				tmp1 = tmp1.next;
			} else {
				curr = tmp2;
				tmp2 = tmp2.next;
			}
			curr.next = null;
			tmp.next = curr;
			tmp = tmp.next;
		}

		if (tmp1 != null)
			tmp.next = tmp1;

		if (tmp2 != null)
			tmp.next = tmp2;

		result = result.next;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
