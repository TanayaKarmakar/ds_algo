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
		
		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode tmpRes = res;
		
		ListNode tmp1 = head;
		ListNode tmp2 = midNext;
		
		ListNode curr = null;
		while(tmp1 != null && tmp2 != null) {
			curr = tmp1;
			tmp1 = tmp1.next;
			curr.next = null;
			tmpRes.next = curr;
			tmpRes = tmpRes.next;
			
			curr = tmp2;
			tmp2 = tmp2.next;
			curr.next = null;
			tmpRes.next = curr;
			tmpRes = tmpRes.next;
		}
		
		if(tmp1 != null) {
			tmpRes.next = tmp1;
			tmpRes = tmpRes.next;
			tmpRes.next = null;
		}
		
		res = res.next;
		head = res;
	}

	private static void displayList(ListNode head) {
		ListNode tmp = head;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		
		System.out.println();
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
