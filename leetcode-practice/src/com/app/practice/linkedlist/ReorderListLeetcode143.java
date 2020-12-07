package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class ReorderListLeetcode143 {
	private static ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	private static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		
		while(curr != null) {
			next = curr.next;
			
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
		return head;
	}
	
	private static void reorderList(ListNode head) {
		if(head == null || head.next == null)
			return;
		ListNode mid = findMid(head);
		
		ListNode midNext = mid.next;
		mid.next = null;
		
		midNext = reverseList(midNext);
		
		ListNode result = new ListNode(Integer.MAX_VALUE);
		ListNode tmp1 = head;
		ListNode tmp2 = midNext;
		ListNode tmp = result;
		
		while(tmp1 != null && tmp2 != null) {
			ListNode curr = tmp1;
			tmp1 = tmp1.next;
			curr.next = null;
			
			tmp.next = curr;
			tmp = tmp.next;
			
			curr = tmp2;
			tmp2 = tmp2.next;
			curr.next = null;
			
			tmp.next = curr;
			tmp = tmp.next;
		}
		
		if(tmp1 != null) {
			tmp.next = tmp1;
			tmp = tmp.next;
			tmp1 = tmp1.next;
		}
		
		result = result.next;
		head = result;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		
		reorderList(ll.head);
		
		ListNode temp = ll.head;
		
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}