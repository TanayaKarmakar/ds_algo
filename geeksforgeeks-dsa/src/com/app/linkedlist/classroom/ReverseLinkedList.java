package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

public class ReverseLinkedList {
	private static void reverseListAnotherApproach(LinkedList ll) {
		Node prev = null;
		Node curr = ll.head;
		
		while(curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		ll.head = prev;
		traverseList(ll);
	}
	
	private static void reverseList(LinkedList ll) {
		if(ll.head == null)
			return;
		Node r = ll.head;
		Node s;
		
		while(r.next != null) {
			s = r.next;
			r.next = s.next;
			s.next = null;
			s.next = ll.head;
			ll.head = s;
		}
		
		traverseList(ll);
	}
	
	private static void traverseList(LinkedList ll) {
		Node tmp = ll.head;
		
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.insertAtEnd(15);
		ll.insertAtEnd(20);
		ll.insertAtEnd(25);
		ll.insertAtEnd(30);
		ll.insertAtEnd(35);
		
		reverseList(ll);
		
		ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.insertAtEnd(15);
		ll.insertAtEnd(20);
		ll.insertAtEnd(25);
		ll.insertAtEnd(30);
		ll.insertAtEnd(35);
		
		System.out.println("Reverse a linkedlist using another approach ");
		reverseListAnotherApproach(ll);
	}

}
