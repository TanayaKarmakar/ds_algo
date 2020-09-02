package com.app.practice.map;

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
	private static Node copyRandomList(Node head) {
		Node temp = head;
		Map<Node, Node> nodeMap = new HashMap<>();
		while(temp != null) {
			Node newNode = new Node(temp.val);
			nodeMap.put(temp, newNode);
			temp = temp.next;
		}
		
		temp = head;
		while(temp != null) {
			nodeMap.get(temp).next = nodeMap.get(temp.next);
			nodeMap.get(temp).random = nodeMap.get(temp.random);
			temp = temp.next;
		}
		
		return nodeMap.get(head);
	}

	public static void main(String[] args) {
		Node node10 = new Node(10);
		Node node5 = new Node(5);
		Node node20 = new Node(20);
		Node node15 = new Node(15);
		Node node20_1 = new Node(20);
		
		
		node10.next = node5;
		node5.next = node20;
		node20.next = node15;
		node15.next = node20_1;
		
		node10.random = node20;
		node20.random = node10;
		node5.random = node15;
		node15.random = node20;
		node20_1.random = node15;
		
		node10 = copyRandomList(node10);
		
		Node tmp = node10;
		while(tmp != null) {
			System.out.print("Current Node - " + tmp.val);
			if(tmp.next != null) {
				System.out.print(": Next Node - " + tmp.next.val);
			} else {
				System.out.print(": Next Node - " + null);
			}
			if(tmp.random != null) {
				System.out.print(": Random Node - " + tmp.random.val);
			} else {
				System.out.print(": Random Node - " + null);
			}
			System.out.println();
			tmp = tmp.next;
		}

	}

}
