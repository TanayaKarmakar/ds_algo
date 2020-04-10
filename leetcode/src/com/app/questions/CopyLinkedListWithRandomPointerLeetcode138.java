package com.app.questions;

import java.util.HashMap;
import java.util.Map;

class Node138 {
	int val;
	Node138 next;
	Node138 random;
	
	public Node138(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
	
	public String toString() {
		return "value " + this.val;
	}
}

public class CopyLinkedListWithRandomPointerLeetcode138 {
	private static Node138 copyRandomList(Node138 head) {
		if(head == null)
			return head;
		Node138 head1 = null;
		Node138 temp1 = null;
		Map<Node138, Node138> map = new HashMap<>();
		Node138 temp = head;
		while(temp != null) {
			Node138 newNode = new Node138(temp.val);
			map.put(temp, newNode);
			temp = temp.next;
		}
		
		temp = head;
		while(temp != null) {
			Node138 newNode = map.get(temp);
			newNode.next = map.get(temp.next);
			newNode.random = map.get(temp.random);
			temp = temp.next;
		}
		
		return head1;
	}

	public static void main(String[] args) {
		Node138 node7 = new Node138(7);
		Node138 node13 = new Node138(13);
		Node138 node11 = new Node138(11);
		Node138 node10 = new Node138(10);
		Node138 node1 = new Node138(1);
		
		
		node7.next = node13;
		node13.next = node11;
		node11.next = node10;
		node10.next = node1;
		
		node13.random = node7;
		node10.random = node11;
		node1.random = node7;
		node7.random = null;
		
		Node138 head = copyRandomList(node7);

	}

}
