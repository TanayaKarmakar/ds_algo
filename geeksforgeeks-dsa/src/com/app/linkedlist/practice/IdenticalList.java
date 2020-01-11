package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class IdenticalList {
	private static boolean isIdentical(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;
		
		while(temp1 != null && temp2 != null) {
			if(temp1.data != temp2.data)
				return false;
			if(temp1 == null || temp2 == null)
				return false;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		
		return true;
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.insertAtEnd(1);
		ll1.insertAtEnd(2);
		ll1.insertAtEnd(3);
		ll1.insertAtEnd(4);
		ll1.insertAtEnd(5);
		
		LinkedList ll2 = new LinkedList();
		ll2.insertAtEnd(99);
		ll2.insertAtEnd(59);
		ll2.insertAtEnd(42);
		ll2.insertAtEnd(20);
		
		System.out.println(isIdentical(ll1.head, ll2.head));
		
		ll2 = new LinkedList();
		ll2.insertAtEnd(1);
		ll2.insertAtEnd(2);
		ll2.insertAtEnd(3);
		ll2.insertAtEnd(4);
		ll2.insertAtEnd(5);
		
		System.out.println(isIdentical(ll1.head, ll2.head));
	}

}
