package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class SwappingKNodes {
	private static int size(Node head) {
		Node tmp = head;
		int count = 0;
		while (tmp != null) {
			count++;
			tmp = tmp.next;
		}

		return count;
	}

	private static Node swapKNodes(Node head, int k) {
		int len = size(head);

		if (k > len)
			return head;

		if (2 * k - 1 == len)
			return head;

		int j = k;

		Node left = head;
		Node leftPrev = null;

		while (j > 1) {
			leftPrev = left;
			left = left.next;
			j--;
		}

		j = len - k + 1;
		Node right = head;
		Node rightPrev = null;

		while (j > 1) {
			rightPrev = right;
			right = right.next;
			j--;
		}

		if (leftPrev != null) {
			leftPrev.next = right;
		}

		if (rightPrev != null) {
			rightPrev.next = left;
		}

		Node tmp = left.next;
		left.next = right.next;
		right.next = tmp;

		if (k == 1)
			head = right;
		if (k == len)
			head = left;

		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(6);
		ll.insertAtEnd(7);

		ll.head = swapKNodes(ll.head, 1);

		ll.displayList();
	}

}
