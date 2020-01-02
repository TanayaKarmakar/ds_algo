package com.app.linkedlist.classroom;

import java.util.HashMap;
import java.util.Map;

import com.app.linkedlist.classroom.LinkedList1.Node;

class LinkedList1 {
	Node head;
	
	public LinkedList1() {
		
	}
	
	public LinkedList1(Node head) {
		this.head = head;
	}
	
	static class Node {
		int data;
		Node next;
		Node random;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.random = null;
		}
	}
	
	public void insertAtEnd(int data) {
		Node tmp = new Node(data);
		if (head == null) {
			head = tmp;
		} else {
			Node t = head;
			while (t.next != null) {
				t = t.next;
			}
			t.next = tmp;
		}
	}

	public void displayList() {
		Node tmp = head;
		while (tmp != null) {
//			System.out.print(tmp.data + " ");
//			tmp = tmp.next;
			System.out.print("Current Node Data - " + tmp.data);
			if(tmp.next != null) {
				System.out.print(": Next Pointer - " + tmp.next.data);
			} else {
				System.out.print(": Next Pointer is null");
			}
			if(tmp.random != null) {
				System.out.print(": Random Pointer - " + tmp.random.data);
			} else {
				System.out.print(": Random Pointer is null");
			}
			System.out.println();
			tmp = tmp.next;
		}
		System.out.println();
	}
}

public class CopyLinkedListWithNextAndRandomPointer {
	private static LinkedList1 clone(Node head) {
		Node origCurr = head;
		Node clonedCurr = null;
		
		Map<Node, Node> nodeMap = new HashMap<>();
		
		while(origCurr != null) {
			clonedCurr = new Node(origCurr.data);
			nodeMap.put(origCurr, clonedCurr);
			origCurr = origCurr.next;
		}
		
		origCurr = head;
		while(origCurr != null) {
			clonedCurr = nodeMap.get(origCurr);
			clonedCurr.next = nodeMap.get(origCurr.next);
			clonedCurr.random = nodeMap.get(origCurr.next);
			origCurr = origCurr.next;
		}
		
		return new LinkedList1(nodeMap.get(head));
	}

	public static void main(String[] args) {
		LinkedList1 ll = new LinkedList1();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		
		ll.head.random = ll.head.next.next;
		ll.head.next.random = ll.head.next.next.next;
		
		ll.head.next.next.random = ll.head.next.next.next.next;
		ll.head.next.next.next.random = ll.head.next.next.next.next.next;
		ll.head.next.next.next.next.random = ll.head.next;
		
		LinkedList1 ll1 = clone(ll.head);
		ll1.displayList();

	}

}
