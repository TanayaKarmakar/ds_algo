package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

public class ReverseSubList {
	private static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
		return head;
	}
	
	private static ListNode reverseSubList(ListNode head, int s, int f) {
		if(head == null || head.next == null)
			return head;
		ListNode tmp = head;
		ListNode prev = null;
		ListNode sNode = null;
		ListNode fNode = null;
		
		while(tmp != null && tmp.val != s) {
			prev = tmp;
			tmp = tmp.next;
		}
		
		sNode = tmp;
		
		while(tmp != null && tmp.val != f) {
			tmp = tmp.next;
		}
		fNode = tmp;
		
		if(prev != null)
			prev.next = null;
		ListNode fNodeNext = fNode.next;
		fNode.next = null;
		
		ListNode partList = reverseList(sNode);
		
		ListNode finalList = null;
		if(prev != null) {
			finalList = head;
		}
		if(finalList != null) {
			prev.next = partList;
		} else {
			finalList = partList;
		}
		
		if(fNodeNext != null) {
			tmp = finalList;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = fNodeNext;
		}
		
		return finalList;
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(11);
		ll.head.next = new ListNode(3);
		ll.head.next.next = new ListNode(5);
		ll.head.next.next.next = new ListNode(7);
		ll.head.next.next.next.next = new ListNode(2);
		
		ll.head = reverseSubList(ll.head, 11, 2);
		
		ll.displayList(ll.head);

	}

}
