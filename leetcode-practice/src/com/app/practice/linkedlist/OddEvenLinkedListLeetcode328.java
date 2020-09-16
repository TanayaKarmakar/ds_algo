package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class OddEvenLinkedListLeetcode328 {
	private static ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode tmp = head;
		int i = 1;
		ListNode odd = new ListNode(Integer.MAX_VALUE);
		ListNode even = new ListNode(Integer.MAX_VALUE);
		
		ListNode tmp1 = odd;
		ListNode tmp2 = even;
		
		while(tmp != null) {
			ListNode curr = tmp;
			tmp = tmp.next;
			curr.next = null;
			if(i % 2 == 0) {
				tmp2.next = curr;
				tmp2 = tmp2.next;
			} else {
				tmp1.next = curr;
				tmp1 = tmp1.next;
			}
			i++;
		}
		
		odd = odd.next;
		even = even.next;
		tmp1.next = even;
		return odd;
	}
	
	private static void displayList(ListNode head) {
		ListNode tmp = head;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(2);
		ll.head.next = new ListNode(1);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(5);
		ll.head.next.next.next.next = new ListNode(6);
		ll.head.next.next.next.next.next = new ListNode(4);
		ll.head.next.next.next.next.next.next = new ListNode(7);
		
		ll.head = oddEvenList(ll.head);
		
		displayList(ll.head);
	}

}
