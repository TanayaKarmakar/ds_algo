package com.app.linkedlist;

public class LinkedList {
	public ListNode head;
	
	public static class ListNode {
		public int val;
		public ListNode next;
		
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	
	public void displayList(ListNode head) {
		ListNode tmp = head;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		
		System.out.println();
	}
}
