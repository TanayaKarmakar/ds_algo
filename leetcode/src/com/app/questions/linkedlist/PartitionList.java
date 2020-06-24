package com.app.questions.linkedlist;

import com.app.questions.linkedlist.LinkedList.Node;

public class PartitionList {
	private static Node partition(Node head, int x) {
		if (head == null || head.next == null)
			return head;
		Node tmp = head;
		Node left = new Node(Integer.MIN_VALUE);
		Node right = new Node(Integer.MAX_VALUE);

		Node leftTmp = left;
		Node rightTmp = right;

		while (tmp != null) {
			if (tmp.data < x) {
				leftTmp.next = tmp;
				leftTmp = leftTmp.next;
			} else {
				rightTmp.next = tmp;
				rightTmp = rightTmp.next;
			}
			tmp = tmp.next;
		}
		leftTmp.next = null;
		rightTmp.next = null;
		if(left.next != null && right.next != null) {
			left = left.next;
			right = right.next;
			leftTmp.next = right;
		} else {
			if(left.next == null) {
				//right = right.next;
				left = right;
			}
			left = left.next;
		}
		return left;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
//		ll.insertAtEnd(1);
//		ll.insertAtEnd(4);
//		ll.insertAtEnd(3);
//		ll.insertAtEnd(2);
//		ll.insertAtEnd(5);
//		ll.insertAtEnd(2);
//
//		ll.head = partition(ll.head, 3);
//		ll.display();
//		
//		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(1);
		ll.head = partition(ll.head, 0);
		ll.display();

	}

}
