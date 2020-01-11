package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class RemoveLoop {
	private static void removeLoop(Node head) {
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			if(slow == fast)
				break;
			slow = slow.next;
		}
		
		if(slow != fast)
			return;
		
		slow = head;
		while(slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		
		fast.next = null;
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
		
		Node tmp = ll.head.next;
		Node last = ll.head;
		
		while(last.next != null) {
			last = last.next;
		}
		last.next = tmp;
		
		removeLoop(ll.head);
		
		ll.displayList();
		
	}

}
