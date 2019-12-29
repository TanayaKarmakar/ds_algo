package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

public class NthNodeFromTheEnd {
	private static void nThNodeFromTheEnd(LinkedList list, int k) {
		if(list.head == null)
			return;
		Node fast = list.head;
		Node slow = list.head;
		
		while(k > 0) {
			fast = fast.next;
			k--;
		}
		
		if(fast == null)
			return;
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		System.out.println("Data - " + slow.data);
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.insertAtEnd(15);
		ll.insertAtEnd(20);
		ll.insertAtEnd(25);
		ll.insertAtEnd(30);
		ll.insertAtEnd(35);
		
		nThNodeFromTheEnd(ll, 2);

	}

}
