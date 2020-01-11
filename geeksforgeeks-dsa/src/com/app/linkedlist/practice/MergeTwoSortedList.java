package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class MergeTwoSortedList {
	private static Node mergeLists(Node head1, Node head2) {
		Node dummy = null;
		Node tail = dummy;
		Node tmp1 = head1;
		Node tmp2 = head2;
		Node curr = null;

		while (tmp1 != null && tmp2 != null) {
			if (tmp1.data <= tmp2.data) {
				curr = tmp1;
				tmp1 = tmp1.next;
			} else {
				curr = tmp2;
				tmp2 = tmp2.next;
			}
			curr.next = null;
			if (dummy == null) {
				dummy = curr;
				tail = dummy;
			} else {
				tail.next = curr;
				tail = tail.next;
			}
		}

		if (tmp1 != null) {
			tail.next = tmp1;
		}
		if (tmp2 != null) {
			tail.next = tmp2;
		}

		return dummy;
	}

	private static void displayList(Node head) {
		Node tmp = head;

		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll1 = new LinkedList();
		ll1.insertAtEnd(3);
		ll1.insertAtEnd(6);
		ll1.insertAtEnd(7);
		ll1.insertAtEnd(9);

		LinkedList ll2 = new LinkedList();
		ll2.insertAtEnd(2);
		ll2.insertAtEnd(4);
		ll2.insertAtEnd(8);
		ll2.insertAtEnd(10);
		ll2.insertAtEnd(11);

		Node head = mergeLists(ll1.head, ll2.head);
		
		displayList(head);

	}

}
