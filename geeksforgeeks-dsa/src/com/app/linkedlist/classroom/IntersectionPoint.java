package com.app.linkedlist.classroom;

import java.util.HashSet;
import java.util.Set;

import com.app.linkedlist.classroom.LinkedList.Node;

public class IntersectionPoint {
	private static int noOfNodes(Node head) {
		int count = 0;
		Node node = head;
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	
	private static int intersectionPointApproach2(Node head1, Node head2) {
		int count1 = noOfNodes(head1);
		int count2 = noOfNodes(head2);
		
		int diff = Math.abs(count1 - count2);
		
		Node tmp;
		
		if(count1 < count2) {
			tmp = head1;
			head1 = head2;
			head2 = tmp;
		}
		
		Node curr1 = head1;
		Node curr2 = head2;
		
		while(diff > 0) {
			curr1 = curr1.next;
			diff--;
		}
		
		while(curr1 != null && curr2 != null) {
			if(curr1 == curr2)
				return curr1.data;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return Integer.MAX_VALUE;
	}
	
	private static int intersectionPointApproach1(Node head1, Node head2) {
		Set<Node> nodeSet = new HashSet<>();
		Node tmp = head1;
		while(tmp != null) {
			nodeSet.add(tmp);
			tmp = tmp.next;
		}
		
		tmp = head2;
		while(tmp != null) {
			if(nodeSet.contains(tmp))
				return tmp.data;
			else 
				nodeSet.add(tmp);
			tmp = tmp.next;
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.insertAtEnd(14);
		ll.insertAtEnd(12);
		ll.insertAtEnd(13);
		ll.insertAtEnd(5);
		ll.insertAtEnd(17);
		
		Node intersection = ll.head;
		while(intersection.data != 13) {
			intersection = intersection.next;
		}
		
		Node tmp;
		LinkedList ll1 = new LinkedList();
		ll1.insertAtEnd(9);
		
		tmp = ll1.head;
		tmp.next = intersection;
		
		System.out.println("Intersection Point Approach1 - " + 
				intersectionPointApproach1(ll.head, ll1.head));
		
		System.out.println("Intersection Point Approach2 - " +
				intersectionPointApproach2(ll.head, ll1.head));

	}

}
