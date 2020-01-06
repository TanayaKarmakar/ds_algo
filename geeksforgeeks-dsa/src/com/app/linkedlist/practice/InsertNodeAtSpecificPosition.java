package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.DoublyLinkedList;
import com.app.linkedlist.classroom.DoublyLinkedList.Node;

public class InsertNodeAtSpecificPosition {
	private static void insertAtSpecificPos(Node head, int data, int pos) {
		if(head == null) {
			if(pos > 0)
				return;
			else {
				Node node = new Node(data);
				head = node;
			}
		} else {
			int count = 0;
			Node tmp = head;
			while(count != pos) {
				++count;
				tmp = tmp.next;
			}
			Node node = new Node(data);
			if(tmp.next == null) {
				node.prev = tmp;
				tmp.next = node;
			} else {
				Node tmpNext = tmp.next;
				node.next = tmpNext;
				tmpNext.prev = node;
				tmp.next = node;
				node.prev = tmp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertAtEnd(10);
		dll.insertAtEnd(20);
		dll.insertAtEnd(30);
		dll.insertAtEnd(40);
		dll.insertAtEnd(50);

		dll.traverseLeftToRight(dll.head);
		
		insertAtSpecificPos(dll.head, 25, 2);
		
		dll.traverseLeftToRight(dll.head);
	}

}
