package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.DoublyLinkedList;
import com.app.linkedlist.classroom.DoublyLinkedList.Node;

public class MergeSortOnDoublyLinkedList {
	private static Node getMiddle(Node head) {
		Node fast = head;
		Node slow = head;
		
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private static Node sortedMerge(Node a, Node b) {
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		Node result;
		if(a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		result.prev = null;
		result.next.prev = result;
		return result;
	}
	
	private static Node mergeSort(Node node) {
		if(node == null || node.next == null)
			return node;
		Node middle = getMiddle(node);
		Node nextMiddle = middle.next;
		middle.next = null;
		nextMiddle.prev = null;
		Node left = mergeSort(node);
		Node right = mergeSort(nextMiddle);
		Node result = sortedMerge(left, right);
		return result;
		
	}
	
	private static Node getLastNode(Node head) {
		Node tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		return tmp;
	}

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertAtEnd(4);
		dll.insertAtEnd(3);
		dll.insertAtEnd(6);
		dll.insertAtEnd(7);
		dll.insertAtEnd(1);
		dll.insertAtEnd(2);
		dll.insertAtEnd(5);
		
		Node result = mergeSort(dll.head);
		DoublyLinkedList dll1 = new DoublyLinkedList();
		dll1.head = result;
		
		dll1.traverseLeftToRight(dll1.head);
		Node last = getLastNode(dll1.head);
		
		dll1.traverseRightToLeft(last);
		
		dll = new DoublyLinkedList();
		dll.insertAtEnd(119);
		dll.insertAtEnd(160);
		dll.insertAtEnd(390);
		dll.insertAtEnd(947);
		dll.insertAtEnd(604);
		dll.insertAtEnd(251);
		
		result = mergeSort(dll.head);
		dll1 = new DoublyLinkedList();
		dll1.head = result;
		
		dll1.traverseLeftToRight(dll1.head);
		last = getLastNode(dll1.head);
		dll1.traverseRightToLeft(last);
		
		
		

	}

}
