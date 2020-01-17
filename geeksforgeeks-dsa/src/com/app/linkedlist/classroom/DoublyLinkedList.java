package com.app.linkedlist.classroom;

public class DoublyLinkedList {
	public Node head;

	public static class Node {
		public int data;
		public Node next;
		public Node prev;

		public Node(int data) {
			this.data = data;
			this.prev = this.next = null;
		}
	}
	
	public void insertAtEnd(int data) {
		 Node node = new Node(data);
		 if(head == null) {
			 head = node;
		 } else {
			 Node tmp = head;
			 while(tmp.next != null) {
				 tmp = tmp.next;
			 }
			 tmp.next = node;
			 node.prev = tmp;
		 }
	}
	
	public void traverseLeftToRight(Node head) {
		Node tmp = head;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
	
	public void traverseRightToLeft(Node last) {
		Node tmp = last;
		
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.prev;
		}
		
		System.out.println();
	}
}
