package com.app.questions;

import com.app.questions.LinkedList.Node;

public class LinkedListCycle {
	private static boolean hasCycle(Node head) {
		if(head == null || head.next == null)
			return false;
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
