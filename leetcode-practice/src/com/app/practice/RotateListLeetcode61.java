package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class RotateListLeetcode61 {
	private static ListNode lastNode;
	
	private static int length(ListNode head) {
		ListNode temp = head;
		int len = 0;
		while(temp != null) {
			lastNode = temp;
			len++;
			temp = temp.next;
		}
		return len;
	}
	
	private static ListNode rotateList(ListNode head, int k) {
		lastNode = null;
		int len = length(head);
		
		int finalLen = k % len;
		if(finalLen == 0)
			return head;
		ListNode temp = head;
		
		finalLen = len - finalLen;
		int i = 0;
		while(temp != null && i < finalLen - 1) {
			temp = temp.next;
			i++;
		}
		ListNode next = temp.next;
		temp.next = null;
		
		lastNode.next = head;
		head = next;
		
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		
		ll.head = rotateList(ll.head, 3);
		ListNode temp = ll.head;
		
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}

}
