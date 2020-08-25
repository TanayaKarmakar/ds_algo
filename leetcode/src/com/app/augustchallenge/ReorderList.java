package com.app.augustchallenge;

import com.app.questions.practice.LinkedList;
import com.app.questions.practice.LinkedList.ListNode;

public class ReorderList {
	private static ListNode getMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		
		ListNode next;
		
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
		ListNode mid = getMiddle(head);
		ListNode midNext = mid.next;
		mid.next = null;
		
		midNext = reverse(midNext);
		
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		ListNode tmp3 = dummy;
		
		ListNode tmp1 = head;
		ListNode tmp2 = midNext;
		
		ListNode curr;
		
		while(tmp1 != null && tmp2 != null) {
			curr = tmp1;
			tmp1 = tmp1.next;
			curr.next = null;
			tmp3.next = curr;
			tmp3 = tmp3.next;
			
			curr = tmp2;
			tmp2 = tmp2.next;
			curr.next = null;
			tmp3.next = curr;
			tmp3 = tmp3.next;	
		}
		
		//for odd length linked list
		if(tmp1 != null) {
			tmp3.next = tmp1;
			tmp3 = tmp3.next;
		}
		
		dummy = dummy.next;
		head = dummy;
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
		
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		
		
		reorderList(ll.head);
		
		displayList(ll.head);

	}

}
