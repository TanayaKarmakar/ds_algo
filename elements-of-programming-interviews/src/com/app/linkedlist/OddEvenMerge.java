package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class OddEvenMerge {
	private static ListNode oddEvenMerge(ListNode head) {
		ListNode tmp = head;
		ListNode odd = new ListNode(Integer.MAX_VALUE);
		ListNode even = new ListNode(Integer.MAX_VALUE);

		ListNode oddTmp = odd;
		ListNode evenTmp = even;

		int indx = 0;
		while (tmp != null) {
			ListNode curr = tmp;
			tmp = tmp.next;
			curr.next = null;
			if (indx % 2 != 0) {
				oddTmp.next = curr;
				oddTmp = oddTmp.next;
			} else {
				evenTmp.next = curr;
				evenTmp = evenTmp.next;
			}
			indx++;
		}
		even = even.next;
		odd = odd.next;
		evenTmp.next = odd;
		return even;

	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(0);
		ll.head.next = new ListNode(1);
		ll.head.next.next = new ListNode(2);
		ll.head.next.next.next = new ListNode(3);
		
		ll.head = oddEvenMerge(ll.head);
		
		ll.displayList(ll.head);

	}

}
