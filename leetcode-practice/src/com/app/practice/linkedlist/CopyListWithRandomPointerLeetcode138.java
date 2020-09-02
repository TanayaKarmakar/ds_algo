package com.app.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
	int val;
	Node next;
	Node random;
	
	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;	
	}
}

public class CopyListWithRandomPointerLeetcode138 {
	private static Node copyList(Node head) {
		Map<Node, Node> nodeMap = new HashMap<>();
		Node temp = head;
		
		while(temp != null) {
			Node newNode = new Node(temp.val);
			nodeMap.put(temp, newNode);
			temp = temp.next;
		}
		
		temp = head;
		while(temp != null) {
			Node newNode = nodeMap.get(temp);
			newNode.next = nodeMap.get(temp.next);
			newNode.random = nodeMap.get(temp.random);
			temp = temp.next;
		}
		
		Node head1 = nodeMap.get(head);
		return head1;
	}

	public static void main(String[] args) {
		

	}

}
