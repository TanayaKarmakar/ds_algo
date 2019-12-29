package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

public class MiddleOfALinkedList {
	private static void findMiddleAlternative(LinkedList list) {
		Node temp = list.head;
		Node middle = list.head;
		
		int count = 0;
		while(temp != null) {
			if((count & 1) == 1) {
				middle = middle.next;
			}
			temp = temp.next;
			++count;
		}
		
		System.out.println("Middle node is - " + middle.data);
	}
	
	private static void findMiddleNode(LinkedList list) {
		Node slowPtr = list.head;
		Node fastPtr = list.head;
		
		while(fastPtr !=null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		
		System.out.println("Middle Node is - " + slowPtr.data);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtEnd(10);
		list.insertAtEnd(15);
		list.insertAtEnd(20);
		list.insertAtEnd(25);
		list.insertAtEnd(30);
		
		findMiddleNode(list);
		findMiddleAlternative(list);
		
		list.insertAtEnd(35);
		findMiddleNode(list);
		findMiddleAlternative(list);
	}

}
