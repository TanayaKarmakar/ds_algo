package com.app.questions.linkedlist;

import com.app.questions.linkedlist.LinkedList.Node;

public class StartingPointOfCycle {
	private static Node detectCycle(Node head) {
		if(head == null || head.next == null)
			return head;
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		
		if(slow != fast)
			return null;
		
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
