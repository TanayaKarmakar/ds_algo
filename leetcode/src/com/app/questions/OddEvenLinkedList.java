package com.app.questions;

import com.app.questions.LinkedList.Node;

public class OddEvenLinkedList {
	private static Node oddEven(Node head) {
		Node odd = new Node(Integer.MIN_VALUE);
		Node even = new Node(Integer.MIN_VALUE);
		
		Node oddTmp = odd;
		Node evenTmp = even;
		
		int nodeIndx = 1;
		
		Node tmp = head;
		while(tmp != null) {
			if(nodeIndx % 2 != 0) {
				oddTmp.next = tmp;
				oddTmp = oddTmp.next;
			} else {
				evenTmp.next = tmp;
				evenTmp = evenTmp.next;
			}
			tmp = tmp.next;
			nodeIndx++;
		}
		odd = odd.next;
		even = even.next;
		oddTmp.next = even;
		evenTmp.next = null;
		
		return odd;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		
		ll.head = oddEven(ll.head);
		ll.display();

	}

}
