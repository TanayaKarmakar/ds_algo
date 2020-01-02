package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

public class DeleteARandomNode {
	private static void deleteARandomNode(Node node) {
		node.data = node.next.data;
		if (node.next.next != null) {
			node.next = node.next.next;
		} else {
			node.next = null;
		}
	}

	private static void displayList(Node head) {
		Node tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.insertAtEnd(15);
		ll.insertAtEnd(5);
		ll.insertAtEnd(25);
		ll.insertAtEnd(20);
		ll.insertAtEnd(30);

		Node tmp = ll.head;
		while (tmp.data != 25) {
			tmp = tmp.next;
		}

		System.out.println("Before deletion, the node is ");
		displayList(ll.head);
		// System.out.println(tmp.data);
		deleteARandomNode(tmp);

		System.out.println("After deletion, the node is ");
		displayList(ll.head);
	}

}
