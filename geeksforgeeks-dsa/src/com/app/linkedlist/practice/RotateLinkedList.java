package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class RotateLinkedList {
	private static Node rotateList(Node head, int k) {
		if(head == null)
			return head;
			//return;
		
		int cnt = k;
		Node prev = head;
		Node curr = head;
		
		while(curr != null && cnt > 0) {
			prev = curr;
			curr = curr.next;
			cnt--;
		}
		if(curr == null)
			return head;
		
		
		Node tmp = curr;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		
		tmp.next = head;
		head = curr;
		prev.next = null;
		
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
		ll.insertAtEnd(8);
		

		//ll.head = rotateList(ll.head, 4);
		ll.head = rotateList(ll.head, 4);
		ll.displayList();
	}

}
