package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class IntersectionPointYShaped {
	private static int findLen(Node head) {
		if(head == null)
			return 0;
		if(head.next == null)
			return 1;
		Node tmp = head;
		
		int count = 0;
		while(tmp != null) {
			count++;
			tmp = tmp.next;
		}
		
		return count;
	}
	private static int findIntersectionPoint(Node head1, Node head2) {
		int m = findLen(head1);
		int n = findLen(head2);
		
		int diff = Math.abs(m - n);
		Node tmp = head1;
		if(m < n) {
			tmp = head1;
			head1 = head2;
			head2 = tmp;
		} 
		
		while(diff > 0) {
			tmp = tmp.next;
			diff--;
		}
		
		Node tmp1 = head2;
		while(tmp != null && tmp1 != null) {
			if(tmp.next == tmp1.next)
				return tmp.next.data;
			tmp = tmp.next;
			tmp1 = tmp1.next;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.insertAtEnd(3);
		ll1.insertAtEnd(6);
		ll1.insertAtEnd(9);
		ll1.insertAtEnd(15);
		ll1.insertAtEnd(30);
		
		Node tmp = ll1.head.next.next.next;
		
		LinkedList ll2 = new LinkedList();
		ll2.insertAtEnd(10);
		ll2.head.next = tmp;
		
		System.out.println("Intersection point - " + findIntersectionPoint(ll1.head, ll2.head));
	
	}

}
