package com.app.questions;


import com.app.questions.LinkedList;
import com.app.questions.LinkedList.Node;

public class SortList {
	private static Node findMid(Node head) {
		Node slowPtr = head;
		Node fastPtr = head;
		
		while(fastPtr.next != null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}
	
	private static Node merge(Node left, Node right) {
		if(left == null)
			return right;
		if(right == null)
			return left;
		Node result;
		if(left.data <= right.data) {
			result = left;
			result.next = merge(left.next, right);
		} else {
			result = right;
			result.next = merge(left, right.next);
		}
		return result;
	}
	
	private static Node sortList(Node head) {
		if(head == null || head.next == null)
			return head;
		Node mid = findMid(head);
		Node midNext = mid.next;
		mid.next = null;
		Node left = sortList(head);
		Node right = sortList(midNext);
		return merge(left, right);
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(4);
		ll.insertAtEnd(2);
		ll.insertAtEnd(1);
		ll.insertAtEnd(3);
		
		ll.head = sortList(ll.head);
		
		ll.display();

	}

}
