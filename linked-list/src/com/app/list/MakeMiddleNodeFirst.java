package com.app.list;

import java.util.Arrays;

import com.app.list.LinkedList.Node;

public class MakeMiddleNodeFirst {
	private static Node makeMiddleNodeAsHead(Node head) {
		Node prev = head;
		Node slowPtr = head;
		Node fastPtr = head.next;

		while (fastPtr != null) {
			fastPtr = fastPtr.next;
			if (fastPtr != null) {
				prev = slowPtr;
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
		}
		
		prev.next = slowPtr.next;
		slowPtr.next = null;
		slowPtr.next = head;
		head = slowPtr;
		return head;
		
	}

	public static void main(String[] args) {
		LinkedList list = LinkedListFactory.createListFrom(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		list.head = makeMiddleNodeAsHead(list.head);
		
		LinkedListUtils.print(list.head);
	}

}
