package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class RemoveElementsLeetcode203 {
	private static ListNode removeElements(ListNode head, int target) {
		if(head == null)
			return null;
		if(head.next == null) {
			if(head.val == target)
				return null;
			return head;
		}
		ListNode curr = head;
		ListNode next;
		
		while(curr != null) {
			next = curr.next;
			while(next != null && next.val == target) {
				next = next.next;
			}
			
			curr.next = next;
			curr = next;
		}
		
		if(head.val == target)
			head = head.next;
		
		return head;
	}
	
	private static void displayElements(ListNode head) {
		ListNode tmp = head;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(1);
		ll.head.next.next = new ListNode(1);
//		ll.head.next.next.next = new ListNode(3);
//		ll.head.next.next.next.next = new ListNode(4);
//		ll.head.next.next.next.next.next = new ListNode(5);
//		ll.head.next.next.next.next.next.next = new ListNode(6);
		
		ll.head = removeElements(ll.head, 1);
		
		displayElements(ll.head);

	}

}
