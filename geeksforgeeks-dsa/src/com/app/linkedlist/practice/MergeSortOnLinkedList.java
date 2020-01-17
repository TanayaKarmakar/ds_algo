package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class MergeSortOnLinkedList {
	private static Node getMiddle(Node head) {
		if (head == null || head.next == null)
			return head;
		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private static Node merge(Node a, Node b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		Node result;

		if (a.data <= b.data) {
			result = a;
			result.next = merge(a.next, b);
		} else {
			result = b;
			result.next = merge(a, b.next);
		}
		return result;
	}

	private static Node mergeSort(Node head) {
		if (head == null || head.next == null)
			return head;

		Node middle = getMiddle(head);
		Node nextMiddle = middle.next;

		middle.next = null;

		Node left = mergeSort(head);
		Node right = mergeSort(nextMiddle);

		Node result = merge(left, right);
		return result;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(15);
		ll.insertAtEnd(10);
		ll.insertAtEnd(5);
		ll.insertAtEnd(20);
		ll.insertAtEnd(3);
		ll.insertAtEnd(2);

		ll.head = mergeSort(ll.head);

		ll.displayList();
	}

}
