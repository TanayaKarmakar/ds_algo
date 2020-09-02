package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class RemoveDuplicatesFromSortedListLeetcode83 {
	private static ListNode deleteDuplicates(ListNode head) {
		ListNode p = head;
		ListNode q;
		
		while(p != null) {
			q = p.next;
			
			while(q != null && p.val == q.val) {
				q = q.next;
			}
			
			p.next = q;
			p = q;
		}
		
		return head;
	}
	
	private static void displayList(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(1);
		ll.head.next.next = new ListNode(2);
		ll.head.next.next.next = new ListNode(3);
		ll.head.next.next.next.next = new ListNode(3);
		
		ll.head = deleteDuplicates(ll.head);
		
		displayList(ll.head);
	}

}
