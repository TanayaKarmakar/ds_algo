package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

public class SegregateOddEvenNodes {
	private static Node segregateOddEven(Node head) {
		Node es = null;
		Node ee = null;
		Node os = null;
		Node oe = null;

		Node curr = head;
		while (curr != null) {
			int x = curr.data;
			if (x % 2 == 0) {
				if (es == null) {
					es = curr;
					ee = es;
				} else {
					ee.next = curr;
					ee = ee.next;
				}
			} else {
				if (os == null) {
					os = curr;
					oe = os;
				} else {
					oe.next = curr;
					oe = oe.next;
				}
			}
			curr = curr.next;
		}

		if (os == null || es == null)
			return head;
		ee.next = os;
		oe.next = null;
		return es;
	}
	
	private static void displayList(Node node) {
		Node tmp = node;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(15);
		ll.insertAtEnd(13);
		ll.insertAtEnd(12);
		ll.insertAtEnd(8);
		ll.insertAtEnd(17);
		ll.insertAtEnd(10);
		ll.insertAtEnd(19);
		ll.insertAtEnd(4);
		
		Node tmp = segregateOddEven(ll.head);
		displayList(tmp);
	}

}
