package com.app.julychallenge;

import com.app.questions.practice.LinkedList;
import com.app.questions.practice.LinkedList.ListNode;

public class RemoveLinkedListElements {
	private static ListNode removeElements(ListNode head, int val) {
		if(head == null)
			return null;
		else if(head.next == null) {
			if(head.val == val)
				return null;
			else
				return head;
		}
		
		ListNode tmp = head;
		while(tmp != null) {
			if(tmp == head && tmp.val == val) {
				head = head.next;
				tmp = head;
				continue;
			} else if(tmp.next != null && tmp.next.val == val) {
				ListNode p = tmp.next;
				while(p != null && p.val == val) {
					p = p.next;
				}
				tmp.next = p;
			}
			tmp = tmp.next;
		}
		
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(1);
//		ll.head.next.next = new ListNode(6);
//		ll.head.next.next.next = new ListNode(3);
//		ll.head.next.next.next.next = new ListNode(4);
//		ll.head.next.next.next.next.next = new ListNode(5);
//		ll.head.next.next.next.next.next.next = new ListNode(6);
	
		ll.head = removeElements(ll.head, 1);
		
		ListNode tmp = ll.head;
		
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
	}

}
