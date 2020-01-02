package com.app.linkedlist.classroom;

import java.util.HashSet;
import java.util.Set;

import com.app.linkedlist.classroom.LinkedList.Node;

public class LoopDetection {
	// this method destroys the linked list
	//by modifying the pointer
	private static boolean isLoopExistsMethod2(Node head) {
		Node dummy = new Node(Integer.MAX_VALUE);
		
		Node tmp = head;
		
		while(tmp != null) {
			if(tmp.next == dummy)
				return true;
			else {
				Node prev = tmp;
				tmp = tmp.next;
				prev.next = dummy;
			}
		}
		
		return false;
	}
	
	
	//this method needs modification of the Node structure
	// adding one extra field called visited
	private static boolean isLoopExistsMethod1(Node head) {
		if(head == null || head.next == null)
			return false;
		
		Node tmp = head;
		while(tmp != null) {
			if(tmp.visited)
				return true;
			else {
				tmp.visited = true;
				tmp = tmp.next;
			}
		}
		return false;
	}
	
	private static boolean isLoopExists(Node head) {
		if(head == null || head.next == null)
			return false;
		
		Set<Node> valueSet = new HashSet<>();
		
		Node tmp = head;
		while(tmp != null) {
			if(valueSet.contains(tmp))
				return true;
			else
				valueSet.add(tmp);
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
		
		System.out.println("Loop exists - " + isLoopExists(ll.head));
		//System.out.println("Loop exists - " + isLoopExistsMethod1(ll.head));
		//System.out.println("Loop exists - " + isLoopExistsMethod2(ll.head));
		
		ll = new LinkedList();
		System.out.println("Loop Exists - " + isLoopExists(ll.head));
		//System.out.println("Loop exists - " + isLoopExistsMethod1(ll.head));
		//System.out.println("Loop exists - " + isLoopExistsMethod2(ll.head));
		
		ll.insertAtEnd(10);
		ll.insertAtEnd(20);
		System.out.println("Loop Exists - " + isLoopExists(ll.head));
		//System.out.println("Loop exists - " + isLoopExistsMethod1(ll.head));
		//System.out.println("Loop exists - " + isLoopExistsMethod2(ll.head));
		
		ll = new LinkedList();
		ll.insertAtEnd(15);
		//tmp1 = tmp1.next;
		ll.insertAtEnd(10);
		//tmp1 = tmp1.next;
		ll.insertAtEnd(12);
		//tmp1 = tmp1.next;
		ll.insertAtEnd(20);
		//tmp1 = tmp1.next;
		
		Node tmp1 = ll.head;
		while(tmp1.next != null) {
			tmp1 = tmp1.next;
		}
		
		tmp1.next = ll.head.next;
		System.out.println("Loop exists - " + isLoopExistsMethod2(ll.head));
	}

}
