package com.app.list;

import java.util.Arrays;

import com.app.list.LinkedList.Node;

public class InsertNode {
	
	private static Node afterNthNodeFromEnd(Node head, int nodeVal, int nVal) {
		Node slowPtr = head;
		Node fastPtr = head;
		Node prev = head;
		int j = nVal;
		while(j > 1) {
			fastPtr = fastPtr.next;
			j--;
		}
		while(fastPtr.next != null) {
			prev = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		Node node = new Node(nodeVal);
		node.next = slowPtr;
		prev.next = node;
		return head;
	}

	public static void main(String[] args) {
		LinkedList list = LinkedListFactory.createListFrom(Arrays.asList(1,3,4,5));
		list.head = afterNthNodeFromEnd(list.head, 2, 3);
		LinkedListUtils.print(list.head);

	}

}
