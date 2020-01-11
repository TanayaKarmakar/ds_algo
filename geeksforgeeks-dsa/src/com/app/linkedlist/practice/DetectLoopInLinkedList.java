package com.app.linkedlist.practice;

import java.util.HashSet;
import java.util.Set;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class DetectLoopInLinkedList {
	private static boolean hasLoop(Node head) {
		Set<Node> nodeSet = new HashSet<>();

		Node tmp = head;

		while (tmp != null) {
			if (nodeSet.contains(tmp))
				return true;
			nodeSet.add(tmp);
			tmp = tmp.next;
		}

		return false;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.insertAtEnd(20);
		ll.insertAtEnd(30);

		
		Node tmp = ll.head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = ll.head;
		
		System.out.println(hasLoop(ll.head));

	}

}
